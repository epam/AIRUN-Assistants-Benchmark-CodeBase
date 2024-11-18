package com.epam.aicode.java;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class DataTransformer {

    private final ObjectMapper objectMapper;

    public DataTransformer() {
        this.objectMapper = new ObjectMapper();
    }

    public String transformCsvToJson(String csvData) throws IOException {
        if (csvData == null || csvData.isEmpty()) {
            return null;
        }

        String[] lines = csvData.split("\n");
        if (lines.length < 2) {
            return null;
        }

        String[] headers = lines[0].split(",");
        List<Map<String, String>> dataList = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String[] values = lines[i].split(",");
            if (values.length != headers.length) {
                throw new IllegalArgumentException("CSV data is malformed at line " + (i + 1));
            }

            Map<String, String> dataMap = new LinkedHashMap<>();
            for (int j = 0; j < headers.length; j++) {
                dataMap.put(headers[j], values[j]);
            }
            dataList.add(dataMap);
        }

        return objectMapper.writeValueAsString(dataList);
    }
}