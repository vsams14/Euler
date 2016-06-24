/*
The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
*/
package com.github.vsams14.euler;

public class solver47 {
	public solver47(){
		find();
	}
	
	private void find(){
		utils.putPrimesToList(0);
		long a=210,b,c,d;
		boolean solved=false;
		while(!solved){
			b=a+1; c=a+2; d=a+3;
			if(utils.getUniqueFacts(a)==4&&utils.getUniqueFacts(b)==4&&utils.getUniqueFacts(c)==4&&utils.getUniqueFacts(d)==4){
				utils.println(a+":"+b+":"+c+":"+d);
				solved=true;
			}
			if(!solved)a++;
		}
	}
}
