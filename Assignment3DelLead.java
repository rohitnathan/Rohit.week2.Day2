package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3DelLead {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		// Step 1: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leaftaps.com/opentaps/control/main");

		// Step 2: Enter username
		driver.findElement(By.xpath("(//input[@id='username'])")).sendKeys("DemoCSR");

		// Step3 : Enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");

		// Step4: Click Login
		driver.findElement(By.xpath("//input[@class = 'decorativeSubmit']")).click();

		// Step5: Click CRM/SFA link
		driver.findElement(By.xpath("//div[@id = 'label']")).click();

		// Step 6: Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		// Step 7: Click Find leads
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();

		// Step 8: Click on Phone
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();

		// Step9: Enter phone number
		WebElement countryCode = driver.findElement(By.name("phoneCountryCode"));
		countryCode.clear();
		countryCode.sendKeys("1");

		driver.findElement(By.xpath("//input[contains(@name,'phoneAreaCode')]")).sendKeys("91");

		driver.findElement(By.xpath("//input[contains(@name,'phoneNumber')]")).sendKeys("993838888");

		// Step 10: Click find leads button
		WebElement findLeadsButton = driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]"));
		findLeadsButton.click();
		Thread.sleep(2000);

		// Step 11: Capture lead ID of First Resulting lead
		WebElement leadID = driver
				.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a[1]"));
		String text = leadID.getText();
		System.out.println("Lead ID is: " + text);

		Thread.sleep(2000);

		// Step 12. Click First Resulting lead
		leadID.click();

		// 13. Click Delete
		driver.findElement(By.linkText("Delete")).click();
		Thread.sleep(2000);

		// 14. Click Find leads
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();

		// driver.findElement(By.linkText("Find Leads")).click();

		// 15. Enter captured lead ID
		driver.findElement(By.xpath("//input[@name = 'id']")).sendKeys(text);
		Thread.sleep(2000);

		// 16. Click find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);

		// 17. Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion
		WebElement message = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]"));
		String text2 = message.getText();
		String verify = "No records to display";

		if (verify.equalsIgnoreCase(text2)) {
			System.out.println("The Lead is deleted successfully");

		} else {
			System.out.println("Lead is not deleted");
		}

		// 18. Close the browser (Do not log out)
		driver.close();

	}

}