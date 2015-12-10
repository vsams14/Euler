/*
Surprisingly there are only three numbers that can be written as the sum of fourth 
powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
*/
package com.github.vsams14.euler;

public class solver30 {
	long total = 0;
	
	public solver30(){
		find();
	}
	
	private void find(){
		String s;
		long sum;
		for(int i=10; i<999999; i++){
			s = i+"";
			sum = 0;
			for(int j=0;j<s.length();j++){
				sum += Math.pow(Integer.parseInt(s.substring(j, j+1)), 5);
			}
			if(sum==i){
				utils.println(s+":"+sum);
				total+=sum;
			}
		}
		utils.println(total+"");
	}
}
