package BetterShiz;
public class Root 
{
	public static void main(String[] args) 
	{
		double s = System.nanoTime();
		double p = rooter(2);
		double e = System.nanoTime();
		System.out.println("Time taken: "+(e-s)+"\tResult: "+p+"\tAnswer: "+p*p);
	}
	static double rooter(double n)
	{
		double ans = 0.0, p = 0;
		for(int i = 0; i <= (n>10?n:10); i++)
		{
			if(ans*ans == n) return ans;
			double x = ans +  i * Math.pow(10, p), y = ans + (i+1) * Math.pow(10, p);
			if(x*x <= n && y*y > n)
			{
				ans = x;
				i = -1;
				p--;
			}
		}
		return ans;
	}
}