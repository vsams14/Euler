/*
 * A number chain is created by continuously adding the square of the digits in
 * a number to form a new number until it has been seen before. For example,
 * 
 * 44 -> 32 -> 13 -> 10 -> 1 -> 1
 * 85 -> 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89
 * 
 * Therefore any chain that arrives at 1 or 89 will become stuck in an endless
 * loop. What is most amazing is that EVERY starting number will eventually
 * arrive at 1 or 89. How many starting numbers below ten million will arrive at
 * 89?
 */

package com.github.vsams14.euler;

public class solver092 {
	public solver092() {
		find();
	}

	private void find() {
		int count = 0;
		for (int i = 1; i < 10000000; i++) {
			if (!isHappy(i)) {
				count++;
			}
		}
		utils.println(count + " unhappy numbers below 1e7");
	}

	private boolean isHappy(int i) {
		if (i == 44 || i == 32 || i == 13 || i == 10 || i == 1) {
			return true;
		} else if (i == 85 || i == 89 || i == 145 || i == 42 || i == 20
				|| i == 4 || i == 16 || i == 37 || i == 58) {
			return false;
		}
		int squareSum = 0;
		char[] c = (i + "").toCharArray();
		for (char ch : c) {
			int digit = Integer.parseInt(ch + "");
			squareSum += digit * digit;
		}
		return isHappy(squareSum);
	}
}
