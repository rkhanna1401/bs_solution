package com.bs.manager;

import org.openqa.selenium.WebDriver;

import com.bs.pages.BasePage;
import com.bs.pages.HomePage;
import com.bs.pages.OpinionPage;

public class WorkflowManager {

	private BasePage basePage;
	private HomePage homePage;
	private OpinionPage opinionPage;
	
	public BasePage getBasePage(WebDriver driver) {
		this.basePage = new BasePage(driver);
		return this.basePage;
	}
	
	public HomePage getHomePage(WebDriver driver) {
		this.homePage = new HomePage(driver);
		return this.homePage;
	}
	
	public OpinionPage getOpinionPage(WebDriver driver) {
		this.opinionPage = new OpinionPage(driver);
		return this.opinionPage;
	}
}
