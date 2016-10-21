package BasicShiz;
public class Randomer 
{
	public static void main(String args[])
	{
		int arr[]=new int[7];
		for(int i=0;i<100;i++,arr[(int)(Math.random()*7)]++);
		for(int i=0;i<7;i++)
			System.out.println((i+1)+"--->"+arr[i]);
	}
}
