package BetterShiz;
class fractionToDecimal
{
	public static void main(String args[])
	{
		decToFrac(3.3333);
	}
	static void decToFrac(double n)
	{
		String S=String.valueOf(n);
		S=S.substring(S.indexOf(".")+1);
		int d=S.length();
		int den=(int)Math.pow(10,d);
		int num=(int)(n*den);
		System.out.println(print(num,den,2));
	}
	static String print(int num,int den,int i)
	{
		if(i>Math.min(num,den))
		{
			return String.valueOf(num)+"/"+String.valueOf(den);
		}
		if(num%i==0 && den%i==0)
		{
			num/=i;
			den/=i;
			return print(num,den,i); 
		}
		i++;
		return print(num,den,i);
	}
}