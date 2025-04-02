package pageobj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.BaseClass;

public class home_page extends BaseClass {
	@FindBy(name = "q")
	WebElement seacrchbox;
	
	@FindBy(className = "gNO89b")
	WebElement seacrchbtn;
	
	public home_page () {
		
		PageFactory.initElements(driver, this);
	}
	
	public void search() {
		actn.sendkey(seacrchbox, "mobiles");
	}
	
	public Search_page clickOnSubmit() {
		seacrchbtn.click();
		return new Search_page();
	}
}
