import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class NSpies
{
	static int count=0;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int positions[][]=new int[n][2];
		NSpies(n,positions,0);
	}
	static void NSpies(int n,int positions[][],int row)
	{
		if(row==n)
				printBoard(n,positions);
		for(int i=0;i<n;i++)
		{
			if(valid(row,i,positions))
			{
				positions[row][0]=row;
				positions[row][1]=i;
				NSpies(n,positions,row+1);
			}
		}
	}
	static boolean valid(int row, int col, int[][] pos)
	{
		boolean chk = true;
		for(int i=0;i<row;i++)
		{
			if(pos[i][1]==col||pos[i][0]-pos[i][1]==row-col||pos[i][0]+pos[i][1]==row+col)
			{
				return false;
			}
			
		}
		return checkStraightLine(pos,row,col);
	}
	static void printBoard(int n, int arr[][])
	{
		//System.out.println(n);
		for(int i=0;i<n;i++)
		{
			System.out.print((arr[i][1]+1)+" ");
		}
		System.out.println("");
		System.exit(0);
	}
	static boolean checkStraightLine(int arr[][],int row,int col)
	{
		for(int i=0; i <= row-2; i++)
		{
			for(int j = i+1; j <= row-1; j++)
			{
				int x1 = arr[i][0];
				int x2 = arr[j][0];
				int x3 = row;
				int y1 = arr[i][1];
				int y2 = arr[j][1];
				int y3 = col;
				int area = x1*(y2-y3) + x2*(y3-y1) + x3*(y1 - y2);
				if(area == 0)return false;
			}
		}
		return true;
	}
}