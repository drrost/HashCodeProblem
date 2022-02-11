package com.rdruzhchenko.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public InputData read(String fileName) throws FileNotFoundException {
        Scanner scanner = scanner(fileName);
        InputData inputData = new InputData();
        int clients = scanner.nextInt();

        for (int i = 0; i < clients; i++) {
            Preferences preferences = nextPreferences(scanner);
            inputData.preferences.add(preferences);
        }

        return inputData;
    }

    private Scanner scanner(String fileName) throws FileNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return new Scanner(file);
    }

    private Preferences nextPreferences(Scanner scanner) {
        Preferences preferences = new Preferences();
        preferences.liked = nextArray(scanner);
        preferences.disliked = nextArray(scanner);
        return preferences;
    }

    private List<String> nextArray(Scanner scanner) {
        int n = scanner.nextInt();
        List<String> list = new ArrayList<>(n);
        for (int j = 0; j < n; j++) {
            String s = scanner.next();
            list.add(s);
        }
        return list;
    }
}
