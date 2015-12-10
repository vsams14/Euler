/*
The following iterative sequence is defined for the set of positive integers:

n -> n/2 (n is even)
n -> 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/

package com.github.vsams14.euler;

public class solver14 {
	long collatz;
	long chain = 0;
	long start = 1;
	
	public solver14(){
		find();
	}
	
	private void find(){
		for(long i = 0; i<1000000; i++){
			long count = 0;
			collatz = i;
			count++;
			while(collatz>1){
				collatz = rule(collatz);
				count++;
			}
			if(count>chain){
				chain = count;
				start = i;
			}
		}
		utils.println("Longest Chain: "+chain+" from "+start);
	}
	
	private long rule(long l){
		int bin = (int)(l%2L);
		switch(bin){
		case 0:
			return l/2L;
		case 1:
			return 3L*l + 1L;
		default:
			return l;
		}
	}
}
