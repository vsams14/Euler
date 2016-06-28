/*
It is possible to show that the square root of two can be expressed as an 
infinite continued fraction.

sqrt(2) = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

By expanding this for the first four iterations, we get:

1 + 1/2 = 3/2 = 1.5
1 + 1/(2 + 1/2) = 7/5 = 1.4
1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

The next three expansions are 99/70, 239/169, and 577/408, but the eighth 
expansion, 1393/985, is the first example where the number of digits in the 
numerator exceeds the number of digits in the denominator.

In the first one-thousand expansions, how many fractions contain a numerator 
with more digits than denominator?
*/
package com.github.vsams14.euler;

import java.math.BigInteger;
import java.util.ArrayList;

public class solver057 {
	public solver057() {
		find();
	}

	private void find() {
		utils.putPrimesToList(1000000);
		int count = 0;
		for (int i = 1; i <= 1000; i++) {
			Fraction f = expandRoot(i);
			utils.print(f+" "+i);
			if (f.numMoreDigits()) {
				count++;
				utils.println(" y");
			}else{
				utils.println();
			}
		}
		utils.println("There are " + count
				+ " number of expansions with more digits in the numerator");
		// expansion is (2.5) invert, + 2, invert, + 2, invert... +1
	}

	private Fraction expandRoot(int times) {
		Fraction f = new Fraction(1, 2);
		times--;
		while (times > 0) {
			f.addWhole(2);
			f.invert();
			times--;
		}
		f.addWhole(1);
		//f.reduce();
		return f;
	}
}

class Fraction {
	private BigInteger num;
	private BigInteger den;

	public Fraction(long num, long den) {
		this.num = new BigInteger(num+"");
		this.den = new BigInteger(den+"");
	}

	public void addWhole(int times) {
		num = num.add(den.multiply(new BigInteger(times+"")));
	}

	public void reduce() {
		ArrayList<Integer> numFacts = utils.getPrimeFact(num.longValueExact(), false);
		ArrayList<Integer> denFacts = utils.getPrimeFact(den.longValueExact(), false);
		ArrayList<Integer> sharedFacts = new ArrayList<Integer>();
		for (int i : numFacts) {
			if (denFacts.contains(i)) {
				denFacts.remove((Object) i);
				sharedFacts.add(i);
			}
		}
		if(!sharedFacts.isEmpty()){
			for (int i : sharedFacts) {
				num = num.divide(new BigInteger(i+""));
				den = den.divide(new BigInteger(i+""));
			}
			//utils.println("Reduced");
		}
	}

	public void invert() {
		BigInteger temp = num;
		num = den;
		den = temp;
	}

	public double toDecimal() {
		return num.doubleValue()/den.doubleValue();
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
