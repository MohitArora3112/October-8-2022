package javaPrograms;

import java.util.ArrayList;

public class ArrayProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Arrays
		int[] arr=new int[5];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		arr[3]=4;
		arr[4]=5;
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		//Enhanced for loop
		String[] arrName= {"Rahul","Mohit","Vinay","Tarun"};
		for(String s:arrName)
		{
			System.out.println(s);
		}
		
		//If condition in for loop
		int[] arrInt= {1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<arrInt.length;i++)
		{
			if((arrInt[i]%2)==0)
			{
				System.out.println(arrInt[i]);
			}			
		}
		
		ArrayList<String> a=new ArrayList<String>();
		a.add("Mohit");
		a.add("Tarun");
		a.add("Vinay");
		System.out.println(a);
		a.remove(2);
		a.add("Jatin");
		System.out.println(a.get(0));
		System.out.println(a);
	}
}
