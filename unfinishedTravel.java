import java.util.Scanner;
public class unfinishedTravel 
{
	static Scanner scan = new Scanner(System.in);
	static char[][] grid={
		{'S','L','H','8','U','R','O','W','3','L','I','D','E'},
		{'9','2','O','G','A','M','E','A','N','D','E','R','L'},
		{'U','J','P','C','R','A','5','L','U','G','C','O','4'},
		{'R','7','T','N','U','A','S','K','6','P','A','L','M'},
		{'C','G','X','Y','1','L','I','M','B','E','R','L','A'}
	};
	static String[] wordList={"JOG","RUN","HOP","WALK","RUSH","RACE","CLIMB","AMBLE","SLIDE","SAUNTER","MEANDER","CRAWL","SKIP","ROLL"};
	static void crawler()
	{
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				String s="";
				for(int x=-1;x<=1;x++)
				{
					for(int y=-1;y<=1;y++)
					{
						try
						{
							if(x==0 && y==0)continue;
							for(int con=0;con<=7;con++)
							{
								s+=grid[i+x*con][j+y*con];
								find(s);
							}
						}
						catch(Exception e){}
						s="";
					}
				}

			}
		}
	}

	static void find(String s)
	{
		int index=-1;
		char ch='\u0000';
		if(s.matches(".*\\d.*"))
		{
			for(int p=0;p<s.length();p++)
			{
				if(Character.isDigit(s.charAt(p)))
				{
					index=p;
					ch=s.charAt(p);
					break;
				}
			}
			lab:for(int i=0;i<wordList.length;i++)
			{
				if(s.length()!=wordList[i].length()) continue;
				for(int o = 0; o < s.length(); o++)
				{
					if(o == index) continue;
					if(wordList[i].charAt(o) != s.charAt(o)) continue lab;
					System.out.println(ch+"---->"+(wordList[i].charAt(o)));
				}
			}
		}
	}

	public static void main(String args[])
	{
		System.out.println("TESTING");
		crawler();
	}
}
