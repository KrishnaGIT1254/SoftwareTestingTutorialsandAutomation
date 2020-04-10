package com.IO.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcceptingFloat {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		//Create Bufferedreader object to accept data from keyboard
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		//ask for float and read it
		System.out.println("Enter float value: ");
		
		float n = Float.parseFloat(br.readLine());
		//double n1 = Double.parseDouble(br.readLine());
		
		//display the float
		System.out.println("You entered: "+n);

	}

}
