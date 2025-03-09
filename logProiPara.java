package com.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class logProiPara {
	WebDriver driver;
	@BeforeTest
	public void initialise() {
	driver = new ChromeDriver();
	}
	@AfterTest
	public void close() {		
	}
	@Parameters("url")
	@Test(priority = 1)
	public void urlClick( String url) {
		driver.get(url);
	}
	@Parameters({"a", "b"})
	@Test(priority = 2 )
	public void enterData(@Optional("student") String a, @Optional("Password123") String b) throws Exception {
	    driver.findElement(By.id("username")).sendKeys(a);
	    driver.findElement(By.name("password")).sendKeys(b);
	}
	@Test(priority = 3)
	public void btnClick() {
		driver.findElement(By.id("submit")).click();
	}
	@Test(priority = 4)
	public void logout() {
		driver.findElement(By.xpath("//a[contains(text(),\"Log out\")]")).click();
	}	
}