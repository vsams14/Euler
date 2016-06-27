package com.github.vsams14.euler;

public class solver58 {
	public solver58() {
		find();
	}

	private void find() {
		float primes = 3;
		int length = 2;
		int corner = 9;
		while (primes / (2*length-1) > 0.10) {
			length += 2;
			for(int i=1;i<4;i++){
				corner+=length;
				if(utils.isPrime(corner)){
					primes++;
				}
			}
			corner += length;
		}
		utils.println("Spiral of length " + (length+1) + " has " + (int)primes
				+ " primes and " + (2*length-1) + " diagonals ("
				+ primes / (2*length-1) + ")");
	}
}
