class permutations
{
	public static void main(String args[])
	{
		permute("","ABC");
	}
	public static void permute(String prefix, String postfix)
	{
		if(postfix.length()==0)System.out.println(prefix);
		else
		{
			for(int i=0;i<postfix.length();i++)
				permute(prefix+postfix.charAt(i), postfix.substring(0,i)+postfix.substring(i+1,postfix.length()));
		}
	}
}