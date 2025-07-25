package com.bs.utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericUtils {

	public static boolean isDisplayed(WebDriver driver, WebElement element) {
		boolean display = false;
		SeleniumWaits waits = new SeleniumWaits(driver);
		waits.addFluentWait(element);
		try {

			display = element.isDisplayed();
		}
		catch(Exception e) {

		}
		return display;
	}

	public static void clearDirectory(String directoryName) {
		File filePath = new File(directoryName);
		if(filePath.isDirectory() && filePath.exists()) {
			File[] files = filePath.listFiles();
			for(File file: files) {
				file.delete();
			}
		}
	}

	public static String convertListToString(List<String> list) {
		String convertedString = "";
		for(String sentence : list) {
			convertedString = sentence + " " + convertedString;
		}
		System.out.println("Converted : " + convertedString);
		return convertedString;
	}

	public static void countWords(String sentence) {
		boolean wordFound = false;
		Map<String, Integer> wordsMap = new LinkedHashMap<>();
		String[] words = sentence.replaceAll("‘’","").split(" ");
		for(String word: words) {
			wordsMap.put(word, wordsMap.getOrDefault(word, 0)+1);
		}

		for(Map.Entry<String, Integer> wr: wordsMap.entrySet()) {
			if(wr.getValue()>2) {
				System.out.println("Repeated word: " + wr.getKey() + " and repeation count " + wr.getValue()); 
				wordFound = true;
			}

		}
		if(!wordFound) {
			System.out.println("No words repeated more than twice. Printing occurence of all words for reference: ");
			for(Map.Entry<String, Integer> wr: wordsMap.entrySet()) {
				System.out.println("Word: " + wr.getKey() + " and Count " + wr.getValue()); 
			}
		}
	}
}
