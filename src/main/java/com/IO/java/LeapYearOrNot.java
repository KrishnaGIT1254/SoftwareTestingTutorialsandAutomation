package com.IO.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeapYearOrNot {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		//Create Bufferedreader object to accept data from keyboard
				BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
				
			System.out.println("Enter year no: ");
			int year  = Integer.parseInt(br.readLine());
			
			//if it is century year then it is divisible by 400
			if(year % 100==0 && year % 400==0)
				System.out.println("It is leap");
			//if it is not century year then it is divisible by 4
			else if(year % 100 !=0 && year % 4==0)
				System.out.println("It is leap");
			//otherwise it is not a leap
			else 
				System.out.println("it is not a leap");
			
			

	}

}
