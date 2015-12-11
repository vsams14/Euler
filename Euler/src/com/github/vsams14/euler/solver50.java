/*
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
*/
package com.github.vsams14.euler;

public class solver50 {
	public solver50(){
		find();
	}
	
	private void find(){
		long lsum = 2;
		utils.getPrimes();
		int start = 0;
		while(utils.primes.get(start)<999983){
			long sum=0;
			for(int i=start; i<utils.primes.size(); i++){
				sum+=utils.primes.get(i);
				if(!utils.isPrime(sum)){
					if((i-1)!=start)utils.println(utils.primes.get(start)+" to "+utils.primes.get(i-1)+"="+(sum-utils.primes.get(i)));
					break;
				}
				if(sum>lsum&&i!=start&&sum<1000000)lsum=sum;
			}
			start++;
		}
		utils.println(lsum);
	}
}
