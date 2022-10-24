package javaPrograms;

public class StringProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//String is an object which represents sequence of characters
		//1. String literal
		String name="Rahul Shetty Academy";
		String name1="Vinay";
		
		//2. New Operator
		String s1=new String("Welcome");
		String s2=new String("Welcome");
		
		String[] arrName=name.split(" ");
		System.out.println("Splitted on the basis of Space: ");
		for(String s:arrName)
		{
			System.out.println(s);
		}
		
		String[] arrName1=name.split("Shetty");
		System.out.println("Splitted on the basis of Shetty: ");
		for(String s:arrName1)
		{
			System.out.println(s.trim());
		}
		
		//Printing a string by charAt method
		for(int i=0;i<name.length();i++)
		{
			System.out.print(name.charAt(i));
		}
		
		//reverse of a string
		String rev="";
		for(int i=name.length()-1;i>=0;i--)
		{
			rev=rev+name.charAt(i);
		}
		System.out.println("Reverse of the String is: "+rev);

	}

}
