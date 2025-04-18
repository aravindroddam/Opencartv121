package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {

//dataprovider 1	
	@DataProvider(name="logindata")
	public String [][]getData() throws IOException 
	{
		String path="C:\\Users\\USER\\eclipse-workspace\\Opencartv121\\testData\\opencart_logindata.xlsx";//taking xlfile from testdata
		
		Exelutility xlutil=new Exelutility(path);  //creating an object for xlutility
		
		int totalrows=xlutil.getrowcount("Sheet2");
		int totalcols=xlutil.getcellcount("Sheet2",1);
		
		String logindata[][]=new String[totalrows][totalcols]; //created 2D array which can store
		
		for(int i=1;i<=totalrows;i++)  //1//read the data drom xl storing into 2D array
		{
			for(int j=0;j<totalcols;j++) //0/i is row j is col
		
		{
				logindata[i-1][j]=xlutil.getcelldata("Sheet2", i, j); //array index start from zero
						}
		}
		
		return logindata; //return 2D array
		
	}
	
	
	
	
}
