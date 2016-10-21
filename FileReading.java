package BasicShiz;
import java.io.*;
public class FileReading 
{
	public static void main(String arg[])throws IOException
	{
		File s=new File("C:/dad.txt");
		BufferedReader br=new BufferedReader(new FileReader(s));
		try
		{
			String line=null;
			while((line=br.readLine())!=null)
				System.out.println(line);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			br.close();
		}
	}
}
