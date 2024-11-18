package com.epam.aicode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private static final String FILE_PATH = "logs.txt"; // Enter the path of your CSV file here

    private static final String SEPARATOR = " "; // Enter the separator used in your CSV file here

    public static void main(String[] args) {
        List<DataPoint> data = readCsv();
        System.out.println("Rows read: " + data.size());

        // Example of using the lat and lon attributes
        for (DataPoint point : data) {
            System.out.println("Latitude: " + point.getLat() + ", Longitude: " + point.getLon());
        }
    }

    public static List<DataPoint> readCsv() {
        List<DataPoint> data = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(SEPARATOR);
                DataPoint point = new DataPoint(values[0],
                        Double.parseDouble(values[1]),
                        Double.parseDouble(values[2]),
                        Double.parseDouble(values[3]),
                        Double.parseDouble(values[4]),
                        Double.parseDouble(values[5]),
                        Double.parseDouble(values[6]),
                        values[7],
                        values[8],
                        Double.parseDouble(values[9]));
                data.add(point);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public static class DataPoint {

        private final String file;
        private final double lat;
        private final double lon;
        private final double altBaro;
        private final double roll;
        private final double pitch;
        private final double yaw;
        private final String date;
        private final String time;
        private final double altGPS;

        public DataPoint(String file, double lat, double lon, double altBaro, double roll, double pitch, double yaw, String date, String time, double altGPS) {
            this.file = file;
            this.lat = lat;
            this.lon = lon;
            this.altBaro = altBaro;
            this.roll = roll;
            this.pitch = pitch;
            this.yaw = yaw;
            this.date = date;
            this.time = time;
            this.altGPS = altGPS;
        }

        public double getLat() {
            return lat;
        }

        public double getLon() {
            return lon;
        }
    }
}