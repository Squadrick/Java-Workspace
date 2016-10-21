package BestShiz;
public class SudokuSolver 
{
	static int arr[][]={{2,0,0,3,0,1,0,6,0},
			{7,9,0,0,5,0,4,0,0},
			{0,0,0,0,2,7,0,0,0},
			{0,0,0,0,0,0,1,0,3},
			{3,0,4,0,0,5,0,0,6},
			{8,0,0,9,0,0,5,2,0},
			{1,0,0,0,0,0,0,0,0},
			{4,0,7,8,0,2,0,5,1},
			{5,8,0,1,3,0,2,7,0}};
	public static void main(String args[])
	{
		SudoSol(0, 0);
	}
	private static boolean check(int no, int r, int c)
	{
		for(int i = 0; i < 9; i++)
			if(no==arr[r][i] || no==arr[i][c] || arr[(r/3)*3+i/3][(c/3)*3+i%3] == no)
				return false;
		return true;
	}
	private static void SudoSol(int r, int c)
	{
		if(r==9)
		{	
			for(int i = 0; i < 9; i++)
			{
				for(int j = 0; j < 9; j++)
					System.out.print(arr[i][j]+" ");
				System.out.println("");
			}
			System.exit(0);
		}
		if(arr[r][c] != 0)
			SudoSol((c==8?r+1:r),(c==8?0:c+1));
		else
		{
			for(int i=0;i<=9;i++)
				if(check(i,r,c))
				{
					arr[r][c]=i;
					SudoSol((c==8?r+1:r),(c==8?0:c+1));
				}
			arr[r][c] = 0;
		}
	}
}