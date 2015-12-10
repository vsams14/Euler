/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n 
which divide evenly into n).
If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each 
of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; 
therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
*/

package com.github.vsams14.euler;

import java.util.ArrayList;

public class solver21 {
	ArrayList<Integer> list = new ArrayList<Integer>();
	long sum = 0;
	
	public solver21(){
		find();
	}
	
	private void find(){
		for(int a=4; a<10000; a++){
			int b = utils.divsum(a);
			if(utils.divsum(b) == a && a!=b){
				if(!list.contains(a)){
					list.add(a);
					sum+=a;
				}
				if(!list.contains(b)){
					list.add(b);
					sum+=b;
				}
			}
		}
		utils.println(sum+"");
	}
}
