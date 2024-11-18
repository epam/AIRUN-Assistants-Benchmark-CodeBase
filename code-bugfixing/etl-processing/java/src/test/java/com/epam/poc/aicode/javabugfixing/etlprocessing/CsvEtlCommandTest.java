package com.epam.poc.aicode.javabugfixing.etlprocessing;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvEtlCommandTest {

    @Test
    void testExecute() throws IOException {
        var tempDir = Files.createTempDirectory("tmpDir");
        var inputFile = Files.createTempFile(tempDir, "source", ".csv");
        var outputFile = Files.createTempFile("target", ".csv");

        Files.write(inputFile, "col2,col1\n" .getBytes());

        CsvEtlCommand command = new CsvEtlCommand(new String(Files.readAllBytes(inputFile)), outputFile.toString());
        command.execute();

        var outputData = new String(Files.readAllBytes(outputFile));
        assertEquals("col1,col2\n", outputData);

        Files.deleteIfExists(inputFile);
        Files.deleteIfExists(outputFile);
        Files.deleteIfExists(tempDir);
    }
}
