package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

public class Utilityclass {
		
	
	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static Logger logger=LogManager.getLogger(); 
	public String testname,  testdescription,testcategory, testauthour;
	public static WebDriverWait wait;
	
	
	
	public void Wait() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
public void browsersetup(String br) {
	
	switch(br.toLowerCase())
	{
	case "chrome": driver= new ChromeDriver();break;
	case "edge" : driver=new EdgeDriver();break;
	case "firefox" : driver=new FirefoxDriver();break;
	default: System.out.println("INVALID BROWSER"); return;
	}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
       }


public void geturl(String url) {
	driver.get(url);
	
}
		
		public static int getRowCount(String xlfile , String xlSheet) throws IOException {
			
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlSheet);
			int rowcount= ws.getLastRowNum();
			wb.close();
			fi.close();
			
			return rowcount;
			
		}
		
		public static int getcellcount(String xlfile, String xlSheet, int rownum) throws IOException {
			
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlSheet);
			row=ws.getRow(rownum);
			int cellcount=row.getLastCellNum();
			wb.close();
			fi.close();
			
			return cellcount;
			
			}
		
		public static String getcelldata(String xlfile, String xlSheet, int rownum, int colnum) throws IOException {
			
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlSheet);
			row=ws.getRow(rownum);
			
			if (row==null) {
			wb.close();
			fi.close();
			return "";
			}
			
			cell=row.getCell(colnum);
			
			DataFormatter formatter=new DataFormatter();
			String data = formatter.formatCellValue(cell);
			
		    if(data == null || data.trim().isEmpty()){
			        return "";
			        }
			
			
			return data;
			
		}
		
		public static String screenshot(String name) throws IOException {
			
			String timestamp=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			TakesScreenshot ts=(TakesScreenshot)driver;
			String path=System.getProperty("user.dir")+"/Screenshot/"+name+timestamp+".png";
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File(path);
			FileUtils.copyFile(src, dest);
			return path;
			
		}
		
		
	
}
