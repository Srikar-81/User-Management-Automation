package com.tests;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class main {
	WebDriver driver=new ChromeDriver();
	Actions actions=new Actions(driver);
	@Test(priority = 1)
	public void launchBrowser() { 
		driver.get("https://demo.automationtesting.in/Register.html");
		System.out.println("title = "+ driver.getTitle());
		System.out.println("current url = " +driver.getCurrentUrl());
	}
	@Test(groups = "alerts" ,priority = 10)
	public void alertCancel() {
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//a[contains(text(),\"Switch\")]")).click();;;
		driver.findElement(By.xpath("//a[contains(text(),\"Alert\")]")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Alert with OK & Cancel \")]")).click();
		driver.findElement(By.xpath("//button[contains(text(),\"confirm box \")]")).click();
		driver.switchTo().alert().dismiss();
	}
	@Test(groups = "alerts",priority = 9 )
	public void alert() {
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//a[contains(text(),'Switch')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Alert\")]")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Alert with OK\")]")).click();
		driver.findElement(By.xpath("//button[contains(text(),\"alert box\")]")).click();;
		driver.switchTo().alert().accept();
	}
	@Test(groups = "alerts",priority = 11 ) 
	public void alertPromt() { 
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//a[contains(text(),'Switch')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Alert\")]")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Alert with Textbox \")]")).click();
		driver.findElement(By.xpath("//button[contains(text(),\"prompt box \")]")).click();
		driver.switchTo().alert().sendKeys("puspha");
		driver.switchTo().alert().accept();
	}
	@Test(groups = "dropDown" ,priority = 5) 
	public void dropDown() { 
		driver.get("https://demo.automationtesting.in/Register.html");
		WebElement skill=driver.findElement(By.id("Skills"));
		Select skillset = new Select(skill);
		skillset.selectByIndex(2);
		skillset.selectByIndex(3);
		skillset.selectByValue("Android");
		skillset.selectByValue("AutoCAD");
		WebElement country=driver.findElement(By.id("country"));
		Select countydrop = new Select(country);
		List<WebElement> countydropOpt=countydrop.getOptions();
		for (WebElement Option : countydropOpt ) {
			System.out.println(Option.getText());
		}
		countydrop.selectByIndex(5);
		countydrop.selectByValue("Japan");
		countydrop.selectByVisibleText("New Zealand");
	}

	@Test(groups = "textboxes" ,priority = 2) 
	public void textboxes() { 
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys("Srikar");
		driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys("chittipanthula");
		driver.findElement(By.xpath("//textarea[@ng-model=\"Adress\"]")).sendKeys("chamalapalli village ");
		driver.findElement(By.xpath("//input[@ng-model=\"EmailAdress\"]")).sendKeys("chsrikar2066@gmail.com ");
		driver.findElement(By.xpath("//input[@ng-model=\"Phone\"]")).sendKeys("6305332384");
		driver.findElement(By.xpath("(//input[@name=\"radiooptions\"])[1]")).click();
		driver.findElement(By.xpath("(//input[@name=\"radiooptions\"])[2]")).click();
	}
	@Test(groups = "radioBtn" ,priority = 4 ) 
	public void radioBtn() { 
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("(//input[@name=\"radiooptions\"])[1]")).click();
		driver.findElement(By.xpath("(//input[@name=\"radiooptions\"])[2]")).click();
	}
	@Test(groups = "checkbox" ,priority = 3)
	public void checkbox() { 
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.id("checkbox1")).click();
		driver.findElement(By.id("checkbox2")).click();
		driver.findElement(By.id("checkbox3")).click();
	}
	@Test(groups = "password" ,priority = 6 )
	public void password() { 
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//input[@id=\"firstpassword\"]")).sendKeys("srikare@2500246");	
		driver.findElement(By.xpath("//input[@id=\"secondpassword\"]")).sendKeys("srikare@2500246");
	}
	@Test(groups = "signup" ,priority = 7)
	public void signup() { 
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.name("signup")).click();
	}
	@Test(groups = "navigation",priority = 8 )
	public void navigation() { 
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.navigate().to("https://www.linkedin.com/login");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
	@Test(groups = "Frames",priority = 12)
	public void Frames() { 
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.switchTo().frame("SingleFrame");
		driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys("srikar"); 
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//a[contains(text(),\" an Iframe\")]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"MultipleFrames.html\"]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"SingleFrame.html\"]"))); 
		driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys("chittipanthula");
		driver.switchTo().parentFrame();
		driver.navigate().to("https://www.facebook.com/");	
	}
	@Test(groups = "keyboard", priority = 13 )
	public void keyboard() { 
		driver.get("https://demo.automationtesting.in/Register.html");
		Actions actions=new Actions(driver);
		WebElement wd =driver.findElement(By.xpath("//textArea[@ng-model=\"Adress\"]"));
		WebElement fn =driver.findElement(By.xpath("//input[@ng-model=\"FirstName\"]"));
		WebElement ln =driver.findElement(By.xpath("//input[@ng-model=\"LastName\"]"));
		wd.sendKeys("QA automation ");
		actions.click(wd).keyDown(wd,Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		actions.click(fn).keyDown(fn,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		actions.click(ln).keyDown(ln,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		actions.click(wd).keyDown(wd,Keys.BACK_SPACE).build().perform();
	}
	@Test(groups = "mouse",priority = 14 )
	public void mouse() { 
		driver.get("https://demo.automationtesting.in/Static.html");
		WebElement soc=driver.findElement(By.xpath("//img[@src=\"selenium.png\"]"));
		WebElement des=driver.findElement(By.xpath("//div[@id=\"droparea\"]"));
		actions.clickAndHold(soc).moveToElement(des).release().build().perform();
		driver.get("https://demo.automationtesting.in/Register.html");
		actions.doubleClick(driver.findElement(By.xpath("//label[contains(text(),\"Full\")]"))).build().perform();
		System.out.println("done");
		driver.get("https://demo.automationtesting.in/Register.html");
		actions.contextClick(driver.findElement(By.xpath("//label[contains(text(),\"Full\")]"))).build().perform();
	}
}












