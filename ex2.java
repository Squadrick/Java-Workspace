class ex2 //2-4 d finding inversions
{
	static int count = 0;
	public static void main(String args[])
	{
		int arr[] = {2,3,8,6,1};
		modifiedMergeSort(arr);
		System.out.println(count);
	}
	public static void modifiedMergeSort(int arr[])
	{
		if(arr.length==1)return;
		int A[] = new int[arr.length/2];
		int B[] = new int[arr.length - A.length];
		for(int i=0;i<arr.length;i++)
		{
			if(i < A.length)
				A[i] = arr[i];
			else
				B[i-A.length] = arr[i];
		}
		modifiedMergeSort(A);
		modifiedMergeSort(B);
		int ai=0,bi=0;
		for(int i=0;i<arr.length;i++)
		{
			if(bi >= B.length || (ai < A.length && A[ai] <= B[bi]))
			{
				arr[i] = A[ai++];
			}
			else
			{
				arr[i] = B[bi++];
				if(ai<A.length)
					count+=A.length-ai;
			}
		}
	}
}