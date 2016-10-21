package BetterShiz;
public class RemoveWords 
{
	public static void main(String args[])
	{
		System.out.println(remove("This is is Dheeraj is is","is",5));
	}
	static String remove(String sen, String word, int pos)
	{
		int j=0;
		for(int i=0;i<sen.length();i++)
		{
			if(sen.charAt(i)==' ')j++;
			if(j==pos)
				return sen.substring(0,i)+sen.substring(i+1+word.length());
		}
		return "";
	}
}
