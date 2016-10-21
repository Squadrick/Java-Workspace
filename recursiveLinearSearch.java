class recursiveLinearSearch
{
	public static void main(String args[])
	{
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		int key = Integer.parseInt(args[0]);
		int index = search(arr,0,key);
		System.out.println(key + " found at index " + index);
	}
	private static int search(int[] arr,int index,int key)
	{
		if(index == arr.length)
			return -1;
		if(arr[index] == key)
			return index;
		return search(arr,index+1,key);
	}
}