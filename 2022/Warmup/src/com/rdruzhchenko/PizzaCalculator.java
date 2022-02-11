package com.rdruzhchenko;

import com.rdruzhchenko.input.InputData;
import com.rdruzhchenko.output.OutputData;

public class PizzaCalculator {

    public OutputData calculate(InputData inputData) {
        OutputData outputData = new OutputData();

        outputData.ingredients.add("cheese");
        outputData.ingredients.add("mushrooms");
        outputData.ingredients.add("tomatoes");
        outputData.ingredients.add("peppers");

        return outputData;
    }
}
