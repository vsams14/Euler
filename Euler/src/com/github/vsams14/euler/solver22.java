/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file 
containing over five-thousand first names, begin by sorting it into alphabetical order. 
Then working out the alphabetical value for each name, multiply this value by its 
alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is 
worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a 
score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
*/
package com.github.vsams14.euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class solver22 {
	public solver22(){
		find();
	}
	
	private void find(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("names.txt")));
			String line;
			String p[]={};
			while((line=br.readLine()) != null){
				p = line.split("\",\"");
			}
			p[0] = p[0].substring(1, p[0].length());
			p[p.length-1] = p[p.length-1].substring(0, p[p.length-1].length()-1);
			String a[] = new String[p.length];
			int count;
			for(int i=0; i<p.length; i++){
				count = 0;
				for(int j=0; j<p.length; j++){
					if(p[i].compareTo(p[j])>0){
						count++;
					}
				}
				a[count] = p[i];
			}			
			long sum=0;
			for(int i=0; i<a.length; i++){
				sum+=((i+1)*utils.wordScore(a[i]));
			}
			utils.println(sum+"");
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
