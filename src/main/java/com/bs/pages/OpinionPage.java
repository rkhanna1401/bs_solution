package com.bs.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpinionPage extends BasePage{

	public OpinionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//article/p/../header/h2/a")
	private List<WebElement> newsTitles;

	@FindBy(xpath = "//article/p")
	private List<WebElement> newsContent;
	
	@FindBy(xpath = "//article/p/../header/h2/a/../../..//img")
	private List<WebElement> articleImage;

	public List<WebElement> getNewsTitles() {
		return newsTitles;
	}

	public List<WebElement> getNewsContent() {
		return newsContent;
	}

	public List<WebElement> getArticleImage() {
		return articleImage;
	}

}
