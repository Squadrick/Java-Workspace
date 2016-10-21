package BasicShiz;
import java.util.Scanner;
public class MagicMatrix 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array.");
		int n=sc.nextInt();
		if(n<1||n>85)
		{
			System.out.println("The size must be between 2 and 5. Please try again");
			System.exit(0);
		}
		int arr[][]=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				arr[i][j]=0;
		int i,j,k,t;
		
		/*When the size of the matrix is odd*/
		if(n%2!=0)
        {
            i=0;
            j=n/2;
            k=1;
            while(k<=n*n)
            {
                arr[i][j]=k++;
                i--; //Making one step upward
                j++; //Moving one step to the right
                if(i<0&&j>n-1) //Condition for the top-right corner element
                {
                    i+=2;
                    j--;
                }
                if(i<0) i=n-1;//Wrapping around the row if it goes out of boundary    
                if(j>n-1) j=0;//Wrapping around the column if it goes out of boundary   
                if(arr[i][j]>0)//Condition when the cell is already filled
                {
                    i+=2;
                    j--;
                }
            }
        }
         
        /* When the size of the matrix is even */
        else
        {
        	k=1; 
        	/* Filling the matrix with natural numbers from 1 till n*n */
            for(i=0;i<n;i++)
                for(j=0;j<n;j++)
                        arr[i][j]=k++;
            j=n-1;
            for(i=0; i<n/2; i++)
            {
                /* swapping corner elements of primary diagonal */
                t=arr[i][i];
                arr[i][i]=arr[j][j];
                arr[j][j]=t; 
                /* swapping corner elements of secondary diagonal */
                t=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=t;
                j--;
            }
        }
		
		System.out.println("The Magic Matrix of size "+n+"x"+n+" is:");
        for(i=0;i<n;i++)
        {
        	for(j=0;j<n;j++)
        		System.out.print(arr[i][j]+"\t");
        	System.out.println();
        }
        sc.close();
	}
}