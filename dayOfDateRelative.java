package BetterShiz;
public class dayOfDateRelative 
{
	public static void main(String args[])
	{
		System.out.println(findDay("Thursday",2,1,2015));
	}
	static String findDay(String refDay, int day, int month, int year)
	{
		int noOfDays[]={0,31,(year%4==0?29:28),31,30,31,30,31,31,30,31,30,31},sum=-1;
		String dayName[]={"","Sunday","Monday","Tueday","Wednesday","Thurday","Friday","Saturday"};
		for(int i=1;i<month;sum+=noOfDays[i++]);
		int x="Sunday".equalsIgnoreCase(refDay)?1:"Monday".equalsIgnoreCase(refDay)?2:"Tuesday".equalsIgnoreCase(refDay)?3:"Wednesday".equalsIgnoreCase(refDay)?4:"Thursday".equalsIgnoreCase(refDay)?5:"Friday".equalsIgnoreCase(refDay)?6:"Saturday".equalsIgnoreCase(refDay)?7:0;
		return dayName[(x+((sum+day)%7))%7];
	}
}