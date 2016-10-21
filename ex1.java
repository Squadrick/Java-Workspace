class ex1 //Exercise 2.3-7
{
	public static void main(String args[])
	{
		int S[] = {1,0,2,8,3,12,89};
		int x = 12;
		int n = S.length;
		for(int i = 0; i < n; i++)
		{
			int num = findNumber(S,x,S[i],0,n-1);
			System.out.println("EXISTS: "+S[i]+" "+num);
		}
		System.out.println("END");
	}
	private static int findNumber(int S[], int x,int a, int start, int end)
	{
		if(start > end)return -1;
		int mid = (start+end)/2;
		if(S[mid] + a == x)
			return S[mid];
		int y0 = findNumber(S,x,a,mid+1,end);
		return y0 == -1?findNumber(S,x,a,start,mid-1):y0;
	}
}