package com.info2023.tpfinal.model.dto;

import com.info2023.tpfinal.entity.GameTask;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameTaskDTO {

    @JsonIgnore
    private UUID uuid;

    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate deadline;


    private GameTask.StatusTask status;
}
