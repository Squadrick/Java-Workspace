package BetterShiz;
public class NQueens 
{
	public static void main(String args[])
	{
		int n=6;
		char arr[][]=new char[n][n];
		placeQueen(arr,n,0);
	}
	static void placeQueen(char arr[][],int n,int row)
	{
		if(n==row)//Board if found, print and exit
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
					System.out.print((arr[i][j]=='Q'?"Q":"*")+" ");//Q . . .  Formatted printed
				System.out.println("");
			}
			System.exit(0);
		}
		
		for(int i=0;i<n;i++)
		{
			if(valid(arr,row,i))//To check whether a queen can be placed in (row,i)
			{
				arr[row][i]='Q';//Place queen
				placeQueen(arr,n,row+1);//Go to the next row and check
			}
		}
		return;//Reached end of a row but couldn't find a suitable position
	}
	static boolean valid(char arr[][],int row, int col)
	{
		//Removing any Q already placed in that row from previous recursive call
		for(int i=0;i<arr.length;i++)
		{
			if(arr[row][i]=='Q')
			{
				arr[row][i]=' ';
				break;
			}	
		}
		
		//positions remembers the positions of all the Queens in that board
		int positions[][]=new int[row][2], c=-1;
		label:for(int i=0;i<row;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i][j]=='Q')
				{
					positions[++c][0]=i;
					positions[c][1]=j;
					continue label;
				}
			}
		}
		for(int i=0;i<positions.length;i++)
		{
			//checks to whether the Queens can attack (row,col) of arr
			if(positions[i][1]==col || positions[i][0]-positions[i][1] == row-col || positions[i][0]+positions[i][1] == row+col)
				return false;
		}
		return true;
	}
}