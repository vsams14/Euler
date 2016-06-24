//primality test using miller-rabin
package com.github.vsams14.euler;

import java.math.BigInteger;

public class solver0 {
	public solver0() {
		find();
	}

	private void find() {
		isPrime(46657);
	}
	
	private static int[] sdBreakup(double test){
		int sd[] = new int[2];
		sd[0]=0;
		sd[1]=0;
		test--;
		while(test/(int)test == 1){
			test/=2.0;
			sd[0]++;
		}
		sd[0]--;
		sd[1]=(int) (test*2);
		return sd;
	}
	
	//deterministic using a=2,3,5,7 up to 3215031751 > 2^31-1
	private static boolean isPrime(int test){
		int sd[] = sdBreakup(test);
		utils.println(sd[0]+"\t"+sd[1]);
		if(modTest(2,sd,test)){
			if(modTest(3,sd,test)){
				if(modTest(5,sd,test)){
					if(modTest(7,sd,test)){
						if(modTest(13,sd,test)){
							utils.println(test+" is prime");
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	private static boolean modTest(int a, int[] sd, int test){
		for(int r=0;r<sd[0];r++){
			int power = sd[1] * (int) Math.pow(2, r);
			BigInteger big = new BigInteger(a+"");
			big = big.modPow(new BigInteger(power+""), new BigInteger(test+""));
			utils.println(a+"^"+power+"\t"+big);
			if (big.toString().equals("1")||big.toString().equals(test-1+"")){
				return true;
			}
		}
		return false;
	}
}
