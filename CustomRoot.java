package BasicShiz;

import java.util.Scanner;
public class CustomRoot 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		System.out.print("Enter the number: ");
		double n = sc.nextDouble();
		System.out.print("Enter the root: ");
		double root = sc.nextDouble();
		double r = 0.0, x = 0.000001;
		boolean oper = true;
		for(double i = 1; Math.pow(i, root) < n; r=i++);
		if(Math.abs((Math.pow(r, root))-n) > Math.abs((Math.pow(r+1, root)-n)))
		{
			r = r+1;
			oper = false;
		}
		while((oper) ? Math.pow(r, root) < n : Math.pow(r, root) > n)
		{
			if(oper) r += x;
			else  r -= x;
		}
		String s = String.valueOf(r).substring(0,String.valueOf(r).indexOf('.')+(int)Math.log10(1/x));
		System.out.println("Square root of " + n + " is " + s);
	}
	
}
