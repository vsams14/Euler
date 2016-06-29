/*
 * Euler's Totient function, phi(n), is used to determine the amount of numbers
 * less than n which are relatively prime to n. For example, as 1, 2, 4, 5, 7,
 * and 8, are all less than nine and relatively prime to nine, phi(9)=6.
 * 
 * n Relatively Prime phi(n) n/phi(n)
 * 2 1 1 2
 * 3 1,2 2 1.5
 * 4 1,3 2 2
 * 5 1,2,3,4 4 1.25
 * 6 1,5 2 3
 * 7 1,2,3,4,5,6 6 1.1666...
 * 8 1,3,5,7 4 2
 * 9 1,2,4,5,7,8 6 1.5
 * 10 1,3,7,9 4 2.5
 * It can be seen that n=6 produces a maximum n/phi(n) for n <= 10.
 * 
 * Find the value of n <= 1,000,000 for which n/phi(n) is a maximum.
 */
package com.github.vsams14.euler;

import java.util.ArrayList;

public class solver069 {
	public solver069() {
		find();
	}

	private void find() {
		utils.putPrimesToList(1000000);
		double mn = 6, mdiv = 3, mp = 2;
		for (double n = 2; n <= 1000000; n++) {
			double p = Math.round(phi(n) * n);
			double np = n / p;
			utils.println("At n=" + n + ", phi=" + p + " n/phi=" + np);
			if (np > mdiv) {
				mn = n;
				mp = p;
				mdiv = n / p;
			}
		}
		utils.println("Max n/p at n=" + mn + " phi=" + mp + " n/phi=" + mdiv);
	}

	private double phi(double n) {
		double sum = 1;
		ArrayList<Integer> pFacts = utils.getPrimeFact((int) n, false);
		ArrayList<Integer> uniqueFacts = new ArrayList<Integer>();
		for (int factor : pFacts) {
			if (!uniqueFacts.contains(factor)) {
				uniqueFacts.add(factor);
			}
		}
		for (double factor : uniqueFacts) {
			sum *= ((factor - 1) / factor);
		}
		return sum;
	}
}
