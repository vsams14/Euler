/*
The nth term of the sequence of triangle numbers is given by, tn = n(n+1)/2; 
so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its 
alphabetical position and adding these values we form a word value. For example,
the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle 
number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file 
containing nearly two-thousand common English words, how many are triangle words?
*/
package com.github.vsams14.euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class solver42 {
	ArrayList<Integer> tri = new ArrayList<Integer>();
	int count = 0;
	
	public solver42(){
		find();
	}
	
	private void find(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("words.txt")));
			String line;
			String p[]={};
			while((line=br.readLine()) != null){
				p = line.split("\",\"");
			}
			p[0] = p[0].substring(1, p[0].length());
			p[p.length-1] = p[p.length-1].substring(0, p[p.length-1].length()-1);
			
			for(int i=1; i<30; i++){
				tri.add(tri(i));
			}
			
			for(int i=0; i<p.length; i++){
				if(tri.contains(wordScore(p[i])))count++;
			}
			utils.println(count+"");
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int tri(int n){
		return (n*(n+1))/2;
	}
	
	private int wordScore(String s){
		int sum=0;
		for(int i=0; i<s.length(); i++){
			sum+=letterScore(s.substring(i,i+1));
		}
		return sum;
	}
	
	private int letterScore(String s){
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
}
