package BasicShiz;
//Slower
public class SpiralMatrix 
{
	public static void main(String[] args) 
	{
		long start=System.nanoTime();
		int n=5,x=1, C1=0, C2=n-1, R1=0, R2=n-1;
		int mtr[][]=new int[n][n]; 
		while(x<=n*n)
		{
			for(int i=C1;i<=C2;mtr[R1][i++]=x++);
			for(int i=R1+1;i<=R2;mtr[i++][C2] =x++);
			for(int i=C2-1;i>=C1;mtr[R2][i--]=x++);
			for(int i=R2-1;i>=R1+1;mtr[i--][C1]=x++);
			C1++;C2--;R1++;R2--;
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(mtr[i][j]+"\t");
			System.out.println("\n");
		}	
		long end=System.nanoTime();
		System.out.println("\nExecution Time: "+(end-start)+" nanoseconds");
	}
}

