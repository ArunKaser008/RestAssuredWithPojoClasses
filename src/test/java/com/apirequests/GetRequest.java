package com.apirequests;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest {

    public static Response getCountries(String host, String path, Map<String,String> header){

       return given().baseUri(host).basePath(path).headers(header).get().then().extract().response();
    }

    public static Response getEmployee(String host, String path){

        return given().baseUri(host).basePath(path).get().then().extract().response();
    }



}
