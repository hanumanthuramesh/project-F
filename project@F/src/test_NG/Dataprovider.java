package test_NG;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider
{
	ChromeDriver driver= new ChromeDriver(); //Global variable declaration
    @DataProvider(name="linkedin")// annotation
    public Object[][] linkedinTestData()
	{
	return new Object [][]
{
		{"Ramcharn","NTR"},
		{"mahesh","venkatesh"},
		{"chiru","Raviteja"},
		{"nag","nani"}
	};
	}
	@Test(dataProvider = "linkedin")
	public void linkedin(String userName,String password) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.Driver", "C:\\Users\\USER\\Downloads\\Tools\\updated tools file\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\\");
	ChromeDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.linkedin.com/");
	driver.findElement(By.xpath("//input[@name=\"session_key\"]")).sendKeys(userName);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id=\"session_password\"]")).sendKeys(password);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form/div[2]/button")).click();
	Thread.sleep(2000);
	//driver.close();
	driver.quit();
}
	//covered thinks are @DataProvider successfully
}