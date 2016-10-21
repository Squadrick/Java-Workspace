package BetterShiz;
public class largestAdjacentSeq 
{
	static int x,y,x1,y1,high=0;
	public static void main(String args[])
	{
		int n=150;
		int arr[][]=new int[n][n];
		for(int i=0;i<n*n;i++)arr[i/n][i%n]=(int)(Math.random()*10)+1;
		/*
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
		*/
		long s,e;
		s=System.currentTimeMillis();
		findLargeSeq(arr);
		e=System.currentTimeMillis();
		print(arr,x,y,x1,y1);
		System.out.println("\nTime taken: "+(e-s)+" milliseconds");
	}
	static void findLargeSeq(int arr[][])
    {
        int sum=0;
        for(int i=0;i<arr.length*arr.length;i++)
            for(int j=0;j<=1;j++)
                for(int k=0;k<=1;k++)
                {
                    try
                    {
                        if(j==0 && k==0)continue;
                        for(int t=0;t<arr.length/10;t++)
                        	sum+=arr [(i/arr.length)+t*j] [(i%arr.length)+t*k];
                        if(sum>high)
                        {
                            high=sum;
                            x=i/arr.length; y=i%arr.length; x1=x+((arr.length/10)-1)*j; y1=y+((arr.length/10)-1)*k;
                        }
                    }
                    catch(Exception e){}
                    sum=0;
                }
    }
	static void print(int arr[][],int x,int y,int x1,int y1)
	{
		System.out.println("\n("+y +","+x +") to ("+y1+","+x1+")");
		x1 = x1>arr.length?arr.length-1:x1;
		y1 = y1>arr.length?arr.length-1:y1;
		if(x!=x1 && y!=y1)
			for(int i=x,j=y;i<=x1 && j<=y1;i++,j++)
				System.out.print(arr[i][j]+"\t");
		
		else if(x==x1)
			for(int i=y;i<=y1;i++)
				System.out.print(arr[x][i]+"\t");
		
		else if(y==y1) 
			for(int i=x;i<=x1;i++)
				System.out.print(arr[i][y]+"\t");
		System.out.println("\nSum is "+high);
	}
}