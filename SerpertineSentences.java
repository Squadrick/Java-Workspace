package BetterShiz;
import java.util.*;
public class SerpertineSentences 
{
	static Scanner sc=new Scanner(System.in);
	static int r,c;
	public static void main(String args[])
	{
		System.out.println("Enter data");
		String S=sc.nextLine();
		r=Integer.valueOf(S.substring(0,2));
		c=Integer.valueOf(S.substring(3,5));
		char ch1[][]=new char[r][c];
		for(int i=0;i<r;i++)
		{
			S=sc.nextLine();
			ch1[i]=S.toCharArray();
		}
	}
}