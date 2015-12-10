/*
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
(9999999 > 9! * 7
*/
package com.github.vsams14.euler;

public class solver34 {
	public solver34(){
		find();
	}
	
	private void find(){
		String s;
		long fsum;
		for(int i=10; i<9999999; i++){
			s = i+"";
			fsum = 0;
			for(int j=0;j<s.length();j++){
				fsum += utils.factorial(Integer.parseInt(s.substring(j, j+1)));
			}
			if(fsum==i)utils.println(s+":"+fsum);
		}
	}
}
