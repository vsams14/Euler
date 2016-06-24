/*
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
*/
package com.github.vsams14.euler;

public class solver35 {
	public solver35(){
		find();
	}
	
	private void find(){
		utils.putPrimesToList(0);
		String rot;
		int count = 0;
		boolean isCirc = false;
		for(int prime:utils.primes){
			if(prime<10){
				count++;
				utils.println(prime);
				continue;
			}
			rot = prime+"";
			for(int i=0; i<rot.length()-1; i++){
				rot = ccwRotate(rot);
				if(utils.isPrime(Integer.parseInt(rot))){
					isCirc=true;
				}else{
					isCirc=false;
					break;
				}
			}
			if(isCirc){
				count++;
				utils.println(prime);
			}
		}
		utils.println(count);
	}
	
	private String ccwRotate(String s){
		return s.substring(1) + s.substring(0, 1);
	}
}
