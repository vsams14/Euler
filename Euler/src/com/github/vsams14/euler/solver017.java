/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 
3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many 
letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 
23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing 
out numbers is in compliance with British usage.
*/
package com.github.vsams14.euler;

public class solver017 {
	String nums = "";
	
	public solver017(){
		find();
	}
	
	private void find(){
		for(int i=1; i<1000; i++){
			if(i<21){
				nums+=utils.getWord(i);
			}else if(i>=21&&i<100){
				int tens = Integer.parseInt((i+"").substring(0, 1)) * 10;
				int ones = Integer.parseInt((i+"").substring(1, 2));
				nums+=utils.getWord(tens)+utils.getWord(ones);
			}else if(i>=100){
				int hundreds = Integer.parseInt((i+"").substring(0, 1));
				int tens = Integer.parseInt((i+"").substring(1, 2)) * 10;
				int ones = Integer.parseInt((i+"").substring(2, 3));
				nums+=utils.getWord(hundreds)+"hundred";
				if(tens==0&&ones==0){					
				}else if(tens+ones<21){
					nums+="and"+utils.getWord(tens+ones);
				}else if(tens+ones>=21){
					nums+="and"+utils.getWord(tens)+utils.getWord(ones);
				}
			}
		}
		nums+="onethousand";
		utils.println(nums.length()+"");
	}
}
