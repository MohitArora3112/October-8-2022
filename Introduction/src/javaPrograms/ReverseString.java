package javaPrograms;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Program for reverse of a String
		String name="My name is Mohit Arora M";
		String rev="";
		for(int i=name.length()-1;i>=0;i--)
		{
			rev=rev+name.charAt(i);
		}
		System.out.println("Reverse of a String is: "+rev);
		
		//Program to compare to Strings
		String name1="My name is Vinay Arora";
		Boolean flag=name.equalsIgnoreCase(name1);
		System.out.println(flag);
		
		//Counting number of duplicate characters and  in a String
		List<Character> al=new ArrayList<Character>();
		for(int i=0;i<name.length()-1;i++)
		{
			char c=name.charAt(i);
			int count=1;
			if(!al.contains(c))
			{
				for(int j=i+1;j<name.length();j++)
				{
					if(c==name.charAt(j))
					{
						count++;
					}
				}
			}
			if(count > 1 && c != ' ')
			{
				al.add(c);
				System.out.println(c+" character occurrence is: "+count);
			}
			
		}
	}
}
