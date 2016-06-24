package com.github.vsams14.euler;

import java.math.BigInteger;
import java.util.ArrayList;

public class utils {
	private static int arPrimes[] = new int[100000001];
	public static ArrayList<Integer> primes = new ArrayList<Integer>();
	private static long n;
	public static long startTime;
	
	public static String getWord(int i){
		switch(i){
		case 1: return "one";
		case 2: return "two";
		case 3: return "three";
		case 4: return "four";
		case 5: return "five";
		case 6: return "six";
		case 7: return "seven";
		case 8: return "eight";
		case 9: return "nine";
		case 10: return "ten";
		case 11: return "eleven";
		case 12: return "twelve";
		case 13: return "thirteen";
		case 14: return "fourteen";
		case 15: return "fifteen";
		case 16: return "sixteen";
		case 17: return "seventeen";
		case 18: return "eighteen";
		case 19: return "nineteen";
		case 20: return "twenty";
		case 30: return "thirty";
		case 40: return "forty";
		case 50: return "fifty";
		case 60: return "sixty";
		case 70: return "seventy";
		case 80: return "eighty";
		case 90: return "ninety";
		}
		return "";
	}
	
	public static int divsum(int a){
		int sum = 0;
		for(int i=1; i<a; i++){
			if(a%i==0){
				sum+=i;
			}
		}
		return sum;
	}
	
	public static int wordScore(String s){
		int sum=0;
		for(int i=0; i<s.length(); i++){
			sum+=letterScore(s.substring(i,i+1));
		}
		return sum;
	}
	
	private static int letterScore(String s){
		switch(s){
		case "A": return 1;
		case "B": return 2;
		case "C": return 3;
		case "D": return 4;
		case "E": return 5;
		case "F": return 6;
		case "G": return 7;
		case "H": return 8;
		case "I": return 9;
		case "J": return 10;
		case "K": return 11;
		case "L": return 12;
		case "M": return 13;
		case "N": return 14;
		case "O": return 15;
		case "P": return 16;
		case "Q": return 17;
		case "R": return 18;
		case "S": return 19;
		case "T": return 20;
		case "U": return 21;
		case "V": return 22;
		case "W": return 23;
		case "X": return 24;
		case "Y": return 25;
		case "Z": return 26;
		}
		return 0;
	}
	
	public static boolean isPan(String s){
		switch(s.length()){
		case 9:{
			if(s.contains("1")&&s.contains("2")&&s.contains("3")
					&&s.contains("4")&&s.contains("5")&&s.contains("6")&&s.contains("7")
					&&s.contains("8")&&s.contains("9"))return true;break;}
		case 8:{
			if(s.contains("1")&&s.contains("2")&&s.contains("3")
					&&s.contains("4")&&s.contains("5")&&s.contains("6")&&s.contains("7")
					&&s.contains("8"))return true;break;}
		case 7:{
			if(s.contains("1")&&s.contains("2")&&s.contains("3")
					&&s.contains("4")&&s.contains("5")&&s.contains("6")&&s.contains("7"))return true;break;}
		case 6:{
			if(s.contains("1")&&s.contains("2")&&s.contains("3")
					&&s.contains("4")&&s.contains("5")&&s.contains("6"))return true;break;}
		case 5:{
			if(s.contains("1")&&s.contains("2")&&s.contains("3")
					&&s.contains("4")&&s.contains("5"))return true;break;}
		case 4:{
			if(s.contains("1")&&s.contains("2")&&s.contains("3")
					&&s.contains("4"))return true;break;}
		case 3:{
			if(s.contains("1")&&s.contains("2")&&s.contains("3"))return true;break;}
		case 2:{
			if(s.contains("1")&&s.contains("2"))return true;break;}
		}
		return false;
	}
	
	private static void getPrimes(){
		int limit = 50000000;
		int cp[] = new int[limit+1];
		for(int i=1;i<=limit;i++){
			cp[i]=i;
			arPrimes[i]=0;
		}
		for(int i=limit+1;i<=2*limit;i++){
			arPrimes[i]=0;
		}
		for(int i=1;i<=limit/2;i++){
			for(int j=1;j<=(limit-i)/(2*i+1);j++){
				int nprime = i+j+2*i*j;
				if(cp[nprime]!=0){
					cp[nprime]=0;
				}
			}
		}
		
		for(int i=1;i<=limit;i++){
			if(cp[i]!=0){
				arPrimes[2*i+1]=2*i+1;
			}
		}
		arPrimes[2]=2;
		println("Primes Generated");
		startTime = System.currentTimeMillis();;
	}
	
	public static void putPrimesToList(int sel){//0:small 1:medium 2:large
		getPrimes();
		int limit=0;
		switch(sel){
		case 0:
			limit=1000000;
			break;
		case 1:
			limit=50000000;
			break;
		case 2:
			limit=100000000;
		}
		for(int i:arPrimes){
			if(i!=0 && i<limit){
				primes.add(i);
			}
		}
		println("Primes in list");
		startTime = System.currentTimeMillis();
	}
	
	@SuppressWarnings("unused")
	private static boolean hasNum(String s){
		if(s.contains("1")||s.contains("2")||s.contains("3")
				||s.contains("4")||s.contains("5")||s.contains("6")||s.contains("7")
				||s.contains("8")||s.contains("9")||s.contains("0"))return true;
		return false;
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
	public static boolean isPrime(int test){
		int sd[] = sdBreakup(test);
		//replace with a from 2 to 2ln(n)^2
		if(modTest(2,sd,test)){
			if(modTest(13,sd,test)){
				if(modTest(17,sd,test)){
					if(modTest(37,sd,test)){
						if(modTest(61,sd,test)){
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
			if (big.toString().equals("1")||big.toString().equals(test-1+"")){
				return true;
			}
		}
		return false;
	}
	
	public static String toBin(long n) {
        String remainder;

        if (n <= 1) {
            return n+"";
        }

        remainder=toBin(n >> 1)+n%2;
        return remainder+"";
    }
	
	public static boolean isPalindrome(String s){
		for(int i=0; i<s.length()/2; i++){
			if(!s.substring(i,i+1).equals(s.substring(s.length()-(i+1),
					s.length()-i)))return false;
		}
		return true;
	}
	
	public static long factorial(int i){
		long fact = 1;
		for(int j=i; j>1; j--){
			fact*=j;
		}
		return fact;
	}
	
	public static boolean isPent(long x){
		double n = (Math.sqrt(24*x + 1) + 1)/6;
		if((int)n == n){
			return true;
		}
		return false;
	}
	
	private static ArrayList<Long> primeFactors(){
		ArrayList<Long> factors = new ArrayList<Long>();
		for(long prime:utils.primes){
			if(n==1)break;
			if(n%prime==0){
				n/=prime;
				factors.add( prime);
				factors.addAll(primeFactors());
			}
		}
		return factors;
	}
	
	public static ArrayList<Long> getPrimeFact(long f, boolean print){
		n = f;
		ArrayList<Long> facts = primeFactors();
		if(print)printList(facts);
		return facts;
	}
	
	public static int uniqueFacts(ArrayList<Long> t){
		int count = 0;
		@SuppressWarnings("unchecked")
		ArrayList<Long> copy = (ArrayList<Long>) t.clone();
		for(long i:t){
			if(copy.isEmpty())break;
			if(!copy.contains(i))continue;
			count++;
			while(copy.contains(i))copy.remove(i);
		}
		return count;
	}
	
	public static int getUniqueFacts(long n){
		return uniqueFacts(getPrimeFact(n, false));
	}
	
	public static void printList(ArrayList<Long> t){
		for(long i:t){
			println(i);
		}
		println();
	}
	
	public static long pent(long n){
		return n*(3*n-1)/2;
	}
	
	public static void print(String s){
		System.out.print(s);
	}
	
	public static void print(Object o){
		System.out.print(o.toString());
	}
	
	public static void println(Object o){
		System.out.println(o.toString());
	}
	
	public static void println(String s){
		System.out.println(s);
	}
	
	public static void println(){
		System.out.println();
	}
}
