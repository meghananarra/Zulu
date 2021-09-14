package com.CreatepurchaseTest

import com.Zulu.genericLib.BaseTest;
import com.Zulu.genericLib.FileLib;
import com.Zulu.genericLib.WebDriverCommonLib;

public class CreatePurchaseTest1 extends BaseTest 
{
	public static void main(String ars[]) throws Throwable


	BaseTest bt=new BaseTest();
	bt.openBrowser();
	FileLib flib=new FileLib();
	LoginPage lp=new LoginPage();
    lp.loginToApp(flib.readPropertyData(PROP_PATH,"username"),flib.readPropertyData(PROP_PATH,"password"));
	WebDriverCommonLib wlib=new WebDriverCommonLib();
	wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH,"homeTitle"),"Home Page");
	HomePage hp=new HomePage();
	hp.clickPurchaseTab();
	wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "CustomViewTitle"),"Custom view page");
	
	CustomVeiwPage cv=new CustomVeiwPage();
	cv.clickNewPurchaseTab();
	
	wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "CreatePurchaseTitle"),"Create Purchase page");
	
	CreatePurchasePage cl=new CreatePurchasePage();
	cl.CreatePurchaseWithMandatoryDetails(flib.readExcelData(EXCEL_PATH,"Purchase",0,1),
flib.readExcelData(EXCEL_PATH,"Purchase",1,1),flib.readExcelData(EXCEL_PATH,"Purchase",2,1),
flib.readExcelData(EXCEL_PATH, "Purchase", 3,1), flib.readExcelData(EXCEL_PATH, "Purchase", 4, 1));
			
	wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "PurchaseDetailsTitle"),"Purchase Details Page");
	
}
}


