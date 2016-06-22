//prime number generator using sundaram (UGH) and primality test using miller-rabin
package com.github.vsams14.euler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class solver0 {
	public solver0() {
		find();
	}

	private void find() {
		int limit = 50000000;
		int primes[] = new int[limit+1];
		for(int i=1;i<=limit;i++){
			primes[i]=i;
		}
		for(int i=1;i<=limit/2;i++){
			for(int j=1;j<=(limit-i)/(2*i+1);j++){
				int nprime = i+j+2*i*j;
				if(primes[nprime]!=0){
					primes[nprime]=0;
				}
			}
		}
		
		for(int i=1;i<=limit;i++){
			if(primes[i]!=0){
				primes[i]=i*2+1;
			}
		}
		
		try{
			File fout = new File("primes.txt");
			FileOutputStream fos = new FileOutputStream(fout);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
			writer.write("2\n");
			for(int i=1;i<limit;i++){
				if(primes[i]!=0){
					writer.write(primes[i]+"\n");
					utils.println("Printing "+primes[i]);
				}
			}
			writer.close();
		}catch(IOException e){
		}
	}
}
