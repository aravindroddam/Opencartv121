package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends Basepage {
//constructor
	
	public loginpage(WebDriver driver)
	{
		super(driver);
	}

	//locators
//@FindBy(xpath="//input[@class='email']")
//WebElement txt_email;
//
//@FindBy(xpath="//input[@type='password']")
//WebElement txt_password;
//
//@FindBy(xpath="//button[@type='submit'][@class='button-1 login-button']")
//WebElement login_button;

//appurl1
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement txt_email;

	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txt_password;

	@FindBy(xpath="//button[@type='submit']")
	WebElement login_button;

//Action method

public void setemail(String email)
{
	txt_email.sendKeys(email);
	
}
public void setpassword(String pwd)
{
	txt_password.sendKeys(pwd);
}
public void clicklogin()
{
	login_button.click();
}



}
