package BasicShiz;
import java.util.Scanner;
public class CubeRoot 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		System.out.print("Enter the number: ");
		double n = sc.nextInt();
		long start = System.nanoTime();
		double r = 0.0, x = 0.0001;
		boolean oper = true;
		for(double i = 1; Math.pow(i, 3) < n; r=i++);
		if(Math.abs((Math.pow(r, 3))-n) > Math.abs((Math.pow(r+1, 3)-n)))
		{
			r = r+1;
			oper = false;
		}
		while((oper) ? Math.pow(r, 3) < n : Math.pow(r, 3) > n)
		{
			if(oper) r += x;
			else  r -= x;
		}
		String s = String.valueOf(r).substring(0,String.valueOf(r).indexOf('.')+(int)Math.log10(1/x));
		System.out.println("Square root of " + n + " is " + s);
		long end = System.nanoTime();
		if(end-start > 1000000000)
			System.out.println("Failure");
		else
			System.out.println("Success");
	}
}
