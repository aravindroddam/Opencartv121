package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myaccountpage extends Basepage{
public myaccountpage(WebDriver driver)
{
	super(driver);
}
//locators
//appurl
//@FindBy(xpath="//a[@href='/customer/info'][text()='My account'][@class='ico-account']")
//WebElement myaccount;
//@FindBy(xpath="//a[@class='ico-logout']")
//WebElement logout;
//appurl1
@FindBy(xpath="//img[@alt='client brand banner']")
WebElement myaccount;
@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
WebElement dropdown;
@FindBy(xpath="//a[text()='Logout']")
WebElement logout;


//action method


public boolean ismyaccountpageexists()
{
try
{
return(myaccount.isDisplayed());
}
catch(Exception e)
{
	return false;

}
}
public void clickdropdown() {
	
dropdown.click();
}
public void clicklogout() {
	
logout.click();	
}
}