package com.triarq.qpathways.definations;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.triarq.qpathways.utils.CommonUtils;

public class LoginToQpathways {

	@Given("^open chrome and start qpathways$")
	public void open_chrome_and_start_qpathways() throws Throwable {
		WebDriverManager.chromedriver().version("77").setup();
		chromeOption = new ChromeOptions();
		ExtentTest test= CommonUtils.getExtendReport("Login Test");
		WebDriver driver= CommonUtils.getWebDriver();
		driver.manage().window().maximize();
		
		Map<String, Object> file = CommonUtils.getFile("D:/glodata/Rakhee/Testing/Datainputsheet/UserLogin.xlsx");
		if (file.get("status").equals("FOUND")) {
			test.log(Status.PASS, "Users Data Excel File Load Sucsess");
			
			driver.get("https://qa.qpathways.com/");
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
		System.out.println("Open Chrome and Sart qpathways");
	}

	@When("^i enter valid username and password$")
	public void i_enter_valid_username_and_password() throws Throwable {
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("akshay.aachat@triarqhealth.com	");
			WebElement NextButton = driver
					.findElement(By.xpath("//button[@class='float-right mt-2 btn-block mat-raised-button mat-primary']"));
			NextButton.click();
			driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Akshay@1406");
			WebElement SigninButton = driver
					.findElement(By.xpath("//button[@class='float-right mt-2 btn-block mat-raised-button mat-primary']"));
			SigninButton.click();
		System.out.println("enter username and password");
	}

	@Then("^user should be able to login sucsessfully$")
	public void user_should_be_able_to_login_sucsessfully() throws Throwable {
		try {
				boolean Episodes = false;
				System.out.println("Episodes Page 1- " + Episodes);
				Episodes = driver.findElement(By.xpath("//a[@href='#/episodes']")).isDisplayed();
				System.out.println("Episodes Page 2- " + Episodes);

				if (Episodes == true) {
					driver.findElement(By.xpath("//span[@class='text-white']")).click();
					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					driver.findElement(By.xpath("(//a[@class='dropdown-item'][3])[2]")).click();
					return;
				} else {
					System.out.println("Login Fail");
					return;
				}
			} catch (NoSuchElementException e) {
				return;
			}
		System.out.println("user should be login sucsesfull");
	}

}
