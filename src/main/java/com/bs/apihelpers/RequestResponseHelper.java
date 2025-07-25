package com.bs.apihelpers;

import com.bs.constants.IUrlConstants;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.response.Response;

public class RequestResponseHelper {

	public Response translate(PayloadGeneration payload, String apiKey) {
		return given()
				.baseUri(IUrlConstants.API_URL)
				.basePath("/t")
				.header("Content-Type", "application/json")
				.header("x-rapidapi-host", "rapid-translate-multi-traduction.p.rapidapi.com")
				.header("x-rapidapi-key", apiKey)
				.body(payload)
				.when()
				.post();
	}

	public void checkStatus(Response response, int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

}
