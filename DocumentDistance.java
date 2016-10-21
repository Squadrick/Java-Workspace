import java.io.*;
import java.util.*;
public class DocumentDistance 
{
	private static Scanner sc;
	private static File file;
	public static void main(String args[])
	{
		String s1 = "", s2 = "";
		try
		{
			file = new File("C:\\Document Distance Files\\1.txt");
			sc = new Scanner(file);
			s1 = sc.nextLine().toLowerCase().trim() + " ";
			file = new File("C:\\Document Distance Files\\2.txt");
			sc = new Scanner(file);
			s2 = sc.nextLine().toLowerCase().trim() + " ";
		}
		catch(FileNotFoundException e)
		{
			System.out.println("*baby voice* Gugu gaga");
		}
		Map<String, Integer> m1 = getMap(s1), m2 = getMap(s2);
		double result = 200*Math.acos(dotProduct(m1,m2) / (mod(m1) * mod(m2)))/Math.PI;
		System.out.println(100 - result);
	}
	private static double mod(Map<String, Integer> map)
	{
		double mod = 0;
		for(String key : map.keySet())
			mod += map.get(key) * map.get(key);
		return Math.sqrt(mod);
	}
	private static Map<String, Integer> getMap(String s)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0, start = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == ' ')
			{
				String sub = s.substring(start, i);
				start = i + 1;
				if(map.containsKey(sub))
					map.replace(sub, map.get(sub)+1);
				else
					map.put(sub, 1);
			}
		}
		return map;
	}
	private static double dotProduct(Map<String, Integer> m1, Map<String, Integer> m2)
	{
		double sum = 0;
		for(String key : m1.keySet())
			if(m2.containsKey(key))
				sum += m1.get(key) * m2.get(key);
		return sum;
	}
}