package com.Pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.response.Response;
import lombok.Data;

import java.util.Map;

@Data
@ScenarioScoped
public class GetEmployeeTestContext {
    private Map<String, String> reqBody ;
    private Response httpResponse;
    private Employee[] employee;

    public Employee[] GetEmployee() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            employee = mapper.readValue(getHttpResponse().getBody().asString(), Employee[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
