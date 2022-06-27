package com.Pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.response.Response;
import lombok.Data;

import java.util.Map;

@Data
@ScenarioScoped
public class GetCountriesTestContext {
    private Map<String, String> headers;
    private Response httpResponse;
    private Country[] countries;

    public Country[] getCountries() {

        ObjectMapper mapper = new ObjectMapper();
        try {
            countries = mapper.readValue(getHttpResponse().getBody().asString(), Country[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
