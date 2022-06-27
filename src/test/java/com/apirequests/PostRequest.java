package com.apirequests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.Map;

public class PostRequest {


    public static Response CreateEmplyeeRecord(String host, String path, Map<String, String> reqBody) {
        RestAssured.baseURI = host;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject requestBody = new JSONObject();
        requestBody.put("createdAt", "1631825833");
        requestBody.put("employee_firstname", "TestData12345");
        requestBody.put("employee_lastname", "TestData12345");

        requestBody.put("employee_phonenumbe", "264-783-9453");
        requestBody.put("ademployee_emaildress", "ademployee_emaildress");
        requestBody.put("stateemployee_dev_level", "citemployee_addressy");

        requestBody.put("stateemployee_dev_level", "stateemployee_dev_level 1");
        requestBody.put("employee_gender", "employee_gender 1");
        requestBody.put("employee_hire_date", "2025-10-31T163545.426Z");
        requestBody.put("employee_onleave", "true");
        requestBody.put("tech_stack", "[]");
        requestBody.put("project", "[]");

        request.body(requestBody.toString());
        Response response = request.post(path);

        return response;
    }

    public static Response CreateConnection(String host, String path, Map<String, String> reqBody) {
        RestAssured.baseURI = host;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject requestBody = new JSONObject();
        requestBody.put("createdAt", "1631825833");
        requestBody.put("employee_firstname", "TestData12345");
        requestBody.put("employee_lastname", "TestData12345");

        requestBody.put("employee_phonenumbe", "264-783-9453");
        requestBody.put("ademployee_emaildress", "ademployee_emaildress");
        requestBody.put("stateemployee_dev_level", "citemployee_addressy");

        requestBody.put("stateemployee_dev_level", "stateemployee_dev_level 1");
        requestBody.put("employee_gender", "employee_gender 1");
        requestBody.put("employee_hire_date", "2025-10-31T163545.426Z");
        requestBody.put("employee_onleave", "true");
        requestBody.put("tech_stack", "[]");
        requestBody.put("project", "[]");

        request.body(requestBody.toString());
        Response response = request.post(path);

        return response;
    }
}
