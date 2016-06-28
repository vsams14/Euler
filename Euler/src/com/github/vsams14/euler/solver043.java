/*
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.
*/
package com.github.vsams14.euler;

public class solver043 {
	long sum = 0;
	
	public solver043(){
		find();
	}
	
	private void find(){
		for(long i=123456789L; i<=9876543210L; i++){
			String s;
			if(i<1000000000){
				s="0"+i+"";
			}else{
				s=i+"";
			}
			if(s.contains("0")&&s.contains("1")&&s.contains("2")&&s.contains("3")
					&&s.contains("4")&&s.contains("5")&&s.contains("6")&&s.contains("7")
					&&s.contains("8")&&s.contains("9")&&isDivisible(s)){
				sum+=Long.parseLong(s);
				utils.println(""+s);
			}
		}
		utils.println(sum+"");
	}
	
	private boolean isDivisible(String s){
		int d24 = Integer.parseInt(s.substring(1,4));
		int d35 = Integer.parseInt(s.substring(2,5));
		int d46 = Integer.parseInt(s.substring(3,6));
		int d57 = Integer.parseInt(s.substring(4,7));
		int d68 = Integer.parseInt(s.substring(5,8));
		int d79 = Integer.parseInt(s.substring(6,9));
		int d810 = Integer.parseInt(s.substring(7,10));
		if(d24%2!=0)return false;
		if(d35%3!=0)return false;
		if(d46%5!=0)return false;
		if(d57%7!=0)return false;
		if(d68%11!=0)return false;
		if(d79%13!=0)return false;
		if(d810%17!=0)return false;
		return true;
	}
}
