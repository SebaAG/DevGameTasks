package com.info2023.tpfinal.service.sql;

import com.info2023.tpfinal.entity.Developer;
import com.info2023.tpfinal.entity.Game;
import com.info2023.tpfinal.model.dto.DeveloperDTO;
import com.info2023.tpfinal.repository.GameRepository;
import com.info2023.tpfinal.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class GameSQLService implements GameService {

    private final GameRepository gameRepository;

    @Override
    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public List<Game> getAllGames() {
        return (List<Game>) gameRepository.findAll();
    }

    @Override
    public List<Game> getGamesUnderDevelopment() {
        return gameRepository.findByReleaseDateAfter(LocalDate.now());
    }

    @Override
    public List<Game> getFinishedGames() {
        return gameRepository.findByReleaseDateBefore(LocalDate.now());
    }

    @Override
    public List<DeveloperDTO> getDevelopersOfGame(UUID gameId) {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            List<DeveloperDTO> developerDTOs = new ArrayList<>();

            for (Developer developer : game.getDevelopers()) {
                DeveloperDTO developerDTO = new DeveloperDTO(
                        developer.getName(),
                        developer.getEmail(),
                        developer.getRole());
                developerDTOs.add(developerDTO);
            }

            return developerDTOs;
        }
        return Collections.emptyList(); // Devuelve una lista vacía en lugar de null
    }
}
