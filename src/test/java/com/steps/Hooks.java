package com.steps;

import com.configutility.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    public ConfigFileReader configFileReader;

    public Hooks() {
        configFileReader = new ConfigFileReader();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        scenario.log("--Starting the Execution--");


    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        try {

        } catch (Exception e) {

            e.printStackTrace();
        }


    }


    @After(order = 0)
    public void quitBrowser(Scenario scenario) {

        scenario.log("---End Of Execution---");

    }

}
