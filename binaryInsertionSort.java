class modifiedInsertionSort
{
	public static void main(String args[])
	{
		int arr[] = {4,3,2,1};
		for(int i=1;i<arr.length;i++)
		{
			int index = 0, ele = arr[i];

			//applying binary search
			int start = 0, end = i-1;
			while(start <= end)
			{
				int mid = (start+end)/2;
				if(arr[mid] < ele)
					start = mid+1;
				else if(arr[mid] > ele)
					end = mid - 1;
				else
				{
					index = mid;
					break;
				}
			}

			//swapping all the element by one up
			for(int j = i; j > index; j--)
				arr[j] = arr[j-1];
			arr[index] = ele;
		}
		for(int i:arr)
			System.out.println(i);
	}
}