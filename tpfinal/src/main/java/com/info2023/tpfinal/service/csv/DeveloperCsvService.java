package com.info2023.tpfinal.service.csv;

import com.info2023.tpfinal.model.csv.DeveloperCsvRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface DeveloperCsvService extends CsvService<DeveloperCsvRecord> {

    List<DeveloperCsvRecord> convertCSV(File file) throws FileNotFoundException;
}
