package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.Chrome.Driver", "Chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.simplilearn.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(3000);

		WebElement User = driver.findElement(By.name("user_login"));
		User.sendKeys("abc@xyz.com");
		WebElement Pass = driver.findElement(By.id("password"));
		Pass.sendKeys("Abdc@123");
		WebElement remberme = driver.findElement(By.className("rememberMe"));
		remberme.click();
		WebElement Login = driver.findElement(By.name("btn_login")); 
		Login.click();
		
		String ExError = "The email or password you have entered is invalid.";
		WebElement error = driver.findElement(By.id("msg_box"));
		String AcError = error.getText();
		
		if(AcError.equals(ExError)) {
			System.out.println("TC Passed");
		}else {
			System.out.println("TC failed");
		}
		
		List<WebElement> Lists = driver.findElements(By.tagName("a"));
		
		System.out.println("Size of list is " +Lists.size());
		
		for(int index = 0; index < Lists.size(); index++) {
			System.out.println(Lists.get(index).getAttribute("href"));
		}
		
		driver.close();
	}

}
