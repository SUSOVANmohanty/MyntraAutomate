package Myntra_automate;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Myntra {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//login in myntra with mob no & click continue
		driver.get("https://www.myntra.com/register");
		//driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='']")).sendKeys("7653094097");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='submitBottomOption']")).click();
		Thread.sleep(32000);
		driver.findElement(By.xpath("//div[@class='submitBottomOption']")).click();
		Thread.sleep(2000);
		
		//The OTP scenario put the OTP
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter otp please");
		String otp=sc.next();
		driver.findElement(By.xpath("//input[@name='otp0']")).sendKeys(otp);
		driver.findElement(By.xpath("//input[@name='otp1']")).sendKeys(otp);
		driver.findElement(By.xpath("//input[@name='otp2']")).sendKeys(otp);
		driver.findElement(By.xpath("//input[@name='otp3']")).sendKeys(otp);
		Thread.sleep(2000);
		
		//Using actions cls for hover the crusher to that Profile icon and then click on edit profile
		Actions a=new Actions(driver);
	    a.moveToElement(driver.findElement(By.xpath("//div[@data-reactid='853']"))).build().perform();
	    driver.findElement(By.xpath("//div[normalize-space()='Edit Profile']")).click();
	    
	    //Fill the form
	    driver.findElement(By.xpath("//div[@class='profileEdit-formDivision']//div[1]//div[1]//input[1]")).sendKeys("Susovan Mohanty");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//body/div[@id='mountRoot']/div[@class='application-base full-height']/div[@class='page-page']/div[@class='page-profile']/div[@class='profileEdit-card']/form[@class='profileEdit-smartForm']/div[@class='profileEdit-formDivision']/div[2]/div[1]/input[1]")).sendKeys("mohantysusovan04@gmail.com");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[normalize-space()='Male']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[4]//div[1]//input[1]")).sendKeys("24/10/1997");
	    Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@class='textInput-form-control textInput-mobileNumberInput']")).sendKeys("7978449593");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Save Details']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='verificationRequired-head']//img")).click();
        Thread.sleep(1000);
        
        //Again using the Actions cls for hovering the mouse to the men category and click on Dhoti
        Actions a1=new Actions(driver);
        a1.moveToElement(driver.findElement(By.xpath("//a[@class='desktop-main'][normalize-space()='Men']"))).build().perform();
        driver.findElement(By.xpath("//a[normalize-space()='Dhotis']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//h4[normalize-space()='Men Printed Dupion Silk Dhoti']")).click();
		Thread.sleep(5000);
		
		//Using window handel cause when you click on That silk dhoti that opens in a new window
		 Set<String>k=driver.getWindowHandles();
		 Iterator<String>it= k.iterator();
		 String parent=it.next();
		 String child=it.next();
		 driver.switchTo().window(child);
		 Thread.sleep(3000);
		 driver.switchTo().window(parent);
		 Thread.sleep(5000);
		 driver.switchTo().window(child);
		 
		 //click on size button and then add to bag an click on bag to chk that product is added or not then quit it
		 driver.findElement(By.xpath("//div[@id='sizeButtonsContainer']//div[1]//div[1]//button[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//body/div[@id='mountRoot']/div/div/main[@class='pdp-pdp-container']/div[@class='pdp-details common-clearfix']/div[@class='pdp-description-container']/div/div[2]/div[1]/div[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[normalize-space()='Bag']")).click();
		 Thread.sleep(3000);
		 driver.quit();   
	}
}
