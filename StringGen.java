package BetterShiz;
public class StringGen 
{
	static String Gen(int n)
	{
		String s = "";
		for(int i = 0; i < n;)
		{
			int x = (int) ((Math.random() * (123 - 48)) + 48);
			if(x >= 58 && x <= 64) continue;
			else if(x >= 91 && x <= 96) continue;
			else
			{
				s += (char)x;
				i++;
			}
		}
		return s;
	}
	public static void main(String args[])
	{
		long start = System.nanoTime(), end = 0, c = 0;
		while((end-start) < 1000000000)
		{
			c++;
			System.out.println(Gen(4));
			end = System.nanoTime();
		}
		System.out.println("Time Taken: "+1000000000/c);
	}
}
