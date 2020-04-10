package com.IO.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcceptingEmployeesDetails {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Create Bufferedreader object to accept data from keyboard
				BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
				//Accepting employees details
				System.out.println("Enter id: ");
				int id = Integer.parseInt(br.readLine());
				
				System.out.println("Enter sex: ");
				//char sex = (char)br.read();
				char sex = br.readLine().charAt(0);
				
				System.out.println("Enter name: ");
				String name = br.readLine();
				
				//display the employee details
				System.out.println("ID= "+id);
				System.out.println("SEX= "+sex);
				System.out.println("NAME= "+name);

	}

}
