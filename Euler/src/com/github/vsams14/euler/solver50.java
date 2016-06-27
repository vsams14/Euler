/*
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below 
one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, 
contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most 
consecutive primes?
*/
package com.github.vsams14.euler;

public class solver50 {
	public solver50(){
		find();
	}
	
	private void find(){
		utils.putPrimesToList(1000000);
		int maxCons = 0;
		long maxPrime = 0;
		for(int prime:utils.primes){
			int n = sumOfPrimes(prime);
			if(n>0){
				if(n>maxCons){
					maxCons = n;
					maxPrime = prime;
					//utils.println(maxPrime+" is sum of "+maxCons+" consecutive primes");
				}
			}
		}
		utils.println(maxPrime+" is sum of "+maxCons+" consecutive primes");
	}
	
	private int sumOfPrimes(int n){
		int max = utils.primes.indexOf(n);
		int start = 0;
		int pos;
		while(start<max){
			long sum = 0;
			pos = start;
			while(sum<n){
				sum+=utils.primes.get(pos);
				pos++;
			}
			if(sum==n)return (pos-start);
			start++;
		}
		return 0;
	}
}
