package com.info2023.tpfinal.service.sql;

import com.info2023.tpfinal.entity.Game;
import com.info2023.tpfinal.model.dto.GameDTO;
import com.info2023.tpfinal.repository.GameRepository;
import com.info2023.tpfinal.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GameSQLService implements GameService {

    private final GameRepository gameRepository;

    @Override
    public GameDTO addGame(GameDTO gameDto) {
        Game game = toEntity(gameDto);
        Game savedGame = gameRepository.save(game);
        return toDTO(savedGame);
    }

    public List<GameDTO> getAllGames() {
        List<Game> games = (List<Game>) gameRepository.findAll();
        return toDTOList(games);
    }

    @Override
    public List<GameDTO> getGamesUnderDevelopment() {
        List<Game> games = gameRepository.findByReleaseDateAfter(LocalDate.now());
        return toDTOList(games);
    }

    @Override
    public List<GameDTO> getFinishedGames() {
        List<Game> games = gameRepository.findByReleaseDateBefore(LocalDate.now());
        return toDTOList(games);
    }

    private List<GameDTO> toDTOList(List<Game> games) {
        List<GameDTO> gameDTOs = new ArrayList<>();
        for (Game game : games) {
            GameDTO gameDTO = new GameDTO();
            gameDTO.setUuid(game.getUuid());
            gameDTO.setTitle(game.getTitle());
            gameDTO.setDescription(game.getDescription());
            gameDTO.setReleaseDate(game.getReleaseDate());
            gameDTOs.add(gameDTO);
        }
        return gameDTOs;
    }

    private Game toEntity(GameDTO gameDto) {
        return Game.builder()
                .title(gameDto.getTitle())
                .description(gameDto.getDescription())
                .releaseDate(gameDto.getReleaseDate())
                .build();
    }

    private GameDTO toDTO(Game game) {
        return new GameDTO(game.getUuid(),
                game.getTitle(),
                game.getDescription(),
                game.getReleaseDate());
    }

}
