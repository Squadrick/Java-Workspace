package BetterShiz;
public class Sudoku 
{
	static int userGrid[][]=new int[][]
		   {{0,1,5,0,0,0,2,6,0},
			{0,8,0,6,1,7,0,3,0},
			{0,0,0,2,0,9,0,0,0},
			{0,2,3,0,0,0,1,8,0},
			{0,0,0,8,0,4,0,0,0},
			{0,4,7,0,0,0,5,9,0},
			{0,0,0,7,0,2,0,0,0},
			{0,7,0,3,4,1,0,2,0},
			{0,3,1,0,0,0,8,4,0}};//[horizontal][vertical]

	static int grid[][]=new int[9][9];//the grid that the program experiments on
	public static void main(String[] args) 
	{
		for (int i=0;i<9;i++) 
		{
			for (int j=0;j<9;j++) 
			{
				grid[i][j]=userGrid[i][j];
			}
		}
		print(grid);
		double timeStart=System.currentTimeMillis();
		print(loop(0, 0, grid));
		double timeEnd=System.currentTimeMillis();
		System.out.println("\nThat took "+(timeEnd-timeStart)+" millis to complete.");
	}
	public static int[][] loop(int y, int x, int[][] grid) 
	{
		while(!validity(8, 8, grid) || grid[8][8]==0)//while not solved
		{
			if (userGrid[y][x]!=0) 
			{
				int yy, xx;
				if (x==8) 
				{
					yy=y+1; 
					xx=0;
				} 
				else 
				{
					yy=y; 
					xx=x+1;
				}
				loop(yy, xx, grid);
			} 
			else
			{
				if (grid[y][x]<9)//going forward
				{
					grid[y][x]++;
					if (validity(y, x, grid)) 
					{
						int yy, xx;
						if (x==8) 
						{
							yy=y+1; 
							xx=0;
						} 
						else 
						{
							yy=y;
							xx=x+1;
						}
						loop(yy, xx, grid);
					}
				} 
				else 
				{
					grid[y][x]=0;
					break;
				}
			}
		}
		return grid;
	}
	public static boolean validity(int x, int y, int[][] grid) 
	{
		String temp="";
		for (int i=0;i<9;i++) 
		{
			temp+=Integer.toString(grid[i][y]);//horizontal
			temp+=Integer.toString(grid[x][i]);//verical
			temp+=Integer.toString(grid[(x/3)*3+i/3][(y/3)*3+i%3]);//square
		}
		int count=0, idx=0;
		while ((idx=temp.indexOf(Integer.toString(grid[x][y]), idx))!=-1)
		{
			idx++; 
			count++;
		}
		return count==3;
	}
	public static void print(int[][] grid)
	{
		System.out.println();
		for (int i=0;i<9;i++) 
		{
			for (int j=0;j<9;j++) 
			{
				System.out.print(grid[i][j]+" ");
			}
			System.out.println("");
		}
	}
}