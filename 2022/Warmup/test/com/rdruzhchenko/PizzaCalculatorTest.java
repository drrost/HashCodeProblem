package com.rdruzhchenko;

import com.rdruzhchenko.input.FileReader;
import com.rdruzhchenko.input.InputData;
import com.rdruzhchenko.output.OutputData;
import com.rdruzhchenko.output.OutputWriter;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaCalculatorTest {

    @Test
    public void calculateA() throws IOException {
        // Given
        InputData inputData = new FileReader().read("a_an_example.in.txt");
        PizzaCalculator pizzaCalculator = new PizzaCalculator();

        // When
        OutputData outputData = pizzaCalculator.calculate(inputData);

        // Then
        new OutputWriter().write("a_an_example.out.txt", outputData);
        assertEquals(4, outputData.ingredients.size());
        assert(outputData.ingredients.contains("peppers"));
        assert(outputData.ingredients.contains("cheese"));
        assert(outputData.ingredients.contains("mushrooms"));
        assert(outputData.ingredients.contains("tomatoes"));
    }

    @Test
    public void calculateB() throws IOException {
        // Given
        InputData inputData = new FileReader().read("b_basic.in.txt");
        PizzaCalculator pizzaCalculator = new PizzaCalculator();

        // When
        OutputData outputData = pizzaCalculator.calculate(inputData);

        // Then
        new OutputWriter().write("a_an_example.out.txt", outputData);
        assertEquals(4, outputData.ingredients.size());
        assert(outputData.ingredients.contains("peppers"));
        assert(outputData.ingredients.contains("cheese"));
        assert(outputData.ingredients.contains("mushrooms"));
        assert(outputData.ingredients.contains("tomatoes"));
    }
}
