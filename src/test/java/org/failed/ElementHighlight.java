package org.failed;

import org.openqa.selenium.WebDriver;
import org.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.listener.*;

@Listeners(Listener.class)
public class ElementHighlight extends Base{
    public WebDriver driver;

    @Test(dataProvider="Userdata")
	public void orangeHrmLogin(String userName,String password,String result)
	{
    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    	LoginPage login=new LoginPage(driver);
    	
    	login.UserName().sendKeys(userName);
    	login.password().sendKeys(password);
    	login.login().click();
    	if(result.equals("unsucess"))
    	{
    		String warning=login.warning().getText();
    		highLight(driver,login.warning());
    		Assert.assertEquals("invallid",warning);
    	}
    	else
    	{
    		driver.manage().deleteAllCookies();
    	}
	}
    
    @DataProvider
    public String[][] Userdata()
    {
    	String[][] data= {
    			{"Admin","admin123","success"},
    			{"admin1","admin123","unsucess"}
    	                 };
    	return data;
    }
    @BeforeTest
    public void openBrowser()
    {
    	driver=initialize();
    }
    @AfterTest
    public void Browser()
    {
    	driver.close();
    }
    
}
