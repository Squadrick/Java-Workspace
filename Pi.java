package BetterShiz;
public class Pi 
{
	public static void main(String[] args) 
	{
		System.out.println(pi(3,2,1));
		System.out.println(pi1());
	}
	public static double pi(double ans, double x, double p)
	{
		ans=ans+(p*(4/(x*(x+1)*(x+2))));
		if(x==10000) return ans;
		if(p==1) return pi(ans,x+2,-1);
		if(p==-1)return pi(ans,x+2,1);
		return 0;
	}
	static double pi1()
	{
		double ans=3,x=2;
		for(int i=0;i<10000000;i++)
		{
			ans=ans+Math.pow(-1, i)*(4/(x*(x+1)*(x+2)));
			x=x+2;
		}
		return ans;
	}
}
