package com.info2023.tpfinal.service.csv.impl;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvCommonFileService {

    public static <T> List<T> convertCSV(File file, Class<T> recordClass) throws FileNotFoundException {
        List<T> recordList = new CsvToBeanBuilder<T>(new FileReader(file))
                .withType(recordClass)
                .build()
                .parse();

        return recordList;
    }
}
