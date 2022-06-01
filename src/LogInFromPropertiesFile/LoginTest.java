package LogInFromPropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
	  TestScript to Automate www.saucedemo.com Login in TestNG
	- Passing parameters from .properties file
 */
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest
{ 	
	WebDriver driver = null;
	
	@BeforeMethod
	public void initialization() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	
	@Test
	public void Login() throws IOException 
	{		
		
		FileInputStream propertyFile = new FileInputStream("C:"
				+ "\\A JAVA PROGRAMMING\\SeleniumTestTemplate\\testng_properties_file\\template.properties");
		
		Properties fileDegate = new Properties();		
		fileDegate.load( propertyFile );
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys(
												fileDegate.getProperty("username") );
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys( 
									fileDegate.getProperty("Password") );

		driver.findElement(By.xpath("//input[@id='login-button']")).click();						
	}

	@AfterTest
	public void conclusionofTest() {
		try
		{ 
				Thread.sleep(5000);
			 	driver.close();
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
