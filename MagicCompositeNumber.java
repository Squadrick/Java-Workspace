package BasicShiz;
import java.util.Scanner;
public class MagicCompositeNumber 
{
	static boolean composite(int n)
	{
		for(int i=2;i<n;i++)
			if(n%i==0) 
				return true;
		return false;
	}
	static int sumDigits (int n)
	{
		int s=0;
		while(n>0)
		{
			s+=n%10;
			n/=10;
		}
		return s;
	}
	static Scanner s=new Scanner(System.in);
	public static void main(String args[])
	{
		System.out.println("Enter a number");
		int n=s.nextInt();
		if(!composite(n)) System.exit(0);
		do
			n=sumDigits(n);
		while(n>=9);
		if(n!=1) System.exit(0);
		System.out.println("It is a magic composite number");
	}
}
