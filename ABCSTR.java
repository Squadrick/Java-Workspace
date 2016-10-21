import java.util.Scanner;
class ABCSTR
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String ABC = sc.nextLine();
		int l = ABC.length();
		//ABACABA
		int A[] = new int[l];
		int B[] = new int[l];
		int C[] = new int[l];
		for(int i = 0; i < l; i++)
		{
			A[i] = B[i] = C[i] = 0;
			char ch = ABC.charAt(i);
			if(ch == 'A')
				A[i]++;
			else if(ch == 'B')
				B[i]++;
			else if(ch == 'C')
				C[i]++;
		}
	}
}