package com.info2023.tpfinal.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.info2023.tpfinal.entity.Developer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
public class DeveloperDTO {

    @JsonIgnore
    private UUID uuid;
    private String name;
    private String email;
    private Developer.Role role;

    // Constructor sin UUID
    public DeveloperDTO(String name, String email, Developer.Role role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }
}
