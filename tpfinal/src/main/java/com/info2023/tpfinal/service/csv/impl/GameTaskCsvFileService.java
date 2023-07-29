package com.info2023.tpfinal.service.csv.impl;

import com.info2023.tpfinal.model.csv.GameTaskCsvRecord;
import com.info2023.tpfinal.service.csv.GameTaskCsvService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class GameTaskCsvFileService implements GameTaskCsvService {
    @Override
    public List<GameTaskCsvRecord> convertCSV(File file) throws FileNotFoundException {
        return CsvCommonFileService.convertCSV(file, GameTaskCsvRecord.class);
    }
}
