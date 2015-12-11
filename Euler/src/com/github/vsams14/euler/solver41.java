/*
We shall say that an n-digit number is pandigital if it makes use of all the 
digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is 
also prime.

What is the largest n-digit pandigital prime that exists?
*/
package com.github.vsams14.euler;

public class solver41 {
	public solver41(){
		find();
	}
	
	private void find(){
		utils.getPrimes();
		for(long i = 7654321L; i>1; i--){
			if(utils.isPan(i+"")){
					utils.println(i+"");
				if(utils.isPrime(i)){
					utils.println(i+" is prime!");
					break;
				}
			}
		}
	}
}
