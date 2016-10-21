package hp.code.thirteen;

public class HELPER 
{
	public static void main(String args[])
	{
		String s="CGXY1LIMBERLA",p="{";
		for(int i=0;i<s.length();i++)
		{
			p+="\'"+s.charAt(i)+"\',";
		}
		p=p.substring(0,p.length()-1)+"},";
		System.out.print(p);
	}
}
