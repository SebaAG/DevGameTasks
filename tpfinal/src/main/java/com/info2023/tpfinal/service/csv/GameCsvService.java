package com.info2023.tpfinal.service.csv;

import com.info2023.tpfinal.model.csv.GameCsvRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface GameCsvService extends CsvService<GameCsvRecord> {

    List<GameCsvRecord> convertCSV(File file) throws FileNotFoundException;
}
