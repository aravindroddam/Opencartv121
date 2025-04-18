package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage {
WebDriver driver;
//constructor
public Basepage(WebDriver driver)
{
	this.driver=driver;
PageFactory.initElements(driver, this);


}}

