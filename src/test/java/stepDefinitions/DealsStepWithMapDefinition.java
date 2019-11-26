package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


//data table with maps : for parameterization of test cases

public class DealsStepWithMapDefinition {

	WebDriver driver;

	@Given("^user is already on Login Page$")
	public void user_already_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ui.freecrm.com/");
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_free_CRM() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cogmento CRM", title);	
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credentials) {
		for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {

			driver.findElement(By.name("email")).sendKeys(data.get("username"));
			driver.findElement(By.xpath("//div[@class='field']/child::div//input[@type='password']")).sendKeys(data.get("password"));

		}

	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		WebElement loginBtn = driver.findElement(By.xpath("//div[text()='Login']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}

	@Then("^user is on home page$")
	public void user_is_on_hopme_page() {
		String title = driver.getTitle();
		System.out.println("Home Page title ::" + title);
		Assert.assertEquals("Cogmento CRM", title);
	}

	@Then("^user moves to new deal page$")
	public void user_moves_to_new_deals_page() {
		//driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Deals')]"))).click().build().perform();
		driver.findElement(By.xpath("//button[contains(text(),'New')]")).click();

	}

	@Then("^user enters deal details$")
	public void user_enters_contacts_details(DataTable dealData) {

		for (Map<String, String> data : dealData.asMaps(String.class, String.class)) {

			driver.findElement(By.xpath("//input[@name='title']")).sendKeys(data.get("title"));
			driver.findElement(By.xpath("//div[@class='field']/label[text()='Assigned To']/following::div[1]")).sendKeys(data.get("amount"));
			driver.findElement(By.xpath("//div[@name='products']")).sendKeys(data.get("probability"));
			driver.findElement(By.xpath("//input[@name='commission']")).sendKeys(data.get("commission"));
			
			driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click(); //save button
			
			//move to new deal page:
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
			driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();

		}

		
	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

}
