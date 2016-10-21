package BetterShiz;
public class largestOnesMatrix 
{
	static int high=0,p,q,r,s,count=0,count1=0;
	public static void main(String[] args) 
	{
		int n=15;
		int arr[][]=new int[n][n];
		for(int i=0;i<n*n;i++)arr[i/n][i%n]=(int)(Math.random()*3-1);
		for(int i=0;i<n*n;i++)high+=arr[i/n][i%n];
		System.out.println("Original Matrix\n");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
		System.out.println("\nSum: "+high);
		high=-1000;
		System.out.println("\n\nLargest Matrix of Ones\n");
		subMatrix(arr);
		System.out.println("("+(q+1)+","+(p+1)+") to ("+(s+1)+","+(r+1)+")");
		for(int i=p;i<=r;i++)
		{
			for(int j=q;j<=s;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
		System.out.println("\n"+count);
		System.out.println("\n"+count1);
	}
	public static void subMatrix(int arr[][])
	{
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr[i].length;j++)
				for(int k=0;k<arr.length;k++)
					for(int l=0;l<arr[k].length;l++)
					{
						count++;
						test(arr,i,j,k,l);
					}
	}
	public static void test(int[][] arr,int x,int x1, int y,int y1)
	{
		int sum=0;
		for(int i=x;i<=x1;i++)
			for(int j=y;j<=y1;j++)
			{
				count1++;
				sum+=arr[i][j];
			}
		boolean check = sum==(x1+1-x)*(y1+1-y) && sum>0;
		if(sum>=high && check)
		{
			
			high=sum;
			p=x;q=y;r=x1;s=y1;
		}
	}
}
