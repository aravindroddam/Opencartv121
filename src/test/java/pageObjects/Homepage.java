package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends Basepage {
//constructor
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	//locators
	
	
	
	@FindBy(xpath="//a[@class='ico-register']")
WebElement lnkregister;
	
	@FindBy(xpath="//a[@class='ico-login']")
	WebElement loginbutton;
	
	
	//Action method
//	public void MyAccount()
//	{
//		lnkmyaccount.click();
//	}
	public void clickRegister()
	{
		lnkregister.click();
	}
	
	public void clicklogin()
	{
	loginbutton.click();	
	}
	
	}
	
	
	
	
	

