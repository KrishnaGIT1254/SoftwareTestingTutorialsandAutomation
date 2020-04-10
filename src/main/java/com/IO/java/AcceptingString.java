package com.IO.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcceptingString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Create Bufferedreader object to accept data from keyboard
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		//ask for string and read it
		System.out.println("Enter a name: ");
		String name = br.readLine();
		
		//display the String
		System.out.println("you entered: "+name);
		
		
		
		

	}

}
