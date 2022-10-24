package javaPrograms;

public class MethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethodDemo obj=new MethodDemo();
		System.out.println(obj.sum(3, 4));
		System.out.println(obj.multiply(3, 4));
		
		MethodDemo2 obj1=new MethodDemo2();
		System.out.println(obj1.subtract(5, 2));
		System.out.println(obj1.divide(5, 2));
		
	}
	
	public int sum(int a,int b)
	{
		return a+b;
	}
	
	public int multiply(int a,int b)
	{
		return a*b;
	}
}
