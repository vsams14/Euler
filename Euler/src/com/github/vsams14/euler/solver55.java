/*
If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.

Not all numbers produce palindromes so quickly. For example,

349 + 943 = 1292,
1292 + 2921 = 4213
4213 + 3124 = 7337

That is, 349 took three iterations to arrive at a palindrome.

Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome. A number that never forms a palindrome through the reverse and add process is called a Lychrel number. Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that a number is Lychrel until proven otherwise. In addition you are given that for every number below ten-thousand, it will either (i) become a palindrome in less than fifty iterations, or, (ii) no one, with all the computing power that exists, has managed so far to map it to a palindrome. In fact, 10677 is the first number to be shown to require over fifty iterations before producing a palindrome: 4668731596684224866951378664 (53 iterations, 28-digits).

Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.

How many Lychrel numbers are there below ten-thousand?
*/
package com.github.vsams14.euler;

public class solver55 {
	public solver55() {
		find();
	}

	private void find() {
		long count = 0;
		for (long i = 10; i < 10000; i++) {
			try {
				if (isLychrel(i, 1)) {
					utils.println(i + " is a Lychrel number!");
					count++;
				} else {
					utils.println(i + " reaches a palindrome!");
				}
			} catch (NumberFormatException e) {
				utils.println(i + " is a Lychrel number!");
				count++;
			}
		}
		utils.println("There are " + count + " Lychrel numbers below 10000");
	}

	private boolean isLychrel(long i, long iter) throws NumberFormatException {
		if (iter > 50)
			return true;
		i += flip(i);
		if (i == flip(i)) {
			return false;
		} else {
			return (isLychrel(i, iter + 1));
		}
	}

	private long flip(long i) throws NumberFormatException {
		String s = i + "";
		String sprime = "";
		for (int j = 0; j < s.length(); j++) {
			sprime += s.substring(s.length() - 1 - j, s.length() - j);
		}
		return Long.parseLong(sprime);
	}
}
