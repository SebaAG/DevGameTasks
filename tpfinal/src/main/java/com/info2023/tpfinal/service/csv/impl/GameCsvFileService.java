package com.info2023.tpfinal.service.csv.impl;

import com.info2023.tpfinal.model.csv.GameCsvRecord;
import com.info2023.tpfinal.service.csv.GameCsvService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class GameCsvFileService implements GameCsvService {

    @Override
    public List<GameCsvRecord> convertCSV(File file) throws FileNotFoundException {
        return CsvCommonFileService.convertCSV(file, GameCsvRecord.class);
    }
}
