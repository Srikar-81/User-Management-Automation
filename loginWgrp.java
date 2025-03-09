package com.tests;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
public class loginWgrp {
	WebDriver driver = new ChromeDriver();
	@Test(priority = 1)
	public void urlClick() {
	driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	@Test(priority = 3)
	public void btnClick() {
		driver.findElement(By.id("submit")).click();
	}

	
	@Test(priority = 2 , groups = "pw" )
	public void enterData() throws InterruptedException {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("student");
	    driver.findElement(By.name("password")).sendKeys("Password123");
	}
		
	
	
	@Test(priority = 4)
	public void logout() {
		driver.findElement(By.xpath("//a[contains(text(),\"Log out\")]")).click();
	}


	 @AfterClass
	    public void tearDown() {
		 driver.close();
	        driver.quit();
	    }
}