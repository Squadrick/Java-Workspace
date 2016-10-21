package BetterShiz;

public class Sorting 
{
	public static void main(String[] args)
	{
		int arr[] = new int[10000000];
		long s, e;
		for(int i=0; i < arr.length; arr[i++] = (int)(Math.random()*1000-500));
		s = System.nanoTime();
		mergeSort(arr);
		e = System.nanoTime();
		System.out.println("Time taken: " + (e-s) + " nanoseconds.");
	}
	public static int Bin(int[] arr, int s, int e, int key)
	{
		if (s < e)
		{
			int mid = s+(e-s)/2;
			if(key < arr[mid]) return Bin(arr, s, mid-1, key);
			if(key > arr[mid]) return Bin(arr, mid+1, e , key);
			return mid;
		}
		return -1;
	}
	public static void selectionSort(int data[])
	{
		if(data.length <= 1) return;
		for(int i = 1; i < data.length-1; i++)
		{
			int min = i;
			for(int j = i+1; j < data.length; j++)
				if(data[j] < data[min])
					min = j;
			if(min != i)
				data[min] = sw(data[i], data[i] = data[min]);
		}
	}
	public static void mergeSort(int[] data) 
	{
		if(data.length <= 1) return;
		int[] a = new int[data.length/2], b = new int[data.length-a.length];
		for(int i = 0;i < data.length; i++)
		{
			if(i < a.length)
				a[i] = data[i];
			else
				b[i-a.length] = data[i];
		}
		mergeSort(a);
		mergeSort(b);
		int ai = 0, bi = 0;
		while(ai+bi < data.length)
		{
			if(bi >= b.length || (ai < a.length && a[ai] < b[bi]))
				data[ai+bi] = a[ai++];
			else
				data[ai+bi] = b[bi++];
		}
	}
	public static void bubbleSort(int data[])
	{
		for(int i = 0; i < data.length; i++)
			for(int j = 0;j < data.length-1; j++)
				if(data[j] > data[j+1])
					data[j] = sw(data[j+1], data[j+1] = data[j]);
	}
	public static void insertionSort(int data[])
	{
		for(int i = 1;i < data.length; i++)
		{
			int element = data[i], j = i;
			while(j > 0 && data[j-1] > element)
			{
				data[j] = data[j-1];
				j = j-1;
			}
			data[j] = element;
		}
	}
	public static void printArray(int arr[])
	{
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}
	public static int sw(int a, int b)
	{
		return a;
	}
}