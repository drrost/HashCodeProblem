package com.rdruzhchenko.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {

    public void write(String fileName, OutputData outputData) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        int length = outputData.ingredients.size();
        writer.write(length + " ");

        for (int i = 0; i < length; i++) {
            writer.write(outputData.ingredients.get(i).toString());
            if (i != length - 1) {
                writer.write(" ");
            }
        }

        writer.close();
    }
}
