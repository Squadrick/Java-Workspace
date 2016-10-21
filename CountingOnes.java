package hp.code.thirteen;
import java.util.Scanner;
import java.util.ArrayList;
public class CountingOnes 

{
	private static Scanner sc;
	public static void main(String args[])
	{
		int i;
		sc=new Scanner(System.in);
		ArrayList<Integer> arr=new ArrayList<Integer>();
		do
		{
			i=sc.nextInt();
			arr.add(i);
		}
		while(i!=-1);
		for(int j=0;j<arr.size()-1;j++)
			System.out.println(getOnes(arr.get(j)));			
	}
	static int getOnes(int n)
	{
		int count=0;
		for(int i=0;i<=n;i++)
			for(int j=0;j<String.valueOf(i).length();j++)
				if(String.valueOf(i).charAt(j) == '1')
					count++;
		return count;
	}
}
