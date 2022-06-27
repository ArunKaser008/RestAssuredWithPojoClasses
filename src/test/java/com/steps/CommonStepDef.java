package com.steps;

import com.Pojos.ProjectsAuthorizationPojo;
import com.configutility.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class CommonStepDef {

    public static String token;
    public static Response response;
    public ConfigFileReader configFileReader;
    private Map<Object, Object> JsonObject;


    public CommonStepDef() {
        configFileReader = new ConfigFileReader();
    }


    public String authenticateUserAndFetchBearerToken() {
        String clientId = configFileReader.getProperties().getProperty("CLIENT_ID");
        String clientSecret = configFileReader.getProperties().getProperty("CLIENT_SECRET");
        String userName = configFileReader.getProperties().getProperty("USERNAME");
        String password = configFileReader.getProperties().getProperty("PASSWORD");
        ProjectsAuthorizationPojo authorizationPojo = new ProjectsAuthorizationPojo(clientId, clientSecret, password, userName);
        RestAssured.baseURI = configFileReader.getProperties().getProperty("AUTH_URL");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body(authorizationPojo).post();
        JsonObject = response.jsonPath().getMap("tokenDetails");
        token = JsonObject.get("access_token").toString();
        return token;
    }

    /**
     * function to fetch bearer function
     */
    public String fetchBearerToken(String jsonPath, String tokenToFetch) {
        Map<String, String> JsonObject = response.jsonPath().getMap(jsonPath);
        token = JsonObject.get(tokenToFetch);
        return token;
    }

    public static String getTodayDateWithSeconds() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-" + "ss");
        String givenDate = sdf.format(date);
        return givenDate;
    }
}
