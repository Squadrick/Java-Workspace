package BetterShiz;

public class Powers {

	public static void main(String[] args) 
	{
		System.out.print(power(2,2.6));
	}
	static double power(double b, double p)
	{
		double fracP = (p - (int)p), ans = 0;
		fracP = fracP == 0 ? 0 : 1/fracP;
		p = (int)p;
		if(p == 0 && fracP == 0) return 1;
		if(p > 0)
		{
			ans = 1.0;
			for(int i = 1; i <= p; ans *= b, i++);
		}
		if(fracP > 0)
		{
			double an = 0.0, po = 0;
			for(int i = 0; i <= (b>10?b:10); i++)
			{
				double x = an +  i * Math.pow(10, po),y = an + (i+1) * Math.pow(10, po);
				if(power(x, fracP) <= b && power(y,fracP) > b)
				{
					an = x;
					i = -1;
					po--;
					continue;
				}
			}
			ans += an;
		}
		return ans;
	}
}
