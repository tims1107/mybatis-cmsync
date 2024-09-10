package com.developerinc.mybatiscmsync.service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Collections;
import java.util.List;

public final class CsvService {

    private CsvService() {}

    public static <T> List<T> readCsv(String csvFilePath, Class<T> clazz) {
        try (Reader reader = new FileReader(csvFilePath)) {
            CsvToBeanBuilder<T> builder = new CsvToBeanBuilder<>(reader);
            return builder.withType(clazz).build().parse();
        } catch (Exception e) {
            // Handle exception
        }
        return Collections.emptyList();
    }

    public static <T> void writeCsv(String csvFilePath, List<T> objects, Class<T> clazz) {
        try (Writer writer = new FileWriter(csvFilePath)) {
            StatefulBeanToCsvBuilder<T> builder = new StatefulBeanToCsvBuilder<>(writer);
            builder.build().write(objects);
        } catch (Exception e) {
            // Handle exception
        }
    }
}
