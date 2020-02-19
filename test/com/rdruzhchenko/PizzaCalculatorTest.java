package com.rdruzhchenko;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PizzaCalculatorTest {

    @Test
    public void calculateA() {
        // Given
        InputData inputData = new InputData();
        inputData.maxSlices = 17;
        inputData.slices = new Integer[] { 2, 5, 6, 8 };
        PizzaCalculator pizzaCalculator = new PizzaCalculator();

        // When
        OutputData outputData = pizzaCalculator.calculate(inputData);

        // Then
        assertEquals(3, outputData.pizzasIndexes.length);
        assertEquals(0, outputData.pizzasIndexes[0]);
        assertEquals(2, outputData.pizzasIndexes[1]);
        assertEquals(3, outputData.pizzasIndexes[2]);
    }

    @Test
    public void calculateB() {
        // Given
        InputData inputData = new InputData();
        inputData.maxSlices = 100;
        inputData.slices = new Integer[] { 4, 14, 15, 18, 29, 32, 36, 82, 95, 95 };
        PizzaCalculator pizzaCalculator = new PizzaCalculator();

        // When
        OutputData outputData = pizzaCalculator.calculate(inputData);

        // Then
        assertEquals(2, outputData.pizzasIndexes.length);
        assertEquals(18, outputData.pizzasIndexes[0]);
        assertEquals(82, outputData.pizzasIndexes[1]);
    }

    @Test
    public void calculateC() {
        InputData inputData = new InputData();
        inputData.maxSlices = 4500;
        inputData.slices = new Integer[] { 7, 12, 12, 13, 14, 28, 29, 29, 30, 32, 32, 34, 41, 45, 46, 56,
                61, 61, 62, 63, 65, 68, 76, 77, 77, 92, 93, 94, 97, 103, 113, 114, 114, 120, 135, 145, 145, 149,
                156, 157, 160, 169, 172, 179, 184, 185, 189, 194, 195, 195};
        PizzaCalculator pizzaCalculator = new PizzaCalculator();

        // When
        OutputData outputData = pizzaCalculator.calculate(inputData);

    }

    @Test
    public void calculateD() {
        InputData inputData = new InputData();
        try {

            ClassLoader classLoader = ClassLoader.getSystemClassLoader();

            File file = new File(classLoader.getResource("e_also_big.text").getFile());

            Scanner scanner = new Scanner(file);

            inputData.maxSlices = scanner.nextInt();
            inputData.slices = new Integer[scanner.nextInt()];
            int i = 0;
            while (scanner.hasNextInt()) {
                inputData.slices[i++] = scanner.nextInt();
            }
            System.out.println(inputData.slices.length);

            PizzaCalculator pizzaCalculator = new PizzaCalculator();

            // When
            OutputData outputData = pizzaCalculator.calculate(inputData);
        } catch (Exception ex)  { }

    }
}