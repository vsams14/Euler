/*
 * Consider the fraction, n/d, where n and d are positive integers. If n<d and
 * HCF(n,d)=1, it is called a reduced proper fraction.
 * 
 * If we list the set of reduced proper fractions for d <= 8 in ascending order
 * of size, we get:
 * 
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3,
 * 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * 
 * It can be seen that 2/5 is the fraction immediately to the left of 3/7.
 * 
 * By listing the set of reduced proper fractions for d <= 1,000,000 in
 * ascending order of size, find the numerator of the fraction immediately to
 * the left of 3/7.
 */

package com.github.vsams14.euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class solver071 {
	public solver071() {
		find();
	}

	private void find() {
		utils.putPrimesToList(1000000);
		HashMap<Double, String> fracs = new HashMap<Double, String>();
		for (int i = 2; i <= 1000000; i++) {
			for (int j = (int) (.428571 * i); j < i; j++) {
				double value = (double) j / (double) i;
				if (value > .42857143) {
					break;
				} else if (value > .428571 && fracs.get(value) == null) {
					String f = j + "/" + i;
					fracs.put(value, f);
					// utils.println("putting " + f);
				}
			}
		}
		ArrayList<Double> keys = new ArrayList<Double>(fracs.keySet());
		Collections.sort(keys);
		for (double d : keys) {
			if (d > 0.4285712)
				utils.println(d + " = " + fracs.get(d));
		}
	}
}
