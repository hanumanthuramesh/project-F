package test_NG_suite;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Suite4 {
	ChromeDriver driver=new ChromeDriver();
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.Driver", "C:\\Users\\USER\\Downloads\\Tools\\updated tools file\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\\");
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/nlogin/login?URL=https://www.naukri.com/mnjuser/homepage");
	}
	@Test
	public void mid() throws InterruptedException
	{
		driver.findElement(By.id("register_Layer")).click();
		Thread.sleep(4000);
	}
	@AfterTest
	public void end()
	{
		 driver.close();
		
	}
	
	//covered Thinks Testsuite run successfully

}
