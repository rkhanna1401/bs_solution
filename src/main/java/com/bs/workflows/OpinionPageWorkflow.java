package com.bs.workflows;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.bs.manager.WorkflowManager;
import com.bs.utilities.GenericUtils;
import com.bs.utilities.ScreenshotReader;

public class OpinionPageWorkflow {

	private WebDriver driver;
	private WorkflowManager workflowManager;

	public OpinionPageWorkflow(WebDriver driver) {
		this.driver = driver;
		workflowManager = new WorkflowManager();
	}

	public List<String> readTitles(){
		return workflowManager.getOpinionPage(driver).getNewsTitles().stream()
				.limit(5).map(WebElement::getText).collect(Collectors.toList());
	}

	public  Map<String, String> readNewsArticle() {
		List<String> heading = readTitles();
		System.out.println("News Title: " + heading);
		List<String> content = workflowManager.getOpinionPage(driver).getNewsContent().stream()
				.limit(5).map(WebElement::getText).collect(Collectors.toList());
		System.out.println("News Content:" + content);
		Map<String, String> news = new LinkedHashMap<String, String>();
		for(int i = 0; i < heading.size(); i++) {
			news.put(heading.get(i), content.get(i));
		}
		return news;
	}

	public void downloadImage() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		driver.navigate().refresh();
		if(GenericUtils.isDisplayed(driver,workflowManager.getOpinionPage(driver).getArticleImage().get(0))) {
			List<WebElement> images = workflowManager.getOpinionPage(driver).getArticleImage();
			List<String> imageUrls = new ArrayList<String>();
			for(WebElement image : images) {
				imageUrls.add(image.getAttribute("src"));
			}

			for(int i =0 ; i< imageUrls.size(); i++) {
				driver.navigate().to(imageUrls.get(i));
				String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				ScreenshotReader.takeScreenshot(driver, "Image_" + (i+1)+"-"+ timestamp);
			}
		}
		else {
			System.out.println("No Image present on 1st 5 articles.");
		}

	}
}
