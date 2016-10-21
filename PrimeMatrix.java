package BasicShiz;
public class PrimeMatrix 
{
	public static void main(String argsp[])
	{
		int [][] matrix=new int[5][5];
		for(int n=2;n<100;n++)
			for(int i=0;i<5;i++)
				for(int j=0;j<5;j++)
					if(isPrime(n))
						matrix[i][j]=n;
		
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				System.out.println(matrix[i][j]);
	}
	
	static boolean isPrime(int x)
	{
		for(int i=2;i<x;i++)
			if(x%i==0&&x!=i) return false;
		return true;
	}
}
