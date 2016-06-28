/*
 * Starting with the number 1 and moving to the right in a clockwise direction a
 * 5 by 5 spiral is formed as follows:
 * 
 * 21 22 23 24 25
 * 20 7 8 9 10
 * 19 6 1 2 11
 * 18 5 4 3 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 */
package com.github.vsams14.euler;

public class solver028 {
	long[][] spiral = new long[1001][1001];
	long sum = 0;

	public solver028() {
		find();
	}

	private void find() {
		generate();
		for (int x = 0; x < spiral.length; x++) {
			sum += spiral[x][x];
		}
		for (int x = 0; x < spiral.length; x++) {
			sum += spiral[x][1000 - x];
		}
		sum--;
		utils.println(sum + "");
	}

	private void generate() {
		for (int x = 0; x < spiral.length; x++) {
			for (int y = 0; y < spiral[0].length; y++) {
				spiral[x][y] = 0;
			}
		}
		int x = 500, y = 500;
		long c = 1;
		int length = 2;
		int dir = 0;
		while (c < 1002000L) {
			switch (dir) {
			case 0:
				for (int i = x; i < x + length && i < spiral.length; i++) {
					spiral[i][y] = c;
					c++;
				}
				c--;
				x += length - 1;
				dir++;
				break;
			case 1:
				for (int i = y; i < y + length && i < spiral.length; i++) {
					spiral[x][i] = c;
					c++;
				}
				c--;
				y += length - 1;
				dir++;
				length++;
				break;
			case 2:
				for (int i = x; i > x - length && i >= 0; i--) {
					spiral[i][y] = c;
					c++;
				}
				c--;
				x -= length - 1;
				dir++;
				break;
			case 3:
				for (int i = y; i > y - length && i >= 0; i--) {
					spiral[x][i] = c;
					c++;
				}
				c--;
				y -= length - 1;
				dir = 0;
				length++;
				break;
			}
		}
	}
}
