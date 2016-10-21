package hp.code.thirteen;
public class TribonacciLoop
{
	public static void main(String args[])
	{
		long a=1,b=1,c=1,d;
		System.out.println("1 - 1\n2 - 1\n3 - 1");
		for(int i=4;i<=50;i++)
		{
			d=a+b+c;
			System.out.println(i+" - "+d);
			a=b;
			b=c;
			c=d;
		}
	}
}
