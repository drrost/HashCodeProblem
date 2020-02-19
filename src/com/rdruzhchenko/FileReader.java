package com.rdruzhchenko;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public InputData read(String fileName) throws FileNotFoundException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());

        Scanner scanner = new Scanner(file);

        InputData inputData = new InputData();
        inputData.maxSlices = scanner.nextInt();
        inputData.slices = new Integer[scanner.nextInt()];

        int i = 0;
        while (scanner.hasNextInt()) {
            inputData.slices[i++] = scanner.nextInt();
        }

        return inputData;
    }
}
