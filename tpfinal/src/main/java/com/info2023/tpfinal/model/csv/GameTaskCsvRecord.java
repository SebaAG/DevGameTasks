package com.info2023.tpfinal.model.csv;

import com.info2023.tpfinal.entity.GameTask;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameTaskCsvRecord {

    @CsvBindByName(column = "description")
    private String description;

    @CsvBindByName(column = "deadline")
    private String deadline;

    @CsvBindByName(column = "status")
    private GameTask.StatusTask status;
}
