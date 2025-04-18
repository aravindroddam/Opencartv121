package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.loginpage;
import pageObjects.myaccountpage;

public class Tc_002_loginTest extends Baseclass{

	@Test(groups={"Sanity","master"})
	public void  verify_login()
	{
		logger.info("Starting Tc_002_logintest");;
//try
//{
		//Homepage hp=new Homepage(driver);
			//hp.clicklogin();
	logger.info("Starting logging process");
	
	loginpage lp=new loginpage(driver);
	lp.setemail(p.getProperty("email1"));
	lp.setpassword(p.getProperty("password1"));
	lp.clicklogin();
	//myaccountpage
	
//	myaccountpage macc=new myaccountpage(driver);
//	boolean targetpage=macc.ismyaccountpageexists();
//	Assert.assertEquals(targetpage,true,"login failed");
//
//}
//catch(Exception e)
//	{
//	
//	Assert.fail();	
//	}
//	}


	}}
//}
