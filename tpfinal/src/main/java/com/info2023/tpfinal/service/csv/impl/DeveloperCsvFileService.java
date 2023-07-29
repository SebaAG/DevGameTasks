package com.info2023.tpfinal.service.csv.impl;

import com.info2023.tpfinal.model.csv.DeveloperCsvRecord;
import com.info2023.tpfinal.service.csv.DeveloperCsvService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class DeveloperCsvFileService implements DeveloperCsvService {

    @Override
    public List<DeveloperCsvRecord> convertCSV(File file) throws FileNotFoundException {
        return CsvCommonFileService.convertCSV(file, DeveloperCsvRecord.class);
    }
}
