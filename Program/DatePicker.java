package guvitask20;

import method.implicity.utilities.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePicker {

	public static void main(String[] args) {
		
		//WebDriver instance
		WebDriver chrome = new ChromeDriver();
		//jqueryui.com website should load page within given time
		chrome.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
		//maximize the website.
		chrome.manage().window().maximize();
		//Global wait.
		chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Navigating to the website.
		chrome.navigate().to("https://jqueryui.com/datepicker/");
		//							(OR)
		//chrome.get("https://jqueryui.com/datepicker/");
		
		//User defined class used for take Fullscreen Screenshot.
		CaptureScreenShot capture = new CaptureScreenShot();
		capture.fullScreen("DatePickerPage", chrome);
		//Locating the frame element.
		WebElement iframes = chrome.findElement(By.xpath("//iframe[@class = 'demo-frame']"));
		
		//switching to the frame.
		chrome.switchTo().frame(iframes);
		
		//locating the date input field.
		WebElement datefield = chrome.findElement(By.id("datepicker"));
		datefield.click();
		
		WebElement nxt = chrome.findElement(By.xpath("//span[text()='Next']"));
		capture.fullScreen("DateSelecting", chrome);
		//By using For loop to click the next button twice. 
		//for(int i=0;i<2;i++)
		//{
		//		nxt.click();
		//}
		//                            (OR)
		
		//Creating the Action class instance.
		Actions act = new Actions(chrome);
		
		//clicking the element twice.
		act.doubleClick(nxt).build().perform();
		
		//locating the date in the calender
		chrome.findElement(By.xpath("//tbody/tr[4]/td[6]")).click();
		
		
		//Getting the input field value using getattributes .
		String date = datefield.getAttribute("value");
		//printing the date value
		System.out.println("Selected Date : " + date);
		capture.fullScreen("DateSelected", chrome);
	}

}
