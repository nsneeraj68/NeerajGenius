package automationassignment;
 
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class blazedemo {
WebDriver driver;
    @BeforeTest
public void initialization(){
    // To set the path of the Firefox driver.
System.setProperty("webdriver.gecko.driver", "C:\\Users\\Neeraj Sharma\\eclipse-workspace\\DataDrivenFramework\\driver\\geckodriver.exe");
driver = new FirefoxDriver();
    
    // To launch blazedemo website
    driver.get("http://blazedemo.com/");
    // To maximize the browser
    driver.manage().window().maximize();
    // implicit wait
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
  
@Test
public void SalesforceLoginLogout() throws IOException{

//select the dropdown value from Departure city
driver.findElement(By.xpath("//select[@name='fromPort']")).click();

Select drpdeparture  = new Select(driver.findElement(By.name("fromPort")));
drpdeparture.selectByVisibleText("Boston");

Select drpdestination  = new Select(driver.findElement(By.name("toPort")));
drpdestination.selectByVisibleText("Berlin");

driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
driver.findElement(By.xpath("//tr[1]//td[1]//input[1]")).click();

driver.findElement(By.id("inputName")).sendKeys("TestUser");

Select drpCardType  = new Select(driver.findElement(By.name("cardType")));
drpCardType.selectByVisibleText("American Express");

driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();


if(driver.getPageSource().contains("Thank you for your purchase today"))
 
{
 
System.out.println("Ticket is Purchased");
 
}
 
else
 
{
 
System.out.println("Ticket purcahse is not successful");
 
}
}
}
