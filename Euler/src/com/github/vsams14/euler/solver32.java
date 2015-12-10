/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 
1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand,
multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can 
be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include 
it once in your sum.
*/
package com.github.vsams14.euler;

import java.util.ArrayList;

public class solver32 {
	ArrayList<Integer> products = new ArrayList<Integer>();
	
	public solver32(){
		find();
	}
	
	private void find(){
		for(int a=1; a<50; a++){
			for(int b=1; b<2000; b++){
				if(utils.isPan(a+""+b+""+(a*b))){
					if(!products.contains(a*b))products.add(a*b);
				}
			}
		}
		int sum = 0;
		for(int i:products){
			sum+=i;
		}
		utils.println(sum+"");
	}
}
