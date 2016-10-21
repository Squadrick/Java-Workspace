class mergeSort
{
	public static void main(String args[])
	{
		int arr[] = {3,4,1,2};
		sort(arr);
		for(int i:arr)
			System.out.println(i);
	}
	public static void sort(int arr[])
	{
		sort(arr, 0, arr.length-1);
	}
	public static void sort(int arr[],int start,int end)
	{
		if(start == end) return;
		int mid = (start+end)/2;
		sort(arr, start, mid);
		sort(arr, mid+1, end);
		merge(arr, start, mid, end);
	}
	public static void merge(int arr[], int start, int mid, int end)
	{
		int start_unc = start;
		int sorted[] = new int[end-start+1];
		for(int i = 0; i < sorted.length; i++)
		{
			if(mid>=end || (arr[start]<=arr[mid+1] && start<mid+1))
				sorted[i] = arr[start++];
			else
				sorted[i] = arr[(mid++)+1];
		}
		for(int i=start_unc, index=0;i<=end;arr[i++] = sorted[index++]);
	}
}