package com.info2023.tpfinal.model.dto;

import com.info2023.tpfinal.entity.Developer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperDTO {

    private UUID uuid;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;

    @NotEmpty
    @Email(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    private String email;

    @NotNull
    private Developer.Role role;

}
