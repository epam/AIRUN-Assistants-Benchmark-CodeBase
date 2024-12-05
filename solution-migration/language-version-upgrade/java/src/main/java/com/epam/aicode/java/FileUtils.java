package com.epam.aicode.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    /**
     * Find all executable files in the given directory recursively
     *
     * @param directory
     * @return
     */
    public static final List<File> findExecutableFiles(File directory) {
        List<File> files = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile() && file.canExecute()) {
                files.add(file);
            } else {
                if (file.isDirectory()) {
                    files.addAll(findExecutableFiles(file));
                }
            }
        }
        return files;
    }
}
