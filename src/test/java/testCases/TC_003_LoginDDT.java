package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.loginpage;
import pageObjects.myaccountpage;
import utilities.Dataproviders;

public class TC_003_LoginDDT extends Baseclass {

	
	
@Test(dataProvider="logindata",dataProviderClass=Dataproviders.class,groups="master")	//if the data provider is present in another class then mention clas
public void verify_LoginDDT(String email,String password,String exp)
{
	logger.info("Starting_TC_003_loginddttest");
	try
	{
//	Homepage hp=new Homepage(driver);
//	hp.clicklogin();
logger.info("Starting logging process");
//appurl1
loginpage lp=new loginpage(driver);
lp.setemail(email);
lp.setpassword(password);
lp.clicklogin();


myaccountpage macc=new myaccountpage(driver);
boolean targetpage=macc.ismyaccountpageexists();
macc.clickdropdown();



if(exp.equalsIgnoreCase("valid"))
{
	if(targetpage==true)
{
		macc.clicklogout();
		Assert.assertTrue(true);		

}
	else
	{
		Assert.assertTrue(false);
	}}
//Data is invalid--login sucess--test fail--logout
	//Data is invalid --login failed--test pass
	if(exp.equalsIgnoreCase("invalid"))
	{
		if(targetpage==true)
		{
			macc.clicklogout();
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
		}
	}}
	catch(Exception e)
	{
	Assert.fail();	
		
	}
}}
			
			
			
			
