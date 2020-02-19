package com.rdruzhchenko;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaCalculatorTest {

    @Test
    public void calculateA() throws FileNotFoundException {
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
    }

    @Test
    public void calculateB() throws FileNotFoundException {
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
    }

    @Test
    public void calculateC() throws FileNotFoundException {
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
    }

    @Test
    public void calculateD() throws FileNotFoundException {

        InputData inputData = new FileReader().read("d_quite_big.in");
        PizzaCalculator pizzaCalculator = new PizzaCalculator();

        // When
        OutputData outputData = pizzaCalculator.calculate(inputData);
    }
}