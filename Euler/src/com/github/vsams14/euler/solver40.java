/*
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the 
following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
*/
package com.github.vsams14.euler;

public class solver40 {
	public solver40(){
		find();
	}
	
	private void find(){
		String champ = "";
		for(long count=1; count<=1000000; count++){
			champ += count+"";
			if(count%10000==0)utils.println(count+":"+champ.substring((int)count-1, (int)count));
			if(champ.length()>1000000){
				utils.println(count+":"+champ.substring((int)count-1, (int)count));
				break;
			}
		}
		long d = Integer.parseInt(champ.substring(0,1));
		d*= Integer.parseInt(champ.substring(9,10)); 
		d*= Integer.parseInt(champ.substring(99,100));
		d*= Integer.parseInt(champ.substring(999,1000));
		d*= Integer.parseInt(champ.substring(9999,10000));
		d*= Integer.parseInt(champ.substring(99999,100000));
		d*= Integer.parseInt(champ.substring(999999,1000000)); 
		utils.println(d+"");
	}
}
