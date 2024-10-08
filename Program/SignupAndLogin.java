package guvitask20;

import org.openqa.selenium.chrome.ChromeDriver;

import method.implicity.utilities.*;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupAndLogin {

	public static void main(String[] args) {

		//Webdriver instance
		WebDriver chrome = new ChromeDriver();
		//Maximize the web window.
		chrome.manage().window().maximize();
		//Global wait for all element.
		chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Navigating to website.
		chrome.get("https://www.guvi.in/");
		//User defined class method to take screenshots.
		CaptureScreenShot capture = new CaptureScreenShot();
		//Screenshot
		capture.fullScreen("GUVIPAGE", chrome);
		
		//Right side signup button
		chrome.findElement(By.xpath("//a[normalize-space()='Sign up']")).click();
		//Name input field
		chrome.findElement(By.id("name")).sendKeys("Hari Prasath S");
		//Email input field
		chrome.findElement(By.id("email")).sendKeys("testusertestmail.com@gmail.com");
		//Password input field
		chrome.findElement(By.id("password")).sendKeys("TestUser1234testmail");
		//Mobile number input field
		chrome.findElement(By.id("mobileNumber")).sendKeys("9786059987");
		//Click the signup button
		chrome.findElement(By.id("signup-btn")).click();
		
		//Screenshot
		capture.fullScreen("SignUpPage", chrome);
		//Title of the website
		System.out.println(chrome.getTitle() + "\n");
		
//		****************** Below SignUp is already done manually so cannot automate with same data ******************		
		
//		//Signup button
//		chrome.findElement(By.className("signup-btn")).click();
//		
		//1st Dropdown locator
//		WebElement Dropone = chrome.findElement(By.id("profileDrpDwn"));
//		//2nd Dropdown locator
//		WebElement Droptwo = chrome.findElement(By.id("degreeDrpDwn"));
//		
		//Initialized the select class by passing the webelements.
//		Select profile = new Select(Dropone);
//		Select degree = new Select(Droptwo);
//		
//		//Selecting required drop
//		profile.selectByIndex(4);
//		degree.selectByVisibleText("B.Sc. / M.Sc.");
//		
//		//Year of pass input field.
//		chrome.findElement(By.id("year")).sendKeys("2024");
//		
//		//Submit button	
//		//chrome.findElement(By.className("details-btn")).click();
	
//     ****************************************************************************************************************
		
		//Directing to Login link because already signup done.
		
		chrome.findElement(By.xpath("//a[text()='Click here to Login']")).click();	
		System.out.println(chrome.getTitle());
		
		//Screenshot
		capture.fullScreen("LoginPage", chrome);
		//Email Input field
		chrome.findElement(By.id("email")).sendKeys("testusertestmail.com@gmail.com");
		
		//Password Input field
		chrome.findElement(By.id("password")).sendKeys("TestUser1234testmail");
		//screenshot
		capture.fullScreen("LoginDetails", chrome);
		//button locator
		chrome.findElement(By.cssSelector("#login-btn")).click(); 
		
		//getting the logged page title
		System.out.println(chrome.getTitle());
		//getting the page URL.
		System.out.println(chrome.getCurrentUrl());
		
		By button = By.className("gravatar");
		chrome.findElement(button).click();
		//Screenshot
		capture.fullScreen("GUVILoggedIN", chrome, button);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Unable to wait for the Task!" + e.getMessage());
		}
		//Closing the browser.
		chrome.quit();
	}
	

}
