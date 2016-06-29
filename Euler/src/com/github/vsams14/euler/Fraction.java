package com.github.vsams14.euler;

import java.util.ArrayList;

public class Fraction {
	private long num;
	private long den;

	public Fraction(long num, long den) {
		this.num = num;
		this.den = den;
	}

	public void addWhole(int times) {
		num += (den * times);
	}

	public void reduce() {
		if (utils.isPrime((int) num) || utils.isPrime((int) den)) {
			return;
		}
		ArrayList<Integer> numFacts = utils.getPrimeFact(num, false);
		ArrayList<Integer> denFacts = utils.getPrimeFact(den, false);
		ArrayList<Integer> sharedFacts = new ArrayList<Integer>();
		for (int i : numFacts) {
			if (denFacts.contains(i)) {
				denFacts.remove((Object) i);
				sharedFacts.add(i);
			}
		}
		if (!sharedFacts.isEmpty()) {
			for (int i : sharedFacts) {
				num /= i;
				den /= i;
			}
			// utils.println("Reduced");
		}
	}

	public void invert() {
		long temp = num;
		num = den;
		den = temp;
	}

	public double toDecimal() {
		return (double) num / (double) den;
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
