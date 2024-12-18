package com.epam.aicode.java;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class CsvUtils {

    /**
     * Collect CVS files in the given directory
     *
     * @param filePrefix
     * @param directory
     * @return list of file names
     */
    public static final List<String> collectCsvFiles(String filePrefix, File directory) {
        String[] names = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(filePrefix) && name.endsWith(".csv");
            }
        });

        return Arrays.asList(names);
    }

}
