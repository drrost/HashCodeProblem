package com.rdruzhchenko;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaCalculatorTest {

    @Test
    public void calculateA() throws IOException {
        // Given
        InputData inputData = new FileReader().read("a_example.in");
        PizzaCalculator pizzaCalculator = new PizzaCalculator();

        // When
        OutputData outputData = pizzaCalculator.calculate(inputData);

        // Then
        assertEquals(3, outputData.pizzasIndexes.length);
        assertEquals(3, outputData.pizzasIndexes[0]);
        assertEquals(2, outputData.pizzasIndexes[1]);
        assertEquals(0, outputData.pizzasIndexes[2]);

        new OutputWriter().write("a_example.out", outputData);
    }

    @Test
    public void calculateB() throws IOException {
        // Given
        InputData inputData = new FileReader().read("b_small.in");
        PizzaCalculator pizzaCalculator = new PizzaCalculator();

        // When
        OutputData outputData = pizzaCalculator.calculate(inputData);

        // Then
        assertEquals(4, outputData.pizzasIndexes.length);
        assertEquals(6, outputData.pizzasIndexes[0]);
        assertEquals(5, outputData.pizzasIndexes[1]);
        assertEquals(3, outputData.pizzasIndexes[2]);
        assertEquals(1, outputData.pizzasIndexes[3]);

        new OutputWriter().write("b_small.out", outputData);
    }

    @Test
    public void calculateC() throws IOException {
        InputData inputData = new FileReader().read("c_medium.in");
        PizzaCalculator pizzaCalculator = new PizzaCalculator();

        // When
        OutputData outputData = pizzaCalculator.calculate(inputData);

        // Then
        assertEquals(47, outputData.pizzasIndexes.length);
        assertEquals(48, outputData.pizzasIndexes[0]);
        assertEquals(47, outputData.pizzasIndexes[1]);
        assertEquals(46, outputData.pizzasIndexes[2]);
        assertEquals(0, outputData.pizzasIndexes[46]);

        int sum = 0;
        for (int i = 0, n = outputData.pizzasIndexes.length; i < n; i++) {
            sum += inputData.slices[outputData.pizzasIndexes[i]];
        }

        System.out.println(sum);

        assertEquals(inputData.maxSlices, sum);

        new OutputWriter().write("c_medium.out", outputData);
    }

    @Test
    public void calculateD() throws FileNotFoundException {

        InputData inputData = new FileReader().read("d_quite_big.in");
        PizzaCalculator pizzaCalculator = new PizzaCalculator();

        // When
        OutputData outputData = pizzaCalculator.calculate(inputData);
    }
}