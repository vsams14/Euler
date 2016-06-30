/*
 * Consider the divisors of 30: 1,2,3,5,6,10,15,30.
 * It can be seen that for every divisor d of 30, d+30/d is prime.
 * 
 * Find the sum of all positive integers n not exceeding 100 000 000
 * such that for every divisor d of n, d+n/d is prime.
 */

package com.github.vsams14.euler;

public class solver357 {
	public solver357() {
		find();
	}

	private void find() {
		long sum = 1;
		for (int i = 2; i <= 100000000; i += 4) {
			if (utils.isPrime(i + 1)) {
				int root = (int) Math.sqrt(i);
				for (int d = 2; d <= root + 1; d++) {
					if (d == root + 1) {
						sum += i;
						break;
					}
					if (i % d != 0)
						continue;
					if (!utils.isPrime(d + (i / d)))
						break;
				}
			}
		}
		utils.println(sum);
	}
}
