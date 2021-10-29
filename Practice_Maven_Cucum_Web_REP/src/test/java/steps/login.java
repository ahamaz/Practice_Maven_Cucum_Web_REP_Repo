package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {
//	@Given("user is  on homepage")
//	public void user_is_on_homepage() {
//	    // Write code here that turns the phrase above into concrete actions
//		System.out.println("hi");
		public static WebDriver driver;
		@Given("^user is  on homepage$")
		public void user_is_on_homepage() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
	        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("http://automationpractice.com/index.php");
	        System.out.println(driver.getCurrentUrl());
	}

	@When("user navigates to Login Page")
	public void user_navigates_to_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Sign in")).click();
//		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		System.out.println(driver.getCurrentUrl());
	}

	@When("user enters username and Password")
	public void user_enters_username_and_Password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(driver.getCurrentUrl());
//    	driver.findElement(By.id("email")).sendKeys("blog.cucumber@gmail.com");
    	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("blog.cucumber@gmail.com");
    	//*[@id="email"]
        driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");
        driver.findElement(By.id("SubmitLogin")).click(); 
	}

	@Then("success message is displayed")
	public void success_message_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
    	String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
    	String actual = driver.findElement(By.cssSelector(".info-account")).getText();
        Assert.assertEquals(exp_message, actual);
//        driver.quit(); 
	}
}
