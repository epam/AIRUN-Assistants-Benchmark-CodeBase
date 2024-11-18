package com.epam.aicode.java;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileProcessor {

    public String processCsvToJson(String csvFile) {
        Map<String, String> data = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                data.put(line[0], line[1]);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Error while processing csv file", e);
        }
        return new Gson().toJson(data);
    }
}

