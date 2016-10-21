package BetterShiz;
public class stringPermutations 
{
	static int count = 1;
	public static void main(String args[])
	{
		permute("","ABCDEF");
	}
	static void permute(String pre, String s)
	{
		if(s.length() == 0)
			System.out.println(pre+" - "+(count++));
		else
			for(int i=0;i<s.length();i++)
				permute(pre+s.charAt(i),s.substring(0,i)+s.substring(i+1));
	}
	
}