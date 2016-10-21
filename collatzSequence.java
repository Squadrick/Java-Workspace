package BetterShiz;
public class collatzSequence 
{
	static int count=0;
	public static void main(String args[])
	{
		System.out.println(collatz(10003));
	}
	static int collatz(int n)
	{
		count++;
		if(n==1) return count;
		if(n%2==0) return collatz(n/2);
		return collatz(3*n+1);
	}
}