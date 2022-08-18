package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojo extends BaseClass {
	
	

	public Pojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	private WebElement txtuser;

	@FindBy(id = "pass")
	private WebElement txtpass;

	@FindBy(name = "login")
	private WebElement clkbtn;
	
	@FindBy(className="_9ay7")
	
	private WebElement error;
	
	@FindAll({
		
		@FindBy(xpath="//span[text()='Welcome to Facebook, Suresh']"),
		@FindBy(xpath="//div[@class='bcvklqu9 nzypyw8j']"),
		@FindBy(xpath="(//span[@dir='auto'])[21]")
	})
	
	private WebElement crtpage;

	public WebElement getCrtpage() {
		return crtpage;
	}

	public WebElement getError() {
		return error;
	}

	public WebElement getTxtuser() {
		return txtuser;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

	public WebElement getClkbtn() {
		return clkbtn;
	}

}


