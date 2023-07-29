package com.info2023.tpfinal.controller;

import com.info2023.tpfinal.entity.Game;
import com.info2023.tpfinal.model.dto.GameDTO;
import com.info2023.tpfinal.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tpf/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<GameDTO> addGame(@RequestBody GameDTO game) {
        GameDTO newGame = gameService.addGame(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(newGame);
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> getAllGames() {
        List<GameDTO> games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/under-development")
    public ResponseEntity<List<GameDTO>> getGamesUnderDevelopment() {
        List<GameDTO> games = gameService.getGamesUnderDevelopment();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/finished")
    public ResponseEntity<List<GameDTO>> getFinishedGames() {
        List<GameDTO> games = gameService.getFinishedGames();
        return ResponseEntity.ok(games);
    }


}
