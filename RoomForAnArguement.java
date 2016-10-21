package hp.code.thirteen;
import java.util.Scanner;
public class RoomForAnArguement 
{
	private static Scanner sc;
	public static void main(String args[])
	{
		sc=new Scanner(System.in);
		int size=sc.nextInt()+1;
		String sen[]=new String[size];
		
		for(int i=0;i<size;i++)
			sen[i]=sc.nextLine().trim();
		
		for(int i=0;i<size;i++)
		{
			int count=0;
			String s=sen[i]+" ";
			for(int j=0;j<s.length();j++)
				if(s.charAt(j)==' ')
					count++;
			
			String words[]=new String[count];
			int si=0,index=0;
			
			for(int j=0;j<s.length();j++)
				if(s.charAt(j)==' ')
				{
					words[index++]=s.substring(si,j);
					si=j+1;
				}
			
			for(int j=0;j<count;j++)
			{

				if(j==count-1)
				{
					if(words[count-1].equalsIgnoreCase("not"))words[count-1]="";
					else if(words[count-1].equalsIgnoreCase("is"))words[count-1]="is not";
				}
				else
				{
					if(words[j].equalsIgnoreCase("is")&&(!words[j+1].equalsIgnoreCase("not")))
						words[j]="isn't";
					else if(words[j].equalsIgnoreCase("is")&&words[j+1].equalsIgnoreCase("not"))
						words[j+1]="";
				}
			}
			
			String x="";
			
			for(int j=0;j<count;j++)
				x+=words[j]+(words[j].equals("")?"":" ");
			
			System.out.print(i!=0?x.trim()+".\n":"");
		}
	}
}
