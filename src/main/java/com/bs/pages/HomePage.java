package com.bs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(id = "didomi-notice-agree-button")
	private WebElement acceptAll;

	@FindBy(xpath = "//img[@alt='EL PAÍS']/../../../../../../following-sibling::div//a[contains(@href,'opinion')]")
	private WebElement opinionLink;

	public WebElement getOpinionLink() {
		return opinionLink;
	}

	public WebElement getAcceptAll() {
		return acceptAll;
	}

}
