/*
The number 3797 has an interesting property. Being prime itself, it is possible 
to continuously remove digits from left to right, and remain prime at each 
stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 
379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to 
right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
*/
package com.github.vsams14.euler;

public class solver37 {
	public solver37(){
		find();
	}
	
	private void find(){
		utils.putPrimesToList(0);
		for(long prime:utils.primes){
			if(prime<10)continue;
			String s = prime+"";
			String[] tLeft = new String[s.length()];
			String[] tRight = new String[s.length()];
			tLeft[0] = s;
			tRight[0] = s;
			//utils.print(s);
			for(int i=1; i<s.length(); i++){
				tLeft[i] = truncateLeft(tLeft[i-1]);
				tRight[i] = truncateRight(tRight[i-1]);
				//utils.print(":"+tLeft[i]);
			}
			int count = 0;
			//utils.print(":");
			for(int i=1; i<s.length(); i++){
				//utils.print(":"+tRight[i]);
				if(!utils.isPrime(Integer.parseInt(tLeft[i])))break;
				if(!utils.isPrime(Integer.parseInt(tRight[i])))break;
				count++;
			}
			//utils.println();
			if(count==s.length()-1){
				utils.println(s+" is a truncatable prime");
			}
		}
	}
	
	private String truncateLeft(String s){
		return s.substring(1);
	}
	
	private String truncateRight(String s){
		return s.substring(0, s.length()-1);
	}
}
