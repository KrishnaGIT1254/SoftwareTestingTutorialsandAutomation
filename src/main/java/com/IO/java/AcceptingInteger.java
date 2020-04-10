package com.IO.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcceptingInteger {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//Create Bufferedreader object to accept data from keyboard
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//ask for integer and read it
		System.out.println("Enter an Integer value: ");
		int num = Integer.parseInt(br.readLine());
		
		//display the int
		System.out.println("You entered: "+num);
		

	}

}
