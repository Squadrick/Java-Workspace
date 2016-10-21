package BasicShiz;
public class FIbonnaciRecursion 
{
	static long Fib (long n)
	{
		if(n == 0) return 0;
		if(n <= 2) return 1;
		return Fib (n - 1) + Fib (n - 2);
	}
	public static void main(String args[])
	{
		System.out.println(Fib(50));
	}
}
