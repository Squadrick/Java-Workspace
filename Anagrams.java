package BasicShiz;
import java.util.Scanner;
public class Anagrams 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		System.out.println("INIPUT");
		
		System.out.print("First word: ");
		String w = sc.nextLine().toLowerCase();
		char[] w1 = w.toCharArray();
		
		System.out.print("Second word: ");
		String we = sc.nextLine().toLowerCase();
		char[] w2 = we.toCharArray();
		
		if(w1.length != w2.length)
		{
			System.out.println("Not anagrams");
			System.exit(0);
		}
		
		int count = 0;
		
		for(int i = 0; i < w1.length; i++)
			for(int j = w1.length-1; j >= 0; j--)
				if(w1[i] == w2[j])
				{
					count++;
					w1[i]='0';
				}
		
		if(w1.length == count)
			System.out.println("Anagrams");
		else
			System.out.println("Not anagrams");
	}
}
