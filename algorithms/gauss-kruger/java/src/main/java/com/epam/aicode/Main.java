package com.epam.aicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.epam.aicode.CsvReader.readCsv;
import static com.epam.aicode.GaussKrugerEvaluator.toGaussKruger;

public class Main {

    public static void main(String[] args) {
        List<CsvReader.DataPoint> data = readCsv();

        List<Double[]> xyValues = new ArrayList<>();
        for (CsvReader.DataPoint tuple : data) {
            double[] xy = toGaussKruger(tuple.getLat(), tuple.getLon());
            Double[] arr = Arrays.stream(xy).boxed().toArray(Double[]::new);
            xyValues.add(arr);
        }

        List<Double> totalDistances = new ArrayList<>();
        for (int i = 0; i < xyValues.size() - 1; i++) {
            Double[] coord1 = xyValues.get(i);
            Double[] coord2 = xyValues.get(i + 1);

            Double distance = Math.sqrt(Math.pow(coord1[0] - coord2[0], 2) + Math.pow(coord1[1] - coord2[1], 2));
            totalDistances.add(distance);
        }
        double mean = totalDistances.stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN);

        System.out.println(mean);
    }
}
