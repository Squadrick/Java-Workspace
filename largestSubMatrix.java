package BetterShiz;

public class largestSubMatrix 
{
	static int high=0,p,q,r,s;
	public static void main(String[] args) 
	{
		int n=10;
		int arr[][]=new int[n][n];
		for(int i=0;i<n*n;i++)arr[i/n][i%n]=(int)(Math.random()*20-10);
		for(int i=0;i<n*n;i++)high+=arr[i/n][i%n];
		System.out.println("Original Matrix\n");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
		System.out.println("\nSum: "+high);
		high=0;	
		long start=System.nanoTime();
		subMatrix(arr);
		long end=System.nanoTime();
		System.out.println("\nLargest Matrix\n");
		for(int i=p;i<=r;i++)
		{
			for(int j=q;j<=s;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
		System.out.println("\nSum: "+high);
		System.out.println((end-start)+" nanoseconds");
	}
	public static void subMatrix(int arr[][])
	{
		for(int i=0;i<arr.length*arr.length;i++)
			for(int j=0;j<arr.length*arr.length;j++)
				test(arr,i/arr.length,i%arr.length,j/arr.length,j%arr.length,0);
	}
	public static void test(int[][] arr,int x,int x1, int y,int y1,int sum)
	{
		for(int i=x;i<=x1;i++)
			for(int j=y;j<=y1;j++)
				sum+=arr[i][j];
		if(sum>high)
		{
			high=sum;
			p=x;q=y;r=x1;s=y1;
		}
	}
}