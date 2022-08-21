package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.Chrome.Driver", "Chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		WebElement UserName = driver.findElement(By.xpath("//input[@name = 'email']"));
		UserName.sendKeys("abc@xyz.com");
		WebElement Password= driver.findElement(By.xpath("//input[@type = 'password']"));
		Password.sendKeys("azsxdcd");
		WebElement Login = driver.findElement(By.xpath("//button[@name = 'login']"));
		Login.click();
		
		driver.close();
		
		
	}

}
