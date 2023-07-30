package com.info2023.tpfinal.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class GameDTO {

    private UUID uuid;
    private String title;
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate releaseDate;
}
