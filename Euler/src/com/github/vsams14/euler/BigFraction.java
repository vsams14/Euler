package com.github.vsams14.euler;

import java.math.BigInteger;
import java.util.ArrayList;

public class BigFraction {
	private BigInteger num;
	private BigInteger den;

	public BigFraction(long num, long den) {
		this.num = new BigInteger(num + "");
		this.den = new BigInteger(den + "");
	}

	public void addWhole(int times) {
		num = num.add(den.multiply(new BigInteger(times + "")));
	}

	public void reduce() {
		ArrayList<Integer> numFacts = utils.getPrimeFact(num.longValueExact(),
				false);
		ArrayList<Integer> denFacts = utils.getPrimeFact(den.longValueExact(),
				false);
		ArrayList<Integer> sharedFacts = new ArrayList<Integer>();
		for (int i : numFacts) {
			if (denFacts.contains(i)) {
				denFacts.remove((Object) i);
				sharedFacts.add(i);
			}
		}
		if (!sharedFacts.isEmpty()) {
			for (int i : sharedFacts) {
				num = num.divide(new BigInteger(i + ""));
				den = den.divide(new BigInteger(i + ""));
			}
			// utils.println("Reduced");
		}
	}

	public void invert() {
		BigInteger temp = num;
		num = den;
		den = temp;
	}

	public double toDecimal() {
		return num.doubleValue() / den.doubleValue();
	}

	public boolean numMoreDigits() {
		if ((num + "").length() > (den + "").length())
			return true;
		return false;
	}

	public String toString() {
		return (num + "/" + den + " = " + toDecimal());
	}
}
