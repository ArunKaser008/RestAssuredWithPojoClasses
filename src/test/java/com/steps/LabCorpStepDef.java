package com.steps;

import com.Pojos.*;
import com.apirequests.GetRequest;
import com.apirequests.PostRequest;
import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LabCorpStepDef {
    @Inject
    private SumTestContext sumtestContext;
    @Inject
    private GetEmployeeTestContext getEmployeeTestContext;
    @Inject
    private GetCountriesTestContext getCountriesTestContext;

    private static final String HOST1 = "https://restcountries-v1.p.rapidapi.com";
    private static final String PATH1 = "/all";
    private Optional<Country> optionalCountry;

    private static final String HOST = "https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1/";
    private static final String PATH = "/Users";
    private Optional<Employee> optionalEmployee;


    // LabCorp Example

    @Given("I add API Request body")
    public void iAddAPIRequestBody(DataTable dataTable) {
        Map<String, String> reqBody = dataTable.asMap(String.class, String.class);
        getEmployeeTestContext.setReqBody(reqBody);
    }

    @When("I create new employee record")
    public void iCreateNewEmployeeRecord() {
        Response response = PostRequest.CreateEmplyeeRecord(HOST, PATH, getEmployeeTestContext.getReqBody());
        getEmployeeTestContext.setHttpResponse(response);
        response.getStatusCode();
    }

    @And("I validate the created record")
    public void iValidateTheCreatedRecord() {
        assertEquals(getEmployeeTestContext.getHttpResponse().getStatusCode(), 400);
    }

    @When("I get employee details")
    public void iGetEmployeeDetails() {
        Response response = GetRequest.getEmployee(HOST, PATH);
        System.out.println("Response --> " + response.prettyPrint());
        getEmployeeTestContext.setHttpResponse(response);
    }


    @Then("I verify {string} exists in the employee table")
    public void iVerifyExistsInTheEmployeeTable(String empName) {
        List<Employee> countries = Arrays.asList(getEmployeeTestContext.GetEmployee());
        optionalEmployee = countries.stream().filter(employee -> employee.getEmployee_firstname().equals(empName)).findFirst();
        assertTrue("Employee with name " + empName + " doesnt exist in the list of countries returned by application", optionalEmployee.isPresent());
    }



    //  Sum Operation
    @Given("I have {int} and {int}")
    public void iHaveAnd(int a, int b) {
        sumtestContext.setA(a);
        sumtestContext.setB(b);

    }

    @When("I add number")
    public void iAddNumber() {
        int sum = sumtestContext.getA() + sumtestContext.getB();
        sumtestContext.setSum(sum);
    }

    @Then("I get result")
    public void iGetResult() {
        System.out.println(sumtestContext.getSum());
        Assert.assertEquals(sumtestContext.getSum(), 19);
    }

    // Demo Example
    @Given("I have API headers")
    public void iHaveAPIHeaders(DataTable dataTable) {
        Map<String, String> headers = dataTable.asMap(String.class, String.class);
        getCountriesTestContext.setHeaders(headers);

    }

    @When("I get countries")
    public void iGetCountries() {
        Response respose = GetRequest.getCountries(HOST, PATH, getCountriesTestContext.getHeaders());
        System.out.println("Response --> " + respose.prettyPrint());
        getCountriesTestContext.setHttpResponse(respose);
    }
    @Then("I verify (.*) exists in the response$")
    public void iVerifyVietnamExistsInTheResponse(String countryName) {
        List<Country> countries = Arrays.asList(getCountriesTestContext.getCountries());
        optionalCountry = countries.stream().filter(country -> country.getName().equals(countryName)).findFirst();
        assertTrue("country with name " + countryName + " doesnt exist in the list of countries returned by application", optionalCountry.isPresent());
    }


}
