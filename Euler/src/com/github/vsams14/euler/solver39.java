/*
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, 
there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}
a^2+b^2=c^2
a+b+c<=1000
a+b+sqrt(a^2+b^2)<=1000

For which value of p <= 1000, is the number of solutions maximised?
*/
package com.github.vsams14.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class solver39 {
	double c;
	int p = 0;
	Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
	
	public solver39(){
		find();
	}
	
	private void find(){
		for(int a=1;a<1000; a++){
			for(int b=1; b<1000; b++){
				c=Math.sqrt((a*a)+(b*b));
				p=a+b+(int)c;
				if(c==(int)(c)&&p<=1000){
					if(map.containsKey(p)){
						ArrayList<String> per = map.get(p);
						if(per.size()!=0 && !per.contains(b+","+a+","+c)){
							per.add(a+","+b+","+c);
							map.remove(p);
							map.put(p, per);
						}	
					}else{
						ArrayList<String> per = new ArrayList<String>();
						per.add(a+","+b+","+c);
						map.put(p, per);						
					}
				}
			}
		}
		for(String s:map.get(840)){
			utils.println(s);
		}
	}
}
