package org.failed;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver initialize()
	{
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions option=new FirefoxOptions();
		option.addArguments("-headless");
		WebDriver driver=new FirefoxDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public static void  highLight(WebDriver driver,WebElement element)
	{
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='3px solid red'",element);
	   
	}
	public static void removeHighlight(WebDriver driver,WebElement element,String border)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='"+border+"'",element);
	}
	
	public void takeScreenShot(WebDriver driver,String testName)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshot\\"+testName+".png";
		try {
			FileUtils.copyFile(src,new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
