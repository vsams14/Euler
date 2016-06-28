/*
A googol (10^100) is a massive number: one followed by one-hundred zeros; 
100^100 is almost unimaginably large: one followed by two-hundred zeros. 
Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?
*/
package com.github.vsams14.euler;

import java.math.BigInteger;

public class solver056 {
	public solver056() {
		find();
	}

	private void find() {
		int maxSum = 0;
		int maxA=0;
		int maxB=0;
		for (int a = 1; a < 100; a++) {
			for (int b = 1; b < 100; b++) {
				BigInteger big = new BigInteger(a + "");
				big = big.pow(b);
				int sum = sumOfDigits(big.toString());
				if (sum > maxSum){
					maxSum = sum;
					maxA=a;
					maxB=b;
				}
			}
		}
		utils.println("maximum sum is "+maxSum+" for "+maxA+"^"+maxB);
	}

	private int sumOfDigits(String s) {
		int sum=0;
		for(int i=0;i<s.length();i++){
			sum+=Integer.parseInt(s.substring(i,i+1));
		}
		return sum;
	}
}
