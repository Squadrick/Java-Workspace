package BetterShiz;
public class NQueensPositions 
{
	static int count=0;
	public static void main(String args[])
	{
		int n=10;
		int positions[][]=new int[n][2];
		long start = System.currentTimeMillis();
		NQueens(n,positions,0,true);
		long end = System.currentTimeMillis();
		System.out.println("Took : " + ((end - start) / 1000)+" seconds");
		System.out.println(count+" solutions in total");
	}
	static void NQueens(int n,int positions[][],int row,boolean superQueen)
	{
		if(row==n)printBoard(n,positions);
		for(int i=0;i<n;i++)
		{
			if(valid(row,i,positions,superQueen))
			{
				positions[row][0]=row;
				positions[row][1]=i;
				NQueens(n,positions,row+1,superQueen);
			}
		}
	}
	static boolean valid(int row, int col, int[][] pos, boolean superQueen)
	{
		for(int i=0;i<row;i++)
			if(pos[i][1]==col||pos[i][0]-pos[i][1]==row-col||pos[i][0]+pos[i][1]==row+col||(superQueen&&Math.abs(row-pos[i][0])+Math.abs(col-pos[i][1])==3))
				return false;
		return true;
	}
	static void printBoard(int n,int[][] pos)
	{
		count++;
		System.out.println("Solution "+count+":");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print((j==pos[i][1]?"Q":"_")+" ");
			System.out.println("");
		}
		System.out.println("");
	}
}