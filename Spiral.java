package BasicShiz;
//Faster
class Spiral
{
    public static void main(String args[])
    {
    	long start=System.nanoTime();
    	int n=5;
        int arr[][]=new int[n][n],l=1;
        for(int i=0;i<n/2+n%2;i++)
        {            
            for(int j=i;j<n-i;arr[i][j++]=l++);
            for(int j=1+i;j<n-i;arr[j++][n-1-i]=l++);
            for(int j=n-2-i;j>i;arr[n-1-i][j--]=l++);
            for(int j=n-1-i;j>i;arr[j--][i]=l++);
        }
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++) System.out.print(arr[i][j]+"\t");
        	System.out.println("\n");
        }
        long end=System.nanoTime();
		System.out.println("\nExecution Time: "+(end-start)+" nanoseconds");
    }
}