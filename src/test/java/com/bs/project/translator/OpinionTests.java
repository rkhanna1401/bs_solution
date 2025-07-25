package com.bs.project.translator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;

import com.bs.apihelpers.PayloadGeneration;
import com.bs.apihelpers.RequestResponseHelper;
import com.bs.manager.TestManager;
import com.bs.utilities.DocumentCreator;
import com.bs.utilities.EnvReader;
import com.bs.utilities.GenericUtils;

import io.restassured.response.Response;

public class OpinionTests extends TestManager {

	private List<String> titles;
	String englishTitle;
	List<String> convertedTitles = new ArrayList<String>();

	@Test
	public void retrieveTitles() {
		homePageWorkflow.selectOpinionTab();
		titles = opinionPageWorkflow.readTitles();
		Map<String, String> article = opinionPageWorkflow.readNewsArticle();
		DocumentCreator.writeToFile(article, "Articles_In_Spanish.txt");
		opinionPageWorkflow.downloadImage();
	}

	@Test(dependsOnMethods = {"retrieveTitles"})
	public void convertTitlesIntoEnglish() {
		String apiKey = EnvReader.readEnv("RAPID_API_KEY");
		RequestResponseHelper requestResponseHelper = new RequestResponseHelper();
		PayloadGeneration payload;
		Response response;


		for(String title : titles) {
			payload = new PayloadGeneration("es", "en", title);
			response = requestResponseHelper.translate(payload, apiKey);
			requestResponseHelper.checkStatus(response, 200);
			System.out.println("Response: " + response.asPrettyString());
			convertedTitles.add(response.jsonPath().getString("[0]"));
		}
		DocumentCreator.writeToFile(convertedTitles, "Titles_In_English.txt");
	}

	@Test(dependsOnMethods = "convertTitlesIntoEnglish")
	public void countWords() {
		String sentence = GenericUtils.convertListToString(convertedTitles);
		GenericUtils.countWords(sentence);
	}
}
