package BetterShiz;
import java.util.Scanner;
public class StateMachineDecoder 
{
	private static Scanner sc;
	public static void main(String arg[])
	{
		sc = new Scanner(System.in);
		System.out.println("Input:");
		int n=sc.nextInt();
		sc.nextLine();
		char arr[][]=new char[n][3];
		for(int i=0;i<n;i++)
		{
			String s=sc.nextLine();
			arr[i]=s.replaceAll("\\s+","").toCharArray();
		}
		String dir=sc.nextLine();
		char start=arr[0][0];
		l:for(int i=0;i<dir.length();i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[j][0]==start && arr[j][1]==dir.charAt(i))
				{
					System.out.print(start=arr[j][2]);
					continue l;
				}
			}
		}
	}
}