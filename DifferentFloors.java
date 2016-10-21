package BetterShiz;
public class DifferentFloors 
{
	static String Rules1[]={"MORALES NOT ON FLOOR 5",
		"CHEN NOT ON FLOOR 1",
		"TANAKA NOT ON FLOORS 1 OR 5",//-6 to -5
		"PATEL ON HIGHER FLOOR THAN CHEN",
		"SMITH NOT ON ADJACENT FLOOR TO TANAKA",
	"TANAKA NOT ON ADJACENT FLOOR TO CHEN"};

	static String Rules2[]={"BLAKE NOT ON FLOORS 5 OR 4",
		"GONZALEZ ON ADJACENT FLOOR TO ITO",
		"HUANG ON HIGHER FLOOR THAN PHAM",
		"BLAKE ON HIGHER FLOOR THAN HUANG",
		"GONZALEZ NOT ON FLOOR 1",
	"ITO NOT ON ADJACENT FLOOR TO BLAKE"};

	static String Rules[]=Rules2;

	public static void main(String args[])
	{
		String names[] = extractNames(Rules);
		print(Rules, false);
		permute(0, names);
	}
	private static void permute(int n, String names[])
	{
		if(n == names.length && isValid(names))
			print(names, true);
		else
		{
			for(int i = n; i < names.length; i++)
			{
				names[n]=swap(names[i],names[i]=names[n]);
				permute(n + 1, names);
				names[n]=swap(names[i],names[i]=names[n]);
			}
		}
	}
	private static boolean isValid(String floors[])
	{
		for(int i = 0; i < Rules.length; i++)
		{
			String rule = Rules[i];
			if(rule.contains("NOT ON FLOOR"))
			{
				int x = Integer.valueOf(rule.substring(rule.lastIndexOf(' ') + 1)) - 1;
				String name = rule.substring(0, rule.indexOf(' '));
				if(floors[x].equals(name))
					return false;

				if(rule.contains(" OR "))
				{
					int y = Integer.valueOf(rule.substring(rule.length() - 6, rule.length() - 5)) - 1;
					if(floors[y].equals(name))
						return false;
				}
			}
			else if(rule.contains(" ON HIGHER FLOOR "))
			{
				String name1 = rule.substring(0, rule.indexOf(' ')), name2 = rule.substring(rule.lastIndexOf(' ') + 1);
				int f1 = getFloor(name1, floors), f2 = getFloor(name2, floors);
				if(f1 < f2)return false;
			}
			else
			{
				String name1 = rule.substring(0,rule.indexOf(' ')),	name2 = rule.substring(rule.lastIndexOf(' ') + 1);
				int f1 = getFloor(name1, floors), f2 = getFloor(name2, floors);
				if(rule.contains(" NOT ") && Math.abs(f2 - f1) == 1)return false;
				else if(!rule.contains(" NOT ") && Math.abs(f2 - f1) != 1)return false;
			}
		}
		return true;
	}
	private static String[] extractNames(String Rules[])
	{
		String names[] = new String[5];
		int c = 0;
		for(int i = 0; i < Rules.length; i++)
		{
			String name1 = Rules[i].substring(0, Rules[i].indexOf(' '));
			String name2 = Rules[i].substring(Rules[i].lastIndexOf(' ') + 1);
			if(containsNot(names, name1)) 
				names[c++] = name1;
			if(containsNot(names, name2) && name2.length() > 1)
				names[c++] = name2;
		}
		return names;
	}
	private static boolean containsNot(String names[], String name)
	{
		for(int i = 0; i < names.length; i++)
		{
			if(names[i] == null) return true;
			if(names[i].equalsIgnoreCase(name)) return false;
		}	
		return true;
	}
	private static void print(String[] arr, boolean backwards)
	{
		if(!backwards)
			for(String s : arr) 
				System.out.println(s);
		else
			for(int i = arr.length - 1 ;i >= 0; i--) 
				System.out.println((i + 1) + " " + arr[i]);
		System.out.println("");
	}
	private static int getFloor(String name, String names[])
	{
		for(int i = 0; i < names.length; i++)
			if(name.equalsIgnoreCase(names[i]))
				return i;
		return -1;
	}
	private static String swap(String a, String b)
	{
		return a;
	}
}