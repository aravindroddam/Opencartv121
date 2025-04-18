package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Accountregistrationpage;
import pageObjects.Homepage;
import pageObjects.loginpage;

public class TC_001_AccountRegistrationTest extends Baseclass{

	@Test(groups="Regression")
	public void verify_Account_Registration()
	{
		logger.info("clicked on my account link");
		try
		{
		Homepage hp=new Homepage(driver);
	
		hp.clickRegister();
		hp.clicklogin();
	
		logger.info("providing user details");
		Accountregistrationpage reg= new Accountregistrationpage(driver);
		reg.setGender();
		reg.setfirstname("ffffk");
		reg.setlastname("kkki");
		reg.setEmail("asd@gmail.com");
		reg.setCompany("okjih");
		//String Password=randomAlphanumeric();
		reg.setpassword("fas1234930uu@");
		reg.setcomfirmpassword("fas1234930uu@");
		reg.clicksubmittbutton();
	reg.messageconfiramtion();

		
		}
catch(Exception e)
{
logger.error("Test case sucessfully executed");


}}}
	

