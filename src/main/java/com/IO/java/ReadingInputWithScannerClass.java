package com.IO.java;

import java.util.Scanner;

public class ReadingInputWithScannerClass {
	
	public static void main(String args[])
	{
		
		System.out.print("Enter id name sal: ");
		Scanner sc = new Scanner(System.in);
		
		int id = sc.nextInt();
		String name = sc.next();
		float sal = sc.nextFloat();
		
		System.out.println("ID= "+ id);
		System.out.println("Name= "+ name);
		System.out.println("Sal= "+ sal);
		
	}

}
