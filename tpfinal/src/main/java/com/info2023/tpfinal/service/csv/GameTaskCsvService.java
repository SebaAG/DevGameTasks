package com.info2023.tpfinal.service.csv;

import com.info2023.tpfinal.model.csv.GameTaskCsvRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface GameTaskCsvService extends CsvService<GameTaskCsvRecord> {

    List<GameTaskCsvRecord> convertCSV(File file) throws FileNotFoundException;
}
