/*
You are given the following information, but you may prefer to do some research for yourself.

The first Sunday in 1901 was January 6

30 days has 4, 6, 9, 11.
31 days has 1, 3, 5, 7, 8, 10, 12

Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.

A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/
package com.github.vsams14.euler;

public class solver19 {
	int count = 0;
	int day = 6, month=1, year=1901;
	
	public solver19(){
		find();
	}
	
	private void find(){
		while(year<2001){
			day+=7;
			switch(month){
			case 1:
				if(day>31){
					day-=31;
					month++;
				}
				break;
			case 2:
				if(year%4==0){
					if(day>29){
						day-=29;
						month++;
					}
				}else{
					if(day>28){
						day-=28;
						month++;
					}				
				}
				break;
			case 3:
				if(day>31){
					day-=31;
					month++;
				}
				break;
			case 4:
				if(day>30){
					day-=30;
					month++;
				}
				break;
			case 5:
				if(day>31){
					day-=31;
					month++;
				}
				break;
			case 6:
				if(day>30){
					day-=30;
					month++;
				}
				break;
			case 7:
				if(day>31){
					day-=31;
					month++;
				}
				break;
			case 8:
				if(day>31){
					day-=31;
					month++;
				}
				break;
			case 9:
				if(day>30){
					day-=30;
					month++;
				}
				break;
			case 10:
				if(day>31){
					day-=31;
					month++;
				}
				break;
			case 11:
				if(day>30){
					day-=30;
					month++;
				}
				break;
			case 12:
				if(day>31){
					day-=31;
					month=1;
					year++;
				}
				break;
			}
			if(day==1){
				count++;
				utils.println(count+":"+day+"/"+month+"/"+year);
			}
		}
	}

}
