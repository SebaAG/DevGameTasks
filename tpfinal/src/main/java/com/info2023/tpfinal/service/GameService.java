package com.info2023.tpfinal.service;

import com.info2023.tpfinal.model.dto.GameDTO;

import java.util.List;

public interface GameService {

    GameDTO addGame(GameDTO game);
    List<GameDTO> getAllGames();
    List<GameDTO> getGamesUnderDevelopment();
    List<GameDTO> getFinishedGames();

}
