/*
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 * How many such routes are there through a 20×20 grid?
 */
package com.github.vsams14.euler;

public class solver015 {
	int[] aC = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	long pathCount = 0;//to account for 1 extra when max is reached
	
	public solver015(){
		find();
	}
	
	private void find(){
		while(aC[0]<aC.length+2){
			if(pathCount%100000000==0){
				utils.print(pathCount+"::");
				for(int k=0;k<aC.length;k++){
					utils.print(aC[k]+":");
				}
				utils.println("");
			}	
			aC[aC.length-1]++;
			pathCount++;
			for(int i = aC.length-1; i>0; i--){
				if(aC[i]==aC.length+2){
					aC[i-1]++;
					aC[i] = aC[i-1];
					for(int j=i+1;j<aC.length;j++){
						aC[j]=aC[i];
					}
				}
			}		
		}
		utils.print(pathCount+"::");
		for(int k=0;k<aC.length;k++){
			utils.print(aC[k]+":");
		}
		utils.println("");
	}
}
