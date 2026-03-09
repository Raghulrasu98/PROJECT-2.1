package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.Utilityclass;

public class Projectspecificmethods extends Utilityclass {
	
	@BeforeSuite
	public void reportintialization() {
		
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/src/test/resources/testoutput/demoblaze.html");
		
		sparkReporter.config().setDocumentTitle("automation report");
		sparkReporter.config().setReportName("functional testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
	
	}
	
	@BeforeClass
	public void testdescription() {
		
		test=extent.createTest(testname, testdescription);
		test.assignCategory(testcategory);
		test.assignAuthor(testauthour);
		
		}
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void browserlaunch(String url,String browser) {
		
		browsersetup(browser);
		geturl(url);
		
	}
	
	
	@DataProvider(name="xllogin")
	public Object[][] readlogin() throws IOException {
		String filepath = System.getProperty("user.dir") + "/src/test/resources/Data/DemoblazeData.xlsx";
		
		int row=Utilityclass.getRowCount(filepath, "Login");
		
		Object[][] data=new Object[row][4];
		for(int i=1; i<=row;i++) {
					
			data[i-1][0]=Utilityclass.getcelldata(filepath, "Login", i, 0);
			data[i-1][1]=Utilityclass.getcelldata(filepath, "Login", i, 1);
			data[i-1][2]=Utilityclass.getcelldata(filepath, "Login", i, 2);
			data[i-1][3]=Utilityclass.getcelldata(filepath, "Login", i, 3);
		}
		return data;
		
	}
	
	@DataProvider(name="xlsignup")
	public Object[][] readsignupdata() throws IOException {

	    String filepath = System.getProperty("user.dir") +
	            "/src/test/resources/Data/DemoblazeData.xlsx";

	    int row = Utilityclass.getRowCount(filepath, "Signup");

	    Object[][] data = new Object[row][4];

	    for(int i=1; i<=row; i++) {

	        data[i-1][0] = Utilityclass.getcelldata(filepath, "Signup", i, 0);
	        data[i-1][1] = Utilityclass.getcelldata(filepath, "Signup", i, 1);
	        data[i-1][2] = Utilityclass.getcelldata(filepath, "Signup", i, 2);
	        data[i-1][3] = Utilityclass.getcelldata(filepath, "Signup", i, 3);
	    }

	    return data;
	}
	@DataProvider(name="xllogindetails")
	public Object[][] logindetais() throws IOException {
		String filepath = System.getProperty("user.dir") + "/src/test/resources/Data/DemoblazeData.xlsx";
		
		int row=Utilityclass.getRowCount(filepath, "Logindetails");
		
		Object[][] data=new Object[row][2];
		for(int i=1; i<=row;i++) {
					
			data[i-1][0]=Utilityclass.getcelldata(filepath, "Logindetails", i, 0);
			data[i-1][1]=Utilityclass.getcelldata(filepath, "Logindetails", i, 1);
			
		}
		return data;
		
	}
	
	@DataProvider(name="xlcart")
	public Object[][] readcartdata() throws IOException {

	    String filepath = System.getProperty("user.dir") +
	            "/src/test/resources/Data/DemoblazeData.xlsx";

	    int row = Utilityclass.getRowCount(filepath, "Cart");

	    Object[][] data = new Object[row][4];

	    for(int i=1; i<=row; i++) {

	        data[i-1][0] = Utilityclass.getcelldata(filepath, "Cart", i, 0);
	        data[i-1][1] = Utilityclass.getcelldata(filepath, "Cart", i, 1);
	        data[i-1][2] = Utilityclass.getcelldata(filepath, "Cart", i, 2);
	        data[i-1][3] = Utilityclass.getcelldata(filepath, "Cart", i, 3);
	        
	    }

	    return data;
	}
	
	
	@AfterMethod
	public void closebrowser() throws InterruptedException {
		
		driver.quit();
		
	}

		
	@AfterSuite
	public void closereport() {
		extent.flush();
	}
	

}
