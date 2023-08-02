package com.info2023.tpfinal.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.info2023.tpfinal.entity.GameTask;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    private UUID uuid;

    @NotNull
    @Size(min = 2, max = 155)
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate deadline;

    @NotNull
    private GameTask.StatusTask status;
}
