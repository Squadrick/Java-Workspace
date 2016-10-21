import java.util.Scanner;
import java.util.ArrayList;
class blocksOnATable
{
	int board [][];
	int blocks[][];
	int size;
	int noOfBlocks;
	ArrayList<String> moves = new ArrayList<String>();

	blocksOnATable(int size, int noOfBlocks)
	{
		board = new int[size][size];
		blocks = new int[noOfBlocks][4];
		this.size = size;
		this.noOfBlocks = noOfBlocks;
	}

	public static void main(String args[])
	{
		blocksOnATable table1 = new blocksOnATable(10, 3);
		table1.randomBoardInit();
		table1.printBoard();
	}

	public void randomBoardInit()
	{
		moves.add("Board Initialization");
		for(int i = 0; i < size*size; i++)
			board[i/size][i%size] = 0;
		for(int i = 0; i < noOfBlocks; i++)
		{
			int width = (int)(Math.random()*3)+2;
			int height = (int)(Math.random()*3)+2;
			System.out.println(i+"==>"+width+" and "+height);
			blocks[i][0] =  width;
			blocks[i][1] = height;
			placeOnBoard(i);
		}
	}

	public void placeOnBoard(int block)
	{
		int base = blocks[block][0], vertical = blocks[block][1];
		int x = findPlaceAtBase(base,vertical);
		if(x == -1) //Place not found
		{
			moves.add(block+" had no place");
			for(int i=0; i < noOfBlocks; i++)
				if(block != i && topCovered(i) >= blocks[block][0])
					placeOnOtherBlock(block,i);
		}
		else //Place found starting from x onwards
			place(block,size-1,x);
	}

	public int findPlaceAtBase(int base, int vertical)
	{
		x:for(int i = 0; i < size-base+1; i++)
			if(board[size-1][i] == 0)
				for(int j = 0; j < base; j++)
				{
					if(board[size-1][i+j] != 0)
					{
						i = j+i+1;
						continue x;
					}
					return i;
				}
		return -1;
	}

	public void place(int block, int x, int y)
	{
		moves.add(block+" placed on the board");
		int base = blocks[block][0];
		int vertical = blocks[block][1];
		for(int i = 0; i < base; i++)
			for(int j = 0; j < vertical; j++)
				board[x-j][y+i]=block+1;
		blocks[block][2]=x;
		blocks[block][3]=y;
	}

	private void printBoard()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0 ; j < size; j++)
				System.out.print((board[i][j]==0?" ":board[i][j])+"\t");
			System.out.println("");
		}
	}

	private void makePlace()
	{

	}

	private void placeOnOtherBlock(int mover, int receiver)
	{

	}

	private int topCovered(int block)
	{
		int top = blocks[block][3] - blocks[block][1] - 1;
		int answer = 0;
		for(int i = 0; i < blocks[block][0]; i++)
		{
			if(board[top][i] == 0)
			{
				for(int j = i; j < blocks[block][0]; j++)

			}
		}
	}
} 