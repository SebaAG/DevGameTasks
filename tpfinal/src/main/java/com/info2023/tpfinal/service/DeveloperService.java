package com.info2023.tpfinal.service;

import com.info2023.tpfinal.entity.Developer;
import com.info2023.tpfinal.model.dto.DeveloperDTO;

import java.util.List;
import java.util.UUID;

public interface DeveloperService {

    Developer addDeveloper(Developer developer);
    List<DeveloperDTO> getAllDevelopers();
    Developer assignDeveloperToGame(UUID developerId, UUID gameId);

    List<DeveloperDTO> getDevelopersByGameId(UUID gameId);
}
