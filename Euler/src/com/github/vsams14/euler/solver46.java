/*
It was proposed by Christian Goldbach that every odd composite number can be 
written as the sum of a prime and twice a square.

9 = 7 + 2×12
15 = 7 + 2×22
21 = 3 + 2×32
25 = 7 + 2×32
27 = 19 + 2×22
33 = 31 + 2×12

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime 
and twice a square?
*/
package com.github.vsams14.euler;

import java.util.ArrayList;

public class solver46 {
	ArrayList<Long> odds = new ArrayList<Long>();
	
	public solver46(){
		find();
	}
	
	private void find(){
		long n = 100000;
		for(long i=3; i<=n; i+=2)odds.add(i);
		utils.putPrimesToList(0);;
		for(long prime:utils.primes){
			odds.remove(prime);
			for(long i=1; i<=Math.sqrt((n-prime)/2)+1; i++){
				long gold = prime+(2*i*i);
				odds.remove(gold);
			}
		}
		for(long odd:odds)utils.println(odd+" remains");
	}
}
