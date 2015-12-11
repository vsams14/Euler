package com.github.vsams14.euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class utils {
	public static ArrayList<Long> primes = new ArrayList<Long>();
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
	
	public static void getPrimes(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("primes.txt")));
			String line;
			while((line=br.readLine()) != null){ //&& count<50){
				if(hasNum(line)){
					long p = Long.parseLong(line);
					primes.add(p);
				}
			}
			br.close();
			println("Primes Loaded");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static boolean hasNum(String s){
		if(s.contains("1")||s.contains("2")||s.contains("3")
				||s.contains("4")||s.contains("5")||s.contains("6")||s.contains("7")
				||s.contains("8")||s.contains("9")||s.contains("0"))return true;
		return false;
	}
	
	public static boolean isPrime(long test){
		if(primes.contains(test))return true;
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
