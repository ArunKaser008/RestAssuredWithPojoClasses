package com.Pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.guice.ScenarioScoped;
import lombok.Data;

@Data
@ScenarioScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
        private String employee_firstname;
        private String employee_lastname;

    }
