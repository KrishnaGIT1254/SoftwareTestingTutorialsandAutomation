package com.IO.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcceptingSingleChar {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Create a Bufferedreader object to accept data from keyboard
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a Character: ");
		char ch = (char)br.read();
		//display the character
		System.out.println("You entered: "+ch);

	}

}
