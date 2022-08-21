package test;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.Chrome.Driver", "Chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement SignUp = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		SignUp.click();

		WebElement FName = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement LName = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement Mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));

		FName.sendKeys("Fname");
		LName.sendKeys("Lname");
		Mobile.sendKeys("123456789");
		Password.sendKeys("abc@123");


		WebElement Day =  driver.findElement(By.name("birthday_day"));

		Select ddDay = new Select(Day);
		System.out.println("Selected Day is " + ddDay.getFirstSelectedOption().getText());
		ddDay.selectByVisibleText("20");


		WebElement Month =  driver.findElement(By.name("birthday_month"));

		Select ddMonth = new Select(Month);
		System.out.println("Selected month is " + ddMonth.getFirstSelectedOption().getText());
		ddMonth.selectByVisibleText("Jan");

		WebElement SelectedMonth = driver.findElement(By.xpath("//select[@name = 'birthday_month']/option[@selected = '1']"));
		System.out.println(SelectedMonth);

		WebElement Year =  driver.findElement(By.name("birthday_year"));

		Select ddYear = new Select(Year);
		System.out.println("Selected year is " + ddYear.getFirstSelectedOption().getText());
		ddYear.selectByVisibleText("1994");



		List<WebElement> months = ddMonth.getOptions();
		for(WebElement elm : months) {
			System.out.println(elm.getText());
		}


		List <WebElement> AllMonths = driver.findElements(By.xpath("//select[@name = 'birthday_month']/option"));
		for(WebElement elm : AllMonths) {
			System.out.println(elm.getText());
		}

		String Gender = "Female";
//		WebElement Male = driver.findElement(By.xpath("//input[@type = 'radio' and @value = '2']"));
//		WebElement female = driver.findElement(By.xpath("//input[@type = 'radio' and @value = '1']"));
//		WebElement other = driver.findElement(By.xpath("//input[@type = 'radio' and @value = '-1']"));
//
//		if(Gender.equals("Female")) {
//
//			female.click();
//
//		}else if(Gender.equals("Male")){
//
//			Male.click();
//
//		}else {
//			other.click();
//		}

		String Xpath = "//label[text()='" + Gender + "']/following-sibling::input";

		WebElement GendgerRadioBtn = driver.findElement(By.xpath(Xpath));
		GendgerRadioBtn.click();


		driver.close();


	}

}
