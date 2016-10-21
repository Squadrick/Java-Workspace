
package hp.code.thirteen;
import java.util.Scanner;
public class ScrambleSearch 
{
	private static Scanner sc,sc1;
	public static void main(String[] args) 
	{
		sc=new Scanner(System.in);
		sc1=new Scanner(System.in);//Due to error, x=01, not x=0
		int ScramN=sc.nextInt(),num=sc.nextInt(),x=0;
		
		String UnScram[]=new String[num];
		do
		{
			System.out.print(x);
			UnScram[x]=sc1.nextLine().trim();
			x=x+1;
		}
		while(x<num);
		
		//int wordsN=sc.nextInt();
		int count=0;
		//String words[]=new String[wordsN];
		
		//for(int i=0;i<wordsN;i++) words[i]=sc.nextLine();
		
		for(int i=0;i<UnScram.length;i++)
			for(int j=0;j<UnScram[i].length();j++)
				if(Character.isLetter(UnScram[i].charAt(j)))
					count++;
		
		char[][] Scram=new char[ScramN][(count/ScramN)+1];
		
		System.out.println("COUNT="+count);
		System.out.println((count/ScramN)+1);
		for(int i=0,k=0;i<Scram.length&&k<UnScram.length;i++,k++)
		{
			for(int l=0,j=0;j<Scram[i].length && l<UnScram[k].length();j++,l++)
			{
				if(Character.isLetter(UnScram[k].charAt(l)))
				{
					System.out.print(j+"\t"+i+"\t"+UnScram[k].charAt(l)+"\n");
					Scram[i][j]=UnScram[k].charAt(l);
					
				}
			}
		}
		
		for(int i=0;i<ScramN;i++)
		{
			for(int g=0;g<Scram[i].length;g++)
				System.out.print(Scram[i][g]);
			System.out.println();
		}
	}
}
