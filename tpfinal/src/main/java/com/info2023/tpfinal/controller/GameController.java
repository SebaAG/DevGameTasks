package com.info2023.tpfinal.controller;

import com.info2023.tpfinal.entity.Game;
import com.info2023.tpfinal.model.dto.DeveloperDTO;
import com.info2023.tpfinal.model.dto.GameDTO;
import com.info2023.tpfinal.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tpf/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        Game newGame = gameService.addGame(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(newGame);
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> getAllGames() {
        List<Game> games = gameService.getAllGames();
        List<GameDTO> gameDTOs = new ArrayList<>();

        for (Game game : games) {
            GameDTO gameDTO = new GameDTO();
            gameDTO.setUuid(game.getUuid());
            gameDTO.setTitle(game.getTitle());
            gameDTO.setDescription(game.getDescription());
            gameDTO.setReleaseDate(game.getReleaseDate());
            gameDTOs.add(gameDTO);
        }

        return ResponseEntity.ok(gameDTOs);
    }

    @GetMapping("/under-development")
    public ResponseEntity<List<GameDTO>> getGamesUnderDevelopment() {
        List<Game> games = gameService.getGamesUnderDevelopment();
        List<GameDTO> gameDTOs = new ArrayList<>();

        for (Game game : games) {
            GameDTO gameDTO = new GameDTO();
            gameDTO.setUuid(game.getUuid());
            gameDTO.setTitle(game.getTitle());
            gameDTO.setDescription(game.getDescription());
            gameDTO.setReleaseDate(game.getReleaseDate());
            gameDTOs.add(gameDTO);
        }

        return ResponseEntity.ok(gameDTOs);
    }

    @GetMapping("/finished")
    public ResponseEntity<List<GameDTO>> getFinishedGames() {
        List<Game> games = gameService.getFinishedGames();
        List<GameDTO> gameDTOs = new ArrayList<>();

        for (Game game : games) {
            if (game.getReleaseDate().isBefore(LocalDate.now())) {
                GameDTO gameDTO = new GameDTO();
                gameDTO.setUuid(game.getUuid());
                gameDTO.setTitle(game.getTitle());
                gameDTO.setDescription(game.getDescription());
                gameDTO.setReleaseDate(game.getReleaseDate());
                gameDTOs.add(gameDTO);
            }
        }

        return ResponseEntity.ok(gameDTOs);
    }


    @GetMapping("/{gameId}/developers")
    public ResponseEntity<List<DeveloperDTO>> getDevelopersOfGame(@PathVariable UUID gameId) {
        List<DeveloperDTO> developers = gameService.getDevelopersOfGame(gameId);
        if (developers != null && !developers.isEmpty()) {
            return ResponseEntity.ok(developers);
        }
        return ResponseEntity.notFound().build();
    }
}
