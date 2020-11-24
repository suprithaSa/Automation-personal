import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Booking {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/supritha/Downloads/chromedriver");
		WebDriver driver =new ChromeDriver();

		driver.get("https://www.spicejet.com/"); 
		// driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='BLR']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		WebElement DateWidget = driver.findElement(By.id("ui-datepicker-div"));
		    java.util.List<WebElement> columns = DateWidget.findElements(By.tagName("td"));

		    for (WebElement cell: columns)
		    {
		        if (cell.getText().equals("24"))
		        {
		            cell.findElement(By.linkText("24")).click();
		            break;
		        }
		    }
		
		Thread.sleep(2000);
		driver.findElement(By.id("divpaxinfo")).click();
		Select s=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		s.selectByValue("1");
		Select s1=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		s1.selectByValue("0");
		Select s2=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		s2.selectByValue("0");
		
		Thread.sleep(2000);
		Select s3=new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s3.selectByValue("INR");
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
		WebElement radio1 = driver.findElement(By.cssSelector("input[id*='ControlGroupSelectView_AvailabilityInputSelectView_RadioButtonMkt1Fare1_0']"));
		radio1.click();
		WebElement radio2 = driver.findElement(By.cssSelector("input[id*='ControlGroupSelectView_AvailabilityInputSelectView_RadioButtonMkt2Fare1_0']"));
		radio2.click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement search= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id*='continue-to-contact-page']>div>span.button-continue-text")));
		search.click();

		 // Travelers page
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait2=new WebDriverWait(driver, 20);
		WebElement search2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_DropDownListTitle")));
		search2.click();
		 Select s4=new Select(driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_DropDownListTitle")));
			s4.selectByValue("MS");
			System.out.println("waited for 10 seconds");

		 driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxFirstName")).sendKeys("Supritha");
		 driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxLastName")).sendKeys("Achala");
		 driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxHomePhone")).sendKeys("1234567890");
		 driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxEmailAddress")).sendKeys("suprithaachala.sa@gmail.com");
		 
		 Select s5=new Select(driver.findElement(By.id("contact_cities_list_india")));
		 s5.selectByValue("Bengaluru");
		 driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_CheckBoxPromoOpt")).click();
		 driver.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_SJFlyingView_IamFlying")).click();
		 
		 // DOB
		 // Select s6=new Select(driver.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_DropDownListDocumentType0_0")));
		 // s6.selectByValue("Passport");
		 //Select s7=new Select(driver.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_DropDownListDocumentCountry0_0")));
		 //s7.selectByValue("India ");
		 //Select s8=new Select(driver.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_DropDownListDocumentCountryOfBirth0_0")));
		 //s8.selectByValue("India ");
		 //Select s9=new Select(driver.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_DropDownListDocumentNationality0_0")));
		 //s9.selectByValue("India ");
		 // Cal
		 //driver.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_TextBoxDocumentNumber0_0")).sendKeys("1234567890");
		
		 // Add-ons page
		 driver.findElement(By.id("continue-to-addons-page")).click();
		 driver.findElement(By.id("spiceAssuranceBtn")).click();
		 driver.findElement(By.id("chkZeroCancel")).click();
		 driver.findElement(By.id("select_all")).click();
		 
		 driver.findElement(By.id("a[id*='ControlGroupUnitMapView_UnitMapViewControl_LinkButtonSubmit']")).click();
		 
	}
}
