//package stepDefinitions;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class GoogleLaunchApp {
//	
//	WebDriver driver;
//	
//	@Given("^Launch Application on Chrome$")
//	public void launch_Application_on_Chrome() throws Throwable {
//	   
//		System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("http://primusbank.qedgetech.com");
//		
//	}
//
//	@When("^I enter a username$")
//	public void i_enter_a_username() throws Throwable {
//	    
//		driver.findElement(By.xpath("txtuId")).sendKeys("Admin");
//	}
//
//	@When("^I enter a password$")
//	public void i_enter_a_password() throws Throwable {
//	    
//		driver.findElement(By.xpath("txtPword")).sendKeys("Admin");
//	}
//
//	@When("^I click on LoginButton$")
//	public void i_click_on_LoginButton() throws Throwable {
//		
//		driver.findElement(By.xpath("login")).click();
//	}
//
//	@Then("^I validate title$")
//	public void i_validate_title() throws Throwable {
//	    
//		Assert.assertEquals("Primus BANK", driver.getTitle());
//		
//	}
//
//
//
//}
