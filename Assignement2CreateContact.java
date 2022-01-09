package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignement2CreateContact {

	public static void main(String[] args) {
		
		//Initial Setup
		WebDriverManager.edgedriver().setup();
		
		EdgeDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.xpath("(//input[@id='username'])")).sendKeys("DemoCSR");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
				
		// 3. Click on Login Button using Class Locator
		driver.findElement(By.xpath("//input[@class = 'decorativeSubmit']")).click();
		
		// 4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//div[@id = 'label']")).click();
		
		// 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		// 6. Click on Create Contact
		driver.findElement(By.linkText("Create Contact")).click();
		
		//7. Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Test");
		
		// 8. Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("Rohit");
		
		// 9. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.xpath("//input[contains(@id,'createContactForm_firstNameLocal')]")).sendKeys("Test");
		
		// 10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.xpath("//input[contains(@id,'createContactForm_lastNameLocal')]")).sendKeys("rohit");
		
		// 11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.xpath("//input[contains(@id,'createContactForm_departmentName')]")).sendKeys("IT");
		
		// 12. Enter Description Field Using any Locator of your choice 
		driver.findElement(By.name("description")).sendKeys("This is test description");
		
		// 13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.xpath("//input[contains(@id,'createContactForm_primaryEmail')]")).sendKeys("rohit.test@yopmail.com");
		
		// 14. Select State/Province as NewYork Using Visible Text
		WebElement state = driver.findElement(By.xpath("//select[contains(@id,'createContactForm_generalStateProvinceGeoId')]"));
		Select dropdown = new Select(state);
		dropdown.selectByVisibleText("Utah");
		
			
		// 15. Click on Create Contact
		driver.findElement(By.xpath("//input[contains(@name,'submitButton')]")).click();
		
		// 16. Click on edit button
		driver.findElement(By.xpath("//div[@class = 'frameSectionExtra']/a[contains(text(),'Edit')]")).click();
		
		// 17. Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();
		
		// 18. Fill Important Note Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Test important note");
		
		// 19. Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@name = 'submitButton' and @value = 'Update']")).click();
		
		// 20. Get the Title of Resulting Page.
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		
		driver.close();
		
	}

}