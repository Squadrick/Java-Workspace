package BasicShiz;
import java.util.Scanner;
public class DateConverter 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);	
		System.out.println("INPUT");
		System.out.print("Enter day number: ");
		int day = sc.nextInt();
		
		System.out.print("Enter year: ");
		int year = sc.nextInt();
		
		System.out.print("Enter n: ");
		int n = sc.nextInt();
		
		boolean leap = year%4==0?true:false;
		if(day < 1 || day >= (leap?366:365) || year < 1 || n < 1 || n > 100)
		{
			System.out.println("Invalid Input");
			System.exit(0);
		}
		converter(day,0,leap,year);
		converter(day,n,leap,year);
		sc.close();
	}
	static void converter(int days,int n,boolean leap,int year)
	{
		if(n!=0) 
			if((days+n) >= (leap?366:365)) 
			{
				days += n-(leap?366:365);
				year++;
			}
			else //Dangling else
				days+=n;
		int NoOfDays[] = {31,(leap?29:28),31,30,31,30,31,31,30,31,30,31},i=0;
		String month[] = {"January","February","March","April","May","June","July","August","Spetember","October","November","December"};
		for(i = 0; i < 12; i ++)
		{
			if(NoOfDays[i]<days)
				days -= NoOfDays[i];
			else break;
		}
		if(n!=0)
			System.out.println("Date after "+n+" days is "+days+" "+month[i]+" "+year);
		else 
			System.out.println("Date is "+days+" "+month[i]+" "+year);
	}

}
