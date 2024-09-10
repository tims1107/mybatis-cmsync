package com.developerinc.mybatiscmsync.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class FileUtils {

    public static <T> T processGeneric(Class<T> clazz, String csvFile, String... columns) {
        return Optional.ofNullable(csvFile)
                .map(file -> readCsv(file, clazz, columns))
                .orElse(null);
    }

private static <T> T readCsv(String csvFile, Class<T> clazz, String... columns) {


    try (FileReader fileReader = new FileReader(csvFile)) {
        return new CsvToBeanBuilder<T>(fileReader)
                .withType(clazz)
                .withSkipLines(1)

                .build()
                .parse()
                .stream()
                .findFirst()
                .orElse(null);
    } catch (IOException e) {
        System.err.println("Error processing CSV file: " + e.getMessage());
        return null;
    }
}






}