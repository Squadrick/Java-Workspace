package BetterShiz;
public class Parenthesis 
{
	static int c = 0;
	public static void main(String[] args) 
	{
		brac(11, 0, "");
	}
	public static void brac(int open, int close, String perm)
	{
		if(open == 0 && close == 0)
			System.out.println(perm + " - " + ++c);
		else
		{
			if(open > 0)
				brac(open - 1, close + 1, perm + "(");
			if(close > 0)
				brac(open, close - 1, perm + ")");
		}
	}
}
