package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.Chrome.Driver", "Chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement DatePicker = driver.findElement(By.name("dob"));
		DatePicker.click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-month']")));
		
		
		WebElement Month = driver.findElement(By.xpath("//select[@class = 'ui-datepicker-month']"));

		Select ddMonth = new Select(Month);
		ddMonth.selectByVisibleText("Oct");

		WebElement Year = driver.findElement(By.xpath("//select[@class = 'ui-datepicker-year']"));

		Select ddYear = new Select(Year);
		ddYear.selectByVisibleText("1994");

		WebElement Date = driver.findElement(By.xpath("//a[@data-date= '29']"));
        Date.click();

	}

}
