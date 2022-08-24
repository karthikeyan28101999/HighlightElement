package org.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By userName=By.cssSelector("input[name='username']");
	
	private  By password=By.name("password");
	
	private By login=By.tagName("button");
	
	private By warning=By.cssSelector(".oxd-alert-content-text");
	
	public WebElement UserName() {
	     
		return driver.findElement(userName);
	}
	public WebElement password() {
		return driver.findElement(password);
	}
	public WebElement login()
	{
		return driver.findElement(login);
	}
	public WebElement warning()
	{
		return driver.findElement(warning);
	}

}
