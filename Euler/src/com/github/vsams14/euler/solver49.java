/*
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: 
(i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but 
there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?
*/
package com.github.vsams14.euler;

public class solver49 {
	public solver49(){
		find();
	}
	
	private void find(){
		utils.getPrimes();
		long a, b, prime;
		for(int j=utils.primes.indexOf(1009L); j<utils.primes.indexOf(9973L); j++){
			a=utils.primes.get(j);
			for(int i=j+1; i<utils.primes.indexOf(9973L); i++){
				prime = utils.primes.get(i);
				b=2*prime-a;
				if(b>9999)break;
				if(isPerm(a,prime,b)){
					if(utils.isPrime(b))utils.println(a+","+prime+","+b+":"+(prime-a));		
				}
			}
		}
	}
	
	private boolean isPerm(long a, long b, long c){
		String s = a+"";
		String t = b+"";
		String u = c+"";
		String[] d={s.substring(0, 1), s.substring(1, 2), s.substring(2, 3), s.substring(3, 4)};
		String[] e={t.substring(0, 1), t.substring(1, 2), t.substring(2, 3), t.substring(3, 4)};
		String[] f={u.substring(0, 1), u.substring(1, 2), u.substring(2, 3), u.substring(3, 4)};
		for(int i=0; i<4; i++){
			if(!t.contains(d[i]))return false;
			if(!u.contains(d[i]))return false;
			
			if(!s.contains(e[i]))return false;
			if(!u.contains(e[i]))return false;
			
			if(!s.contains(f[i]))return false;
			if(!t.contains(f[i]))return false;
		}
		return true;
	}
}
