/*
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
*/
package com.github.vsams14.euler;

import java.math.BigInteger;

public class solver48 {
	public solver48(){
		find();
	}
	private void find(){
		BigInteger sum = new BigInteger("1");
		for(int i=2; i<=1000; i++){
			utils.println("Adding "+i+"^"+i);
			BigInteger p = new BigInteger(i+"");
			sum = sum.add(p.pow(i));
		}
		String res = sum.toString();
		utils.println(res.substring(res.length()-10, res.length()));
	}
}
