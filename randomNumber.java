class randonNumber //5.1-2
{
	public static void main(String args[])
	{
		int N = 100;
		int arr[] = new int[N];
		for(int i = 0; i < 10000; i++)
		{
			int n = RANDOM(0,N-1);
			arr[n]++;
		}
		for(int i = 0; i < N; i++)
		{
			System.out.println(i+"-->"+arr[i]);
		}
	}
	public static int RANDOM_ZERO_OR_ONE()
	{
		return (int)(Math.random()*2);
	}
	public static int RANDOM(int a, int b)
	{
		int n = b-a;
		int c = (int)Math.ceil(Math.log(n)/Math.log(2));
		int x = 0, p = 0;
		for(int i = 0; i < c; i++)
			x += RANDOM_ZERO_OR_ONE() * Math.pow(2,p++);
		if(x > n)
			return RANDOM(a,b);
		return a+x;
	}
}
//Running time of this algorithm is O(lg(b-a)) or O(lg(n))
//There is a p=n/(2^c) of not having to call line 28-29
//