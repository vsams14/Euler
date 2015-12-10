/*
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in 
attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is 
correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than 
one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find 
the value of the denominator.
*/
package com.github.vsams14.euler;

public class solver33 {
	public solver33(){
		find();
	}
	
	private void find(){
		for(double a=10; a<99; a++){
			for(double b=11; b<100; b++){
				if(a%10==0 || b%10==0)continue;
				double fraction = a/b;
				String[] num = {(a+"").substring(0, 1), (a+"").substring(1, 2)};
				String[] denom = {(b+"").substring(0, 1), (b+"").substring(1, 2)};
				double c=0,d=0,frac2=0;
				if(num[0].equals(denom[0])){
					c = Integer.parseInt(num[1]);
					d = Integer.parseInt(denom[1]);
					frac2 = c/d;
				}else if(num[1].equals(denom[0])){
					c = Integer.parseInt(num[0]);
					d = Integer.parseInt(denom[1]);
					frac2 = c/d;
				}else if(num[0].equals(denom[1])){
					c = Integer.parseInt(num[1]);
					d = Integer.parseInt(denom[0]);
					frac2 = c/d;
				}else if(num[1].equals(denom[1])){
					c = Integer.parseInt(num[0]);
					d = Integer.parseInt(denom[0]);
					frac2 = c/d;
				}
				if(fraction==frac2 && fraction<1.0){
					utils.println(a+"/"+b+" = "+fraction+", "+c+"/"+d+" = "+frac2);
				}
			}
		}
	}
}
