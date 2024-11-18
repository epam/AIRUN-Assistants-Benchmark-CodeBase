package com.epam.poc.aicode.javabugfixing.etlprocessing;

import java.io.*;

public class CsvEtlCommand {
    private String sourceFile;
    private String targetFile;

    public CsvEtlCommand(String sourceFile, String targetFile) {
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
    }

    public void execute() throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(sourceFile));
            writer = new BufferedWriter(new FileWriter(targetFile));

            // Extract
            String line = reader.readLine();

            // Transform and Load
            while (line != null) {
                String[] columns = line.split(",");
                var transformedLine = transform(columns);

                writer.write(transformedLine + "\n");
                line = reader.readLine();
            }
        } finally {
            if (reader != null) reader.close();
            if (writer != null) writer.close();
        }
    }


    private String transform(String[] columns) {
        // Add a simple transformation: reverse the order of the columns
        String transformed = "";
        for (int i = columns.length - 1; i >= 0; i--) {
            transformed += columns[i];
            if (i > 0) transformed += ",";
        }
        return transformed;
    }
}
