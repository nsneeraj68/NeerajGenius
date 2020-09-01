package automationassignment;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class MercuryTour {
WebDriver driver;
XSSFWorkbook workbook;
XSSFSheet sheet;
XSSFCell cell;
    @BeforeTest
public void initialization(){
    // To set the path of the Firefox driver.
System.setProperty("webdriver.gecko.driver", "C:\\Users\\Neeraj Sharma\\eclipse-workspace\\Maersk\\driver\\geckodriver.exe");
driver = new FirefoxDriver();
    
    // To launch MercuryTour website
    driver.get("http://demo.guru99.com/test/newtours/index.php");
    // To maximize the browser
    driver.manage().window().maximize();
    // implicit wait
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
  
@Test
public void MercuryTour() throws IOException{
	
	File src=new File("C:\\Users\\Neeraj Sharma\\eclipse-workspace\\Maersk\\Excel\\TestData.xlsx");   
	// Load the file.
	FileInputStream fis = new FileInputStream(src);
	// Load the workbook.
	workbook = new XSSFWorkbook(fis);
	// Load the sheet in which data is stored.
	sheet= workbook.getSheetAt(0);
	for(int i=1; i<=sheet.getLastRowNum(); i++){
	// Import data for Email.
	cell = sheet.getRow(i).getCell(0);
	/*cell.setCellType(Cell.CELL_TYPE_STRING);*/
	driver.findElement(By.name("userName")).clear();
	driver.findElement(By.name("userName")).sendKeys(cell.getStringCellValue());

	// Import data for password.
	cell = sheet.getRow(i).getCell(1);
	/*cell.setCellType(Cell.CELL_TYPE_STRING);*/
	driver.findElement(By.name("password")).clear();         
	driver.findElement(By.name("password")).sendKeys(cell.getStringCellValue());

	/*driver.findElement(By.name("userName")).sendKeys("nsneeraj68@gmail.com");
	driver.findElement(By.name("password")).sendKeys("nsneeraj68");*/
	driver.findElement(By.name("submit")).click();
	
	
	
	driver.findElement(By.linkText("Flights")).click();
	driver.findElement(By.xpath("//body//b//input[2]")).click();
	
	
	
//select the dropdown value from Departure city
driver.findElement(By.xpath("//select[@name='passCount']")).click();

Select drpPassengers  = new Select(driver.findElement(By.name("passCount")));
drpPassengers.selectByVisibleText("1");

Select drpDepartingFrom  = new Select(driver.findElement(By.name("fromPort")));
drpDepartingFrom.selectByVisibleText("Frankfurt");

Select drpArrivingIn  = new Select(driver.findElement(By.name("toPort")));
drpArrivingIn.selectByVisibleText("London");

driver.findElement(By.name("findFlights")).click();


if(driver.getPageSource().contains("After flight finder - No Seats Avaialble"))
 
{
 
System.out.println("Flight not booked");
 
}
 
else
 
{
 
System.out.println("Flight is booked");
 
}
}
} }
