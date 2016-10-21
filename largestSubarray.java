class largestSubarrayRecur
{
	public static void main(String args[])
	{
		int arr[] = {13, -1, -25, 20, -2, -16, -23, 18, 20, -7, 12, 5, -22, 15, -4, 7};
		int ans[] = findMaximumSubarray(arr, 0, arr.length-1);
		System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
	}
	private static int[] findMaxCrossingSubarray(int arr[], int low, int mid, int high)
	{
		int leftSum = -999, rightSum = -999, sum = 0, maxLeft = 0, maxRight = 0;
		for(int i = mid; i >= low; i--)
		{
			sum += arr[i];
			if(sum > leftSum)
			{
				leftSum = sum;
				maxLeft = i;
			}
		}
		sum = 0;
		for(int j = mid+1; j<= high; j++)
		{
			sum += arr[j];
			if(sum > rightSum)
			{
				rightSum = sum;
				maxRight = j;
			}
		}
		int ans[] = {maxLeft, maxRight, leftSum+rightSum};
		return ans;
	}
	private static int[] findMaximumSubarray(int arr[], int low, int high)
	{
		if(high == low)
		{
			int ans[] = {low,high,arr[low]};
			return ans;
		}
		int mid = (low+high)/2;
		int left[] = findMaximumSubarray(arr,low,mid);
		int right[] = findMaximumSubarray(arr, mid+1, high);
		int cross[] = findMaxCrossingSubarray(arr, low, mid, high);
		if(left[2] >= right[2] && left[2] >= cross[2])
			return left;
		if(right[2] >= left[2] && right[2] >= cross[2])
			return right;
		return cross;	
	}
}