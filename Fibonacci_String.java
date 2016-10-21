package BasicShiz;
public class Fibonacci_String 
{
	static String Fib(int x)
	{
		if(x==0) return "a";
		if(x==1) return "b";
		return Fib(x-1)+Fib(x-2);
 	}
	public static void main(String args[])
	{
		for(int i=0;i<11;i++)
			System.out.println(Fib(i));
	}
}
