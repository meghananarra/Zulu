package com.Zulu.genericLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class WebDriverCommonLib {
	public String getPageTitle() {
		String pageTitle=BaseTest.driver.getTitle();
		return pageTitle;
	}
	public void verify(String actual,String expected,String page) {
		if(actual.equals(expected)) {
			System.out.println(page + "is Displayed, PASS");
		}
		else
		{
			System.out.println(page+"is not Dispalyed,FAIL");
		}
	}
	public void selectOption(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	
	public void selectOption(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void selectOption(String text,WebElement element) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void mouseHover(WebElement element) {
		Actions ac=new Actions(BaseTest.driver);
		ac.moveToElement(element).perform();
	}
	public void rightClick(WebElement element, WebElement source, WebElement target) {
		Actions ac=new Actions(BaseTest.driver);
		ac.dragAndDrop(source,target).perform();
	}
	public void switchToFrame(int index) {
		BaseTest.driver.switchTo().frame(index);
	}
	public void switchToFrame(String value) {
		BaseTest.driver.switchTo().frame(value);
		
		}
}

