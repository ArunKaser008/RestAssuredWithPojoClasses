package com.Pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.guice.ScenarioScoped;
import lombok.Data;

@Data
@ScenarioScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
        private String name;
        private String alpha3Code;

    }
