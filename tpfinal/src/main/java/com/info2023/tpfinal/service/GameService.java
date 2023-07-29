package com.info2023.tpfinal.service;

import com.info2023.tpfinal.entity.Game;
import com.info2023.tpfinal.model.dto.DeveloperDTO;

import java.util.List;
import java.util.UUID;

public interface GameService {

    Game addGame(Game game);
    List<Game> getAllGames();
    List<Game> getGamesUnderDevelopment();
    List<Game> getFinishedGames();
    List<DeveloperDTO> getDevelopersOfGame(UUID gameId);
}
