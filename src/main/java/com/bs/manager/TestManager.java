package com.bs.manager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.bs.drivermanager.SeleniumWebDriverManager;
import com.bs.utilities.ConfigReader;
import com.bs.utilities.GenericUtils;
import com.bs.workflows.HomePageWorkflow;
import com.bs.workflows.OpinionPageWorkflow;

public class TestManager {

	public static WorkflowManager workflowManager;
	public static HomePageWorkflow homePageWorkflow;
	public static OpinionPageWorkflow opinionPageWorkflow;

	public void initializeWorkflowObjects(WebDriver driver) {
		homePageWorkflow = new HomePageWorkflow(driver);
		opinionPageWorkflow = new OpinionPageWorkflow(driver);
		workflowManager = new WorkflowManager();
	}

	@BeforeSuite
	public void init() {
		WebDriver driver = SeleniumWebDriverManager.getDriver(ConfigReader.get("browser"));
		initializeWorkflowObjects(driver);
		GenericUtils.clearDirectory("Screenshots");
		workflowManager.getBasePage(driver).load();
	}

	@AfterSuite
	public void cleanUp() {
		SeleniumWebDriverManager.quitDriver();
	}
}
