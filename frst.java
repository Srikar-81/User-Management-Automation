package com.tests;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class frst {
	@Test
	public  void facebook () throws InterruptedException {
		System.out.println("project folder" + System.getProperty("user.dir"));
		System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chrome.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(" https://www.facebook.com/login.php/");
		String expected = "Log in to Facebook";
		String actual = driver.getTitle();
		assertEquals(actual, expected);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("iamfacebook@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("password000");
		driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
		System.out.println("email and password entered");
	}
	@Test
	public  void automationtesting ()throws InterruptedException {
		System.out.println("project folder" + System.getProperty("user.dir"));
		System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir")+" //drivers.chromedriver.exe" );
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		System.out.println("title = "+ driver.getTitle());
		System.out.println("current url = " +driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("QA");
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("DEMO");
	}
}
