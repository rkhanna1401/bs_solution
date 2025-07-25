package com.bs.utilities;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {
	private WebDriver driver;
	private WebDriverWait webDriverWait;
	
	
	public SeleniumWaits(WebDriver driver) {
		this.driver = driver;
		webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(25));
	}
	
	
	public void waitUntilElementIsLoadedAndVisible(WebElement element) {
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void addFluentWait(WebElement element) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
