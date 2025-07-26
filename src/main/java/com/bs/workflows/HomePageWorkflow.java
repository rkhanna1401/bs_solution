package com.bs.workflows;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.bs.constants.IUrlConstants;
import com.bs.manager.WorkflowManager;
import com.bs.utilities.SeleniumWaits;

public class HomePageWorkflow {

	private WebDriver driver;
	private WorkflowManager workflowManager;
	private SeleniumWaits seleniumWaits;

	public HomePageWorkflow(WebDriver driver) {
		this.driver = driver;
		seleniumWaits = new SeleniumWaits(driver);
		workflowManager = new WorkflowManager();
	}


	public  void acceptCookies() {
		By acceptBtnLocator = By.id("didomi-notice-agree-button");
		int retries = 5;

		for (int i = 0; i < retries; i++) {
			try {
				WebElement btn = seleniumWaits.waitUntilElementIsLoadedAndClickable(acceptBtnLocator);
				btn.click();
				break; 
			} catch (StaleElementReferenceException e) {
				System.out.println("Retrying due to stale element...");
			} catch (Exception e) {
				System.out.println("Cookie banner not found or already dismissed.");
				break;
			}
		}
	}


	public void selectOpinionTab() {	
		acceptCookies();
		driver.navigate().to(IUrlConstants.WEB_URL + "opinion");
		//		WebElement el = workflowManager.getHomePage(driver).getOpinionLink();
		//		wait.addFluentWait(el);
		//		el.click();

	}

}
