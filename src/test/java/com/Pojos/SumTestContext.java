package com.Pojos;

import io.cucumber.guice.ScenarioScoped;
import lombok.Data;

@Data
@ScenarioScoped
public class SumTestContext {

    private int a;
    private int b;
    private int Sum;
}
