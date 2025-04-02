package testcases;

import org.testng.annotations.Test;

import baseclass.BaseClass;
import pageobj.Search_page;
import pageobj.home_page;

public class testclass extends BaseClass {

	home_page hp ;
	Search_page sp;
	
	@Test
	public void search() {
		hp = new home_page();
		 hp.search();
		 sp = hp.clickOnSubmit();
		 sp.verifytitle();
	}
}
