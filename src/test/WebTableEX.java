package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.Chrome.Driver", "Chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("All Rows in table "+ rows.size());

		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']//th"));
		System.out.println("All Rows in table "+ columns.size());

		WebElement Data = driver.findElement(By.xpath("//table[@id='customers']//tr[4]/td[1]"));
		System.out.println("Data is "+ Data.getText());


		for(WebElement row: rows) {

			List<WebElement> AllCell = row.findElements(By.tagName("td"));

			for(WebElement cell: AllCell) {

				System.out.print(cell.getText() + "  ");
			}

			System.out.println();

		}

		for(int i=1;i<=rows.size();i++) {
			for(int j=1;j<=columns.size();j++) {
				WebElement Cells = driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]/*["+j+"]"));
				System.out.print(Cells.getText()+"\t");
			}
			System.out.println();
		}


		String Company = "Magazzini Alimentari Riuniti";

		String Xpath = "//td[text()='" + Company + "']/following-sibling::td[2]";
		WebElement Country = driver.findElement(By.xpath(Xpath));
		System.out.println("The country is " + Country.getText());
		driver.close();

	}
}

