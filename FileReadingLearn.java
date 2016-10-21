package BasicShiz;
import java.io.*;
public class FileReadingLearn 
{
	public static void main(String args[])throws FileNotFoundException, IOException
	{
		InputStream in = new FileInputStream(new File("C:/text.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder out = new StringBuilder();
		String line;
		while((line = reader.readLine())!= null)
		{
			out.append(line);
		}
		System.out.println(out.toString());
		reader.close();
	}
}
