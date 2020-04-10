package com.IO.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AcceptingDiffTypesofDataInLine {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Create Bufferedreader object to accept data from keyboard
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		//ask for input seperated by commas
		System.out.println("Enter name, age, salary: ");
		
		//Accepting input into a string
		String str = br.readLine();
		
		//use stringtokenizzer to split input at commas
		StringTokenizer st = new StringTokenizer(str,",");
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		String s3 = st.nextToken();
		
		//Trim any spaces before and after the string
		s1 = s1.trim();
		s2 = s2.trim();
		s3 = s3.trim();
		
		//convert s1 into string s2 into an int s3 into an float
		String name =s1;
		int age = Integer.parseInt(s2);
		float sal = Float.parseFloat(s3);
		
		//display the entered data
		System.out.println("Name= "+ name);
		System.out.println("Age= "+ age);
		System.out.println("Salary= " +sal);
		

	}

}
