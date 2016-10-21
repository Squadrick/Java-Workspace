package BasicShiz;

public class Factorial 
{
	public static void main(String[] args)
	{
		long s=System.nanoTime();
		long ans=fact(25);
		long e=System.nanoTime();
		System.out.println(ans);
		System.out.println(e-s);
		s=System.nanoTime();
		ans=fact(25);
		e=System.nanoTime();
		System.out.println("\n"+ans);
		System.out.println(e-s);
	}
	static long fact(int n)
	{
		return n==1?1:n*fact(n-1);
	}
	static long fact1(int n)
	{
		long prod=1;
		for(int i=1;i<=n;prod*=i++);
		return prod;
	}
}
