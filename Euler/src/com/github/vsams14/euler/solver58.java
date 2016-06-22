package com.github.vsams14.euler;

public class solver58 {
	public solver58() {
		find();
	}

	private void find() {
		utils.getPrimes();
		float primes = 5;
		float diags = 9;
		int length = 5;
		while (primes / diags > 0.1) {
			length += 2;
			int corner = (length * length);
			length--;
			diags += 4;
			for(int i=1;i<4;i++){
				if(utils.isPrime(corner-i*length)){
					primes++;
					utils.println(corner-i*length + " is prime");
				}
			}
			length++;
		}
		utils.println("Spiral of length " + length + " has " + (int)primes
				+ " primes and " + (int)diags + " diagonals ("
				+ primes / diags + ")");
	}
}
