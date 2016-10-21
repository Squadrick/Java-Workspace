package hp.code.thirteen;
import java.util.ArrayList;
import java.util.Scanner;
public class Weight_calculator 
{
	private static Scanner sc;
	public static void main(String[] args) 
	{
		sc = new Scanner(System.in);
		String s=null;
		ArrayList<String> arrayList = new ArrayList<String>();
		System.out.println("Enter the data:");
		do
		{
			s=sc.nextLine().trim();
			arrayList.add(s+" ");
		}
		while(!s.equalsIgnoreCase("END 0 0 0"));
		for(int i=0;i<arrayList.size()-1;i++)
		{
			int x=0,si=0;
			double a=0,b=0,weight=0;
			String planet="",name="";
			String st=arrayList.get(i);
			for(int i1=0;i1<st.length();i1++)
			{
				char ch=st.charAt(i1);
				if(ch==' ')
				{
					if(x==0)name=st.substring(si,i1);
					else if(x==1)a=Double.parseDouble(st.substring(si,i1));
					else if(x==2)planet=st.substring(si,i1);
					else if(x==3)b=Double.parseDouble(st.substring(si,i1));
					x++;
					si=i1+1;
				}
			}
			weight=a*b;
			System.out.println("On "+planet+", "+name+" would weigh "+weight+" pounds.");
		}
	}
		
}
