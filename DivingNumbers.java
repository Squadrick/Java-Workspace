package BasicShiz;
public class DivingNumbers 
{
	public static void main(String args[])
	{
		double n=25,sum=0;
		for(double i=1;i<=n;i++)
		{
			sum+=(n/i);
			System.out.println(round(String.valueOf(n/i)));
		}
		System.out.println(sum);
	}
	static String round(String n)
	{
		return n.substring(n.indexOf('.')).length()<3?n:n.substring(0,n.indexOf('.')+3);
	}
}