package com.info2023.tpfinal.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class GameDTO {

    private UUID uuid;

    @NotNull
    @Size(min = 1, max = 64)
    private String title;

    @NotNull
    @Size(min = 1, max = 155)
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate releaseDate;
}
