package javaPrograms;

public class MethodDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//NO need to create object for accessing static method
		MethodDemo2.sum(5, 7);
	}
	
	public int subtract(int a,int b)
	{
		return a+b;
	}
	
	public int divide(int a,int b)
	{
		return a*b;
	}
	
	public static void sum(int a,int b)
	{
		System.out.println("Sum is: "+(a+b));
	}
}
