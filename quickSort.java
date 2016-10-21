public class quickSort 
{
	public static void main(String[] args) 
	{
		int a[]=ranArr(10000);
		long start = System.nanoTime();
		quicksort(a, 0 , a.length-1);
		long end = System.nanoTime();
		
		System.out.println(end-start+" nanoseconds");
	}
	private static int[] ranArr(int size)
	{
		int arr[] = new int[size];
		for(int i = 0; i < size; i++)
			arr[i] = (int) (Math.random()*size);
		return arr;
	}
	private static void quicksort(int arr[], int s, int e)
	{
		if(s < e)
		{
			int p = partition(arr, s, e);
			quicksort(arr, s, p - 1);
			quicksort(arr, p + 1, e);
		}
	}
	private static int partition(int arr[], int s, int e)
	{
		int pivot = arr[s];
		int i = s - 1, j = e + 1;
		while(true)
		{
			do
			{
				i++;
			}
			while(arr[i] < pivot);
			
			do
			{
				j--;
			}
			while(arr[j] > pivot);
			
			if(i >= j)
				return j;
			arr[i] = swap(arr[j], arr[j] = arr[i]);
		}
	}
	private static int swap(int a, int b)
	{
		return a;
	}
}
