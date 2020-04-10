package com.Strings.java;

public class StringsClass {

	public static void main(String[] args) {
	    
		String st1 = "This World is Very Nice";
		String st2 = " And Beautiful.";
		
		//Comparing both strings. return true if both match else return false
		System.out.println("st1 equals to st2?-->" +st1.equals(st2));
		
		
		//Concatenates st2 with st1
		System.out.println("Concatenate of st1 and st2-->" +st1.concat(st2));
		
		//Retrive 9th Index character from the string
		System.out.println("Character at index 9 is--->" +st1.charAt(9));
		
		//Find the length of the String
		System.out.println("Length of st1 is --->" +st1.length());
		
		//Converting whole String in Lowercase
		System.out.println("String in Lowercase is--->" +st1.toLowerCase());
		
		//Converting whole String in Uppercase
		System.out.println("String in Uppercase is--->" +st1.toUpperCase());
		
		//Retrive the index of first i character
		System.out.println("Index of 1st charater i Is -->" +st1.indexOf('i'));
		
		//Retrive the index of 2nd most 'i' character.
		System.out.println("Index of 2nd charater i Is --->" +st1.indexOf('i', 3));
		
		//Retrive the index of word 'very' from string.
		System.out.println("Index of word Very Is --->" +st1.indexOf("Very"));
		
		//Converting values from int to string
		int j = 75;
		String val2 = String.valueOf(j);
		System.out.println("Value of string val2 Is-->" +val2);
		
		//Converting string to interger
		String val1 = "50";
		int i = Integer.parseInt(val1);
		System.out.println("Value of integer i Is-->" +i);
		
		//Print the string starting from 5th index to 12th index
		System.out.println("Retrieving sub string from string -> "+ st1.substring(5, 13));
		
		//Split String
		String splt[] = st1.split("Very");
		System.out.println("String part 1 is--->" +splt[0]);
		System.out.println("string part 2 is--->" +splt[1]);
		
		//Trim string
		System.out.println("trimmed st2-->" +st2.trim());
		
		
		
		
		
		

	}

}
