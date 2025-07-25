package com.bs.utilities;

import org.openqa.selenium.*;

import com.bs.constants.IGenericConstants;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class ScreenshotReader {


	public static void takeScreenshot(WebDriver driver, String testName) {
		try {

			String fileName = IGenericConstants.SCREENSHOT_DIR + testName + ".png";
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(screenshot.toPath(), Paths.get(fileName));

		} catch (IOException e) {
			System.err.println("Failed to save the screenshot: " + e.getMessage());
		}
	}

}
