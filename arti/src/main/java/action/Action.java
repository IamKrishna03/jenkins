
package action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import baseclass.BaseClass;

public class Action extends BaseClass {
	



	public void sendkey (WebElement ele , String data) {
		if (ele.isEnabled() && ele.isDisplayed()) {
			ele.click();
			ele.sendKeys(data);
		}
		else {
			System.out.println("This " + ele+ " element found cant write " + data);
		}
	}
	public String gettitle () {

		String actualtitle = driver.getTitle();
		return actualtitle;
	}

	public boolean verifytitle(String exptitle ) 
	{
		return driver.getTitle().equals(exptitle);
	}
	

	public String verifyurl(String expurl , WebDriver driver)
	{
		String actualurl = driver.getCurrentUrl(); 
		if(actualurl.equals(expurl)) {
			System.out.println("Url matched");
		}else {
			System.out.println("Url not matched");
		}
		return actualurl;
	}

	public boolean  verifytext (WebElement ele , String exptxt)
	{
		System.out.println(ele.getText() + " this is element text " + exptxt + " this is exptexxt");
		return ele.getText().equals(exptxt);
	}
	
	
	
	public void uploadimage(String fipath , WebElement fileupload) {
		String path = System.getProperty("user.dir");
		String lct = path + fipath;
		System.out.println(lct);
		fileupload.sendKeys(lct);

	}
	
	public void acceptalert() {
		Alert ab = driver.switchTo().alert();
		ab.accept();
	}
	
	public void cancelalert() {
		Alert ab = driver.switchTo().alert();
		ab.dismiss();
	}
	
	public boolean verifyvisible(WebElement ele) {
		
		return ele.isDisplayed();
	}
	public List findallbyclass(String classname) {
		List <WebElement> elements =driver.findElements(By.className(classname));
		return elements;
	}
	
	public List findallbyxpath(String xpath) {
		List <WebElement> elements =driver.findElements(By.xpath(xpath));
		return elements;
	}
	
	public void scroll(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Double yposition = (Double) js.executeScript("return arguments[0].getBoundingClientRect().top + window.scrollY;", element);
		long y = yposition.longValue();
		js.executeScript("window.scrollTo(0,arguments[0]);",y);
		
	}
	
	public void hover(WebElement ele) {
		System.out.println("converting");
		Actions ac = new Actions(driver);
		System.out.println("converted");
		ac.moveToElement(ele).perform();
	}
	


}
