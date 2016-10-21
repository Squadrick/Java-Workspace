class KaratsubaMultiplication
{
	public static void main(String args[])
	{
		long x = multiply(1234,56);
		System.out.println(x);
	}
	public static long multiply(long x, long y)
	{
		int x_size = getSize(x);
		int y_size = getSize(y); 
		int n = Math.max(x_size,y_size);
		if(n<2)
		{
			long prod = 0;
			for(int i=0;i<x;i++)
				prod = prod+y;
			return prod;
		}
		n = (n/2) + (n%2);
		long m = (long)Math.pow(10,n);

		long a = x / m;
		long b = x - (a*m);
		long c = y/m;
		long d = y - (c*m);

		long prod1 = multiply(a,c);
		long prod2 = multiply(b,d);
		long prod3 = multiply(a+b, c+d);

		return prod1*(long)Math.pow(10,2*n) +  (prod3-prod1-prod2)*(long)Math.pow(10,n) + prod2;
	}
	public static int getSize(long x)
	{
		int size = 0;
		while(x!=0)
		{
			size++;
			x/=10;
		}
		return size;
	}
}