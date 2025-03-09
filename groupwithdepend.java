package com.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;


import org.openqa.selenium.Dimension;


import org.openqa.selenium.Point;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class groupwithdepend {
	WebDriver 	driver = new ChromeDriver();
	

    @BeforeSuite
    public void initialise() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(600, 600));
        driver.manage().window().setPosition(new Point(850, 0));}
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

	@Parameters("url")
	@Test(priority = 1 ,groups = "done")
	public void urlClick( String url) {
		driver.get(url);
	}
	@Test(priority = 4,dependsOnMethods = "btnClick")
	public void logout() {
		driver.findElement(By.xpath("//a[contains(text(),\"Log out\")]")).click();
	}
	@Parameters({"a", "b"})
	@Test(priority = 2 ,dependsOnMethods = "urlClick"  ,dependsOnGroups = "done")
	public void enterData(@Optional("student") String a, @Optional("Password123") String b) throws Exception {
	    driver.findElement(By.id("username")).sendKeys(a);
	    driver.findElement(By.name("password")).sendKeys(b);
	}
	@Test(priority = 3 ,dependsOnMethods = "enterData" ,dependsOnGroups = "done")
	public void btnClick() {
		driver.findElement(By.id("submit")).click();
	}

	
	
	
}