package BestShiz;
public class RubiksCube_BACKTRACK 
{
	static char cube[][][]={{{'Y','W','B'},{'B','O','R'},{'O','G','Y'}},
			{{'R','O','G'},{'B','G','Y'},{'B','W','R'}},
			{{'W','W','B'},{'B','R','O'},{'G','R','Y'}},
			{{'W','Y','O'},{'G','B','W'},{'G','R','W'}},
			{{'G','O','R'},{'O','W','R'},{'Y','B','O'}},
			{{'O','G','W'},{'Y','Y','G'},{'B','Y','R'}}};
	public static void main(String[] args) 
	{
		solve(0,0,-1,"",0);
		for(int i = 0; i < 6; i++)print(cube[i]);
	}
	public static void solve(int n, int face, int facePrev, String s, int len)
	{
		if(len==3)return;
		if(solved())
		{
			for(int i = 0; i < 6; i++)print(cube[i]);
			System.out.println(s);
			System.exit(0);
		}
		turn(face);
		for(int i = 0; i < 6; i++)
		{
			solve(n+1, i, face, s+"Face "+ face +" Clockwise\n", face==facePrev?len+1:len);	
			unturn(face);
		}
	}
	public static void turn(int face)
	{
		char[][] temp = new char[3][3];
		for(int i = 0; i < 9; temp[i/3][i%3] = cube[face][i/3][i%3], i++);
		for(int i = 0; i < 9; cube[face][i%3][i/3] = temp[2-(i/3)][i%3], i++);
		if(face == 0)
		{
			char t1 = cube[3][0][2], t2 = cube[3][1][2], t3 = cube[3][2][2];

			cube[3][0][2] = cube[5][2][0];
			cube[3][1][2] = cube[5][1][0];
			cube[3][2][2] = cube[5][0][0];

			cube[5][0][0] = cube[1][0][0];
			cube[5][1][0] = cube[1][1][0];
			cube[5][2][0] = cube[1][2][0];

			cube[1][0][0] = cube[4][0][0];
			cube[1][1][0] = cube[4][1][0];
			cube[1][2][0] = cube[4][2][0];

			cube[4][0][0] = t3;
			cube[4][1][0] = t2;
			cube[4][2][0] = t1;

		}
		if(face == 1)
		{
			char t1 = cube[4][2][0], t2 = cube[4][2][1], t3 = cube[4][2][2];

			cube[4][2][0] = cube[0][2][2];
			cube[4][2][1] = cube[0][1][2];
			cube[4][2][2] = cube[0][0][2];

			cube[0][0][2] = cube[5][0][0];
			cube[0][1][2] = cube[5][0][1];
			cube[0][2][2] = cube[5][0][2];

			cube[5][0][0] = cube[2][2][0];
			cube[5][0][1] = cube[2][1][0];
			cube[5][0][2] = cube[2][0][0];

			cube[2][2][0] = t3;
			cube[2][1][0] = t2;
			cube[2][0][0] = t1;
		}
		if(face == 2)
		{
			char t1 = cube[1][0][2], t2 = cube[1][1][2], t3 = cube[1][2][2];

			cube[1][0][2] = cube[5][0][2];
			cube[1][1][2] = cube[5][1][2];
			cube[1][2][2] = cube[5][2][2];

			cube[5][0][2] = cube[3][2][0];
			cube[5][1][2] = cube[3][1][0];
			cube[5][2][2] = cube[3][0][0];

			cube[3][0][0] = cube[4][2][2];
			cube[3][1][0] = cube[4][1][2];
			cube[3][2][0] = cube[4][0][2];

			cube[4][0][2] = t1;
			cube[4][1][2] = t2;
			cube[4][2][2] = t3;
		}
		if(face == 3)
		{
			char t1 = cube[2][0][2], t2 = cube[2][1][2], t3 = cube[2][2][2];

			cube[2][0][2] = cube[5][2][2];
			cube[2][1][2] = cube[5][2][1];
			cube[2][2][2] = cube[5][2][0];

			cube[5][2][0] = cube[0][0][0];
			cube[5][2][1] = cube[0][0][1];
			cube[5][2][2] = cube[0][0][2];

			cube[0][0][0] = cube[4][0][2];
			cube[0][1][0] = cube[4][0][1];
			cube[0][2][0] = cube[4][0][0];

			cube[4][0][2] = t3;
			cube[4][0][1] = t2;
			cube[4][0][0] = t1;
		}
		if(face == 4)
		{
			char t1 = cube[0][0][0], t2 = cube[0][0][1], t3 = cube[0][0][2];

			cube[0][0][0] = cube[1][0][0];
			cube[0][0][1] = cube[1][0][1];
			cube[0][0][2] = cube[1][0][2];

			cube[1][0][0] = cube[2][0][0];
			cube[1][0][1] = cube[2][0][1];
			cube[1][0][2] = cube[2][0][2];

			cube[2][0][0] = cube[3][0][0];
			cube[2][0][1] = cube[3][0][1];
			cube[2][0][2] = cube[3][0][2];

			cube[3][0][0] = t1;
			cube[3][0][1] = t2;
			cube[3][0][2] = t3;
		}
		if(face == 5)
		{
			char t1 = cube[0][2][0], t2 = cube[0][2][1], t3 = cube[0][2][2];

			cube[0][2][0] = cube[3][2][0];
			cube[0][2][1] = cube[3][2][1];
			cube[0][2][2] = cube[3][2][2];

			cube[3][2][0] = cube[2][2][0];
			cube[3][2][1] = cube[2][2][1];
			cube[3][2][2] = cube[2][2][2];

			cube[2][2][0] = cube[1][2][0];
			cube[2][2][1] = cube[1][2][1];
			cube[2][2][2] = cube[1][2][2];

			cube[1][2][0] = t1;
			cube[1][2][1] = t2;
			cube[1][2][2] = t3;
		}
	}
	public static void unturn(int face)
	{
		turn(face);
		turn(face);
		turn(face);
	}
	public static boolean solved()
	{
		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				if(cube[i][j/3][j%3]!=cube[i][1][1])
					return false;
		return true;
	}
	public static void print(char arr[][])
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println("");
		}
		System.out.println("");
	}
}