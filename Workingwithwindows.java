package StepDefinitions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class Workingwithwindows {
	WebDriver driver;
	String parentwindow;
	@Given("Go to {string} ulr")
	public void go_to_ulr(String Windowurl) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Driver\\chromedriver.exe");
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(Windowurl);
			parentwindow=driver.getWindowHandle();
	}
	@When("Click on the windows button")
	public void click_on_the_windows_button() {
	WebElement gotohomebutton=	driver.findElement(By.id("home"));
	gotohomebutton.click();
     Set<String> allwindows= driver.getWindowHandles();
     for (String newwindows : allwindows) {
		driver.switchTo().window(newwindows);
	}
     WebElement editbutton= driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[1]/a/img"));
	    editbutton.click();
	   driver.close();
	    driver.switchTo().window(parentwindow);
	   // driver.close();
	   
	}
	@Then("Click the edit button to perform action")
	public void click_the_edit_button_to_perform_action() {
		 driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button")).click();
		int windowssize= driver.getWindowHandles().size();
		System.out.println("size:"+windowssize);
		driver.findElement(By.id("color")).click();
		 Set<String> Getallwindows= driver.getWindowHandles();
		 for (String string : Getallwindows) {
			 driver.switchTo().window(string);
			if(!string.equals(parentwindow)) {
				driver.close();
			}
		}
		}
}
