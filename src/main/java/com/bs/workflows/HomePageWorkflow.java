package com.bs.workflows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bs.manager.WorkflowManager;
import com.bs.utilities.GenericUtils;
import com.bs.utilities.SeleniumWaits;

public class HomePageWorkflow {

	private WebDriver driver;
	private WorkflowManager workflowManager;
	private SeleniumWaits wait;

	public HomePageWorkflow(WebDriver driver) {
		this.driver = driver;
		wait = new SeleniumWaits(driver);
		workflowManager = new WorkflowManager();
	}

	public void selectOpinionTab() {	
		if(GenericUtils.isDisplayed(driver,workflowManager.getHomePage(driver).getAcceptAll())) {
			workflowManager.getHomePage(driver).getAcceptAll().click();
		}
		WebElement el = workflowManager.getHomePage(driver).getOpinionLink();
		wait.addFluentWait(el);
		el.click();
	}

}
