package Enigma;
import java.io.*;
import java.util.*;
class Enigma
{
	static String basic= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String rotor1="EKMFLGDQVZNTOWYHXUSPAIBRCJ";
	static String rotor2="AJDKSIRUXBLHWTMCQGZNPYFVOE";
	static String rotor3="BDFHJLCPRTXVZNYEIWGAKMUSQO";
	static String ref=   "YRUHQSLDPXNGOKMIEBFZCWVJAT";
	static String message;
	static int pos1=0, pos2=0, pos3=0;
	static ArrayList<String> plugboard=new ArrayList<String>();
	public static void main(String args[]) throws IOException
	{
		input();
		String ans="";
		for(int i=0;i<message.length();i++)
		{
			String path="";
			char chX=message.charAt(i);
			if(!Character.isAlphabetic(chX))
			{
				ans+=chX;
				inc();
				continue;
			}
			char ch1=getPlug(chX);
			char ch2=rotor1(ch1,basic);inc();
			char ch3=rotor2(ch2,rotor1);
			char ch4=rotor3(ch3,rotor2);
			char ch5=reflector(ch4);
			char ch6=rotor3(ch5,ref);
			char ch7=rotor2(ch6,rotor3);
			char ch8=rotor1(ch7,rotor2);
			char ch9=getPlug(ch8);
			ans+=ch9;
			System.out.println(path);
			System.out.println(pos1);
			System.out.println(pos2);
			System.out.println(pos3);
		}
		System.out.println(ans);
	}
	public static void input() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the rotor starting position(xx-xx-xx): ");
		String temp=br.readLine();
		pos1=Integer.parseInt(temp.substring(0, temp.indexOf('-')));
		pos2=Integer.parseInt(temp.substring(temp.indexOf('-')+1, temp.lastIndexOf('-')));
		pos3=Integer.parseInt(temp.substring(temp.lastIndexOf('-')+1));
		if(pos1>26 || pos2>26 ||pos3>26)
		{
			System.out.println("Rotor postion should be between 1-26");
			System.out.println("Please try again");
			input();
		}
		else
		{
			System.out.print("Enter the message: ");
			message=br.readLine().toUpperCase();
			System.out.println("Enter the plugboard.");
			do
			{
				String plug=br.readLine();
				if((plug.length()==2 && isValidPlug(plug)) || plug.equals(""))
					plugboard.add(plug.toUpperCase());
			}
			while(!plugboard.get(plugboard.size()-1).equalsIgnoreCase(""));
			plugboard.remove(plugboard.size()-1);
		}
	}
	private static boolean isValidPlug(String plug)
	{
		for(int i=0;i<plugboard.size();i++)
		{
			String s=plugboard.get(i);
			if(plug.charAt(0)==plug.charAt(1) || plug.charAt(0)==s.charAt(0) || plug.charAt(0)==s.charAt(1) || plug.charAt(1)==s.charAt(0) || plug.charAt(1)==s.charAt(1))
				return false;
		}
		return true;
	}
	private static char getPlug(char ch)
	{
		for(int i=0;i<plugboard.size();i++)
		{
			String s=plugboard.get(i);
			if(s.charAt(0)==ch)return s.charAt(1);
			if(s.charAt(1)==ch)return s.charAt(0);
		}
		return ch;
	}
	private static char rotor1(char ch,String s)
	{
		int position=s.indexOf(ch)+pos1;
		if(position>=26)position-=26;
		return rotor1.charAt(position);
	}
	private static char rotor2(char ch,String s)
	{
		int position=s.indexOf(ch)+pos2;
		if(position>=26)position-=26;
		return rotor2.charAt(position);
	}
	private static char rotor3(char ch,String s)
	{
		int position=s.indexOf(ch)+pos3;
		if(position>=26)position-=26;
		return rotor3.charAt(position);
	}
	private static char reflector(char ch)
	{
		int position=rotor3.indexOf(ch);
		return ref.charAt(position);
	}
	/*
	private static char rotor3X(char ch)
	{
		int position=ref.charAt(ch)+pos3;
		if(position>=26)position-=26;
		return rotor3.charAt(position);
	}
	private static char rotor2X(char ch)
	{
		int position=rotor3.charAt(ch)+pos2;
		if(position>=26)position-=26;
		return rotor2.charAt(position);
	}
	private static char rotor1X(char ch)
	{
		int position=rotor2.charAt(ch)+pos1;
		if(position>=26)position-=26;
		return rotor1.charAt(position);
	}
	*/
	private static void inc()
	{
		pos1++;
		if(pos1>26)
		{
			pos2++;
			pos1=0;
		}
		if(pos2>26)
		{
			pos3++;
			pos2=0;
		}
	}
}