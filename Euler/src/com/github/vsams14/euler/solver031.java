/*
In England the currency is made up of pound, £, and pence, p, and there are 
eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
*/
package com.github.vsams14.euler;

public class solver031 {
	public solver031(){
		find();
	}
	
	private void find(){
		int[] perm = {0,0,0,0,0,0,0,0};
		int sum;
		long count=0;
		while(perm[0]!=1){
			perm[7]++;
			sum = perm[0]*200 + perm[1]*100 + perm[2]*50 + perm[3]*20 +
					perm[4]*10 + perm[5]*5 + perm[6]*2 + perm[7]*1;
			if(sum==200){
				if(perm[0]==0 && perm[1]<2 && perm[1]!=0){
					count++;
					perm[6]++;
					perm[7]=0;
					if((perm[1]*100+perm[2]*50+perm[3]*20+perm[4]*10+perm[5]*5+perm[6]*2)>200){
						perm[5]++;
						perm[6]=0;
					}
					if((perm[1]*100+perm[2]*50+perm[3]*20+perm[4]*10+perm[5]*5+perm[6]*2)==200){
						count++;
						perm[5]++;
						perm[6]=0;
					}
					if((perm[1]*100+perm[2]*50+perm[3]*20+perm[4]*10+perm[5]*5)>200){
						perm[4]++;
						perm[5]=0;
					}
					if((perm[1]*100+perm[2]*50+perm[3]*20+perm[4]*10+perm[5]*5)==200){
						count++;
						perm[4]++;
						perm[5]=0;
					}
					if((perm[1]*100+perm[2]*50+perm[3]*20+perm[4]*10)>200){
						perm[3]++;
						perm[4]=0;
					}
					if((perm[1]*100+perm[2]*50+perm[3]*20+perm[4]*10)==200){
						count++;
						perm[3]++;
						perm[4]=0;
					}
					if((perm[1]*100+perm[2]*50+perm[3]*20)>200){
						perm[2]++;
						perm[3]=0;
					}
					if((perm[1]*100+perm[2]*50+perm[3]*20)==200){
						count++;
						perm[2]++;
						perm[3]=0;
					}
					if((perm[1]*100+perm[2]*50)>200){
						perm[1]++;
						perm[2]=0;
					}
					if((perm[1]*100+perm[2]*50)==200){
						count++;
						perm[1]++;
						perm[2]=0;
					}
					if(perm[1]>2){
						count++;
						perm[0]++;
						perm[1]=0;
					}
				}
				if(perm[0]==0 && perm[1]==0 && perm[2]<4 && perm[2]!=0){
					count++;
					perm[6]++;
					perm[7]=0;
					if((perm[2]*50+perm[3]*20+perm[4]*10+perm[5]*5+perm[6]*2)>200){
						perm[5]++;
						perm[6]=0;
					}
					if((perm[2]*50+perm[3]*20+perm[4]*10+perm[5]*5+perm[6]*2)==200){
						count++;
						perm[5]++;
						perm[6]=0;
					}
					if((perm[2]*50+perm[3]*20+perm[4]*10+perm[5]*5)>200){
						perm[4]++;
						perm[5]=0;
					}
					if((perm[2]*50+perm[3]*20+perm[4]*10+perm[5]*5)==200){
						count++;
						perm[4]++;
						perm[5]=0;
					}
					if((perm[2]*50+perm[3]*20+perm[4]*10)>200){
						perm[3]++;
						perm[4]=0;
					}
					if((perm[2]*50+perm[3]*20+perm[4]*10)==200){
						count++;
						perm[3]++;
						perm[4]=0;
					}
					if((perm[2]*50+perm[3]*20)>200){
						perm[2]++;
						perm[3]=0;
					}
					if((perm[2]*50+perm[3]*20)==200){
						count++;
						perm[2]++;
						perm[3]=0;
					}
					if(perm[2]>4){
						perm[1]++;
						perm[2]=0;
					}
				}
				if(perm[0]==0 && perm[1]==0 && perm[2]==0 && perm[3]<10 &&
						perm[3]!=0){
					count++;
					perm[6]++;
					perm[7]=0;
					if((perm[3]*20+perm[4]*10+perm[5]*5+perm[6]*2)>200){
						perm[5]++;
						perm[6]=0;
					}
					if((perm[3]*20+perm[4]*10+perm[5]*5+perm[6]*2)==200){
						count++;
						perm[5]++;
						perm[6]=0;
					}
					if((perm[3]*20+perm[4]*10+perm[5]*5)>200){
						perm[4]++;
						perm[5]=0;
					}
					if((perm[3]*20+perm[4]*10+perm[5]*5)==200){
						count++;
						perm[4]++;
						perm[5]=0;
					}
					if((perm[3]*20+perm[4]*10)>200){
						perm[3]++;
						perm[4]=0;
					}
					if((perm[3]*20+perm[4]*10)==200){
						count++;
						perm[3]++;
						perm[4]=0;
					}
					if(perm[3]>10){
						perm[2]++;
						perm[3]=0;
					}
				}
				if(perm[0]==0 && perm[1]==0 && perm[2]==0 && perm[3]==0 &&
						perm[4]<20 && perm[4]!=0){
					count++;
					perm[6]++;
					perm[7]=0;
					if((perm[4]*10+perm[5]*5+perm[6]*2)>200){
						perm[5]++;
						perm[6]=0;
					}
					if((perm[4]*10+perm[5]*5+perm[6]*2)==200){
						count++;
						perm[5]++;
						perm[6]=0;
					}
					if((perm[4]*10+perm[5]*5)>200){
						perm[4]++;
						perm[5]=0;
					}
					if((perm[4]*10+perm[5]*5)==200){
						count++;
						perm[4]++;
						perm[5]=0;
					}
					if(perm[4]>20){
						perm[3]++;
						perm[4]=0;
					}
				}
				if(perm[0]==0 && perm[1]==0 && perm[2]==0 && perm[3]==0 &&
						perm[4]==0 && perm[5]<40 && perm[5]!=0){
					count++;
					perm[6]++;
					perm[7]=0;
					if((perm[5]*5+perm[6]*2)>200){
						perm[5]++;
						perm[6]=0;
					}
					if((perm[5]*5+perm[6]*2)==200){
						count++;
						perm[5]++;
						perm[6]=0;
					}
					if(perm[5]>40){
						perm[4]++;
						perm[5]=0;
					}
				}
				if(perm[0]==0 && perm[1]==0 && perm[2]==0 && perm[3]==0 &&
						perm[4]==0 && perm[5]==0 && perm[6]<100){
					count++;
					perm[6]++;
					perm[7]=0;
					if(perm[6]==100){
						count++;
						perm[5]++;
						perm[6]=0;
					}
				}
			}
		}
		utils.println(count);
	}
}
