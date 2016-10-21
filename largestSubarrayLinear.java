class largestSubarrayLinear
{
	public static void main(String args[])
	{
		int arr[] = {13, -1, -25, 20, -2, -16, -23, 18, 20, -7, 12, 5, -22, 15, -4, 7};
		int i = 0, j = 0, sum = 0, sumT=0;
		for(int x = 0; x < arr.length; x++)
		{
			sum += arr[x];
			if(sum < 0)
			{
				i = x+1;
				sum = 0;
				continue; 
			}
			if(sumT < sum)
			{
				sumT = sum;
				j = x;
			}
		}
		System.out.println(i+" "+j+" "+sumT);
	}	
}