package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountregistrationpage extends Basepage {
//constructor
	public Accountregistrationpage(WebDriver driver)
	{
		super(driver);
	}
	
//locators
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement Gender;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastname;

	
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement company;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement confirmpassword;
	
	@FindBy(xpath="//button[@id='register-button']")
	WebElement submitbutton;
	
	
	@FindBy(xpath="//div[text()='Your registration completed']")
	WebElement msgconfirmation;
	
	
	//Action method
	public void setGender()
	{
		Gender.click();
	}
	public void setfirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	public void setlastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	public void setCompany(String comp)
	{
		company.sendKeys(comp);
	}
public void setpassword(String pwd)
{
	password.sendKeys(pwd);
}
	public void setcomfirmpassword(String pwd)
	{
		confirmpassword.sendKeys(pwd);
		
	}
	
	public void clicksubmittbutton()
	{
		submitbutton.click();
	}
	
	public String messageconfiramtion()
	{
	try
	{
	return	(msgconfirmation.getText());
	}
	catch(Exception e)
	{
		return(e.getMessage());
	}}}
	
	
	
	

