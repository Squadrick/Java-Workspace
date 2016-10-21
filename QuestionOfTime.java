package hp.code.thirteen;
import java.util.Scanner;
public class QuestionOfTime 
{
	private static Scanner sc;
	public static void main(String args[])
	{
		sc=new Scanner(System.in);
		int x=sc.nextInt();
		if(x>60)x=x%60;
		System.out.println((int)Math.floor(Math.random()*12) + ":" + (x<10 ? "0"+x : x));
	}
}
