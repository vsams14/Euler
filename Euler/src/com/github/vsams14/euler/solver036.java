/*
The decimal number, 585 = 1001001001_2 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in 
base 10 and base 2.

(Please note that the palindromic number, in either base, may not include 
leading zeros.)
*/
package com.github.vsams14.euler;

public class solver036 {
	public solver036(){
		find();
	}
	
	private void find(){
		long count = 0;
		for(long i=0; i<1000000L; i++){
			if(utils.isPalindrome(i+"")&&utils.isPalindrome(utils.toBin(i))){
				count+=i;
			}
		}
		utils.println(count+"");
	}
}
