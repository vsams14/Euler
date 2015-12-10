/*
A perfect number is a number for which the sum of its proper divisors is exactly 
equal to the number. For example, the sum of the proper divisors of 28 would be 
1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and 
it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number 
that can be written as the sum of two abundant numbers is 24. By mathematical analysis, 
it can be shown that all integers greater than 28123 can be written as the sum of two 
abundant numbers. However, this upper limit cannot be reduced any further by analysis 
even though it is known that the greatest number that cannot be expressed as the sum of 
two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two 
abundant numbers. (1 to 28123)
*/
package com.github.vsams14.euler;

import java.util.ArrayList;
import java.util.HashMap;

public class solver23 {
	
	HashMap<Integer, Integer> abundant = new HashMap<Integer, Integer>();
	ArrayList<Integer> sums = new ArrayList<Integer>();
	
	public solver23(){
		find();
	}
	
	private void find(){
		int count = 1;
		for(int a = 12; a<=28123; a++){
			int b=utils.divsum(a);
			if(b>a){
				abundant.put(count, a);
				count++;
			}
		}
		utils.println("Generated Abundant #s");
		for(count=1; count<=abundant.size(); count++){
			for(int a=count; a<=abundant.size(); a++){
				int b=abundant.get(count)+abundant.get(a);
				if(b<=28123&&!sums.contains(b)){
					sums.add(b);
				}
			}
			if(count%((int)abundant.size()/10)==0)utils.print(".");
		}
		
		utils.println("\nGenerated Sums");
		long nasum = 0;
		for(count=1;count<=28123;count++){
			if(!sums.contains(count)){
				nasum+=count;
			}
		}
		utils.println(nasum+"");
	}
}
