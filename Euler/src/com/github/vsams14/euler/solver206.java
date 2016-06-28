/*
 * Find the unique positive integer whose square has the form
 * 1_2_3_4_5_6_7_8_9_0, where each "_" is a single digit.
 */
package com.github.vsams14.euler;

import java.math.BigInteger;

public class solver206 {
	public solver206() {
		find();
	}

	private void find() {
		BigInteger big = new BigInteger("1010101030");
		while (true) {
			String c = big.pow(2).toString();
			if (c.length() == 19) {
				if (c.replaceAll("(.).?", "$1").equals("1234567890")) {
					utils.println(big + "^2 is " + c);
					break;
				}
				String s = big.toString();
				utils.println(big + "^2 is " + c);
				if (s.substring(s.length() - 2).equals("30")) {
					big = big.add(new BigInteger("40"));
				} else {
					big = big.add(new BigInteger("60"));
				}
			} else {
				break;
			}
		}
	}
}
