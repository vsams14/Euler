/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible
permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically 
or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
*/
package com.github.vsams14.euler;

public class solver024 {
	long count = 1;
	
	public solver024(){
		find();
	}
	
	private void find(){
		long i;
		String s="";
		for(i=123456789L; i<=9876543210L; i++){
			if(i<1000000000){
				s="0"+i+"";
			}else{
				s=i+"";
			}
			if(utils.isPan(s)){
				if(count%100000L==0)utils.println(count+":"+s);
				count++;
			}
		}
		utils.println(count+":"+s);
	}
}
