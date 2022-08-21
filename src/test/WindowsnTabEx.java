package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsnTabEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.Chrome.Driver", "Chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String ParentWH= driver.getWindowHandle();
		System.out.println("Before clicking on tab button "+ParentWH);
		WebElement Tab = driver.findElement(By.id("tabButton"));
		Tab.click();
		System.out.println("After Clicking on tab button ");
		
		Set<String> AllWins = driver.getWindowHandles();
		for(String win : AllWins ) {
			System.out.println(win);
			
			if(!win.equals(ParentWH)) {
				driver.switchTo().window(win);
				
			}
			
		}
		WebElement ChildContent = driver.findElement(By.id("sampleHeading"));
		System.out.println(ChildContent.getText());
		driver.close();
		driver.switchTo().window(ParentWH);
		WebElement Window = driver.findElement(By.id("windowButton"));
		Window.click();
	
		
	}

}
