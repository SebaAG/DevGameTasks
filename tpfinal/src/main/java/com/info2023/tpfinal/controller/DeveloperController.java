package com.info2023.tpfinal.controller;

import com.info2023.tpfinal.entity.Developer;
import com.info2023.tpfinal.model.dto.DeveloperDTO;
import com.info2023.tpfinal.service.DeveloperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tpf/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PostMapping
    public ResponseEntity<Developer> addDeveloper(@RequestBody Developer developer) {
        Developer newDeveloper = developerService.addDeveloper(developer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDeveloper);
    }

    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> getAllDevelopers() {
        List<DeveloperDTO> developers = developerService.getAllDevelopers();
        return ResponseEntity.ok(developers);
    }

    @PostMapping("/{developerId}/assign-to-game/{gameId}")
    public ResponseEntity<Developer> assignDeveloperToGame(@PathVariable UUID developerId, @PathVariable UUID gameId) {
        Developer assignedDeveloper = developerService.assignDeveloperToGame(developerId, gameId);
        if (assignedDeveloper != null) {
            return ResponseEntity.ok(assignedDeveloper);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{gameId}/game")
    public ResponseEntity<List<DeveloperDTO>> getDeveloperByGameId(@PathVariable UUID gameId) {
        List<DeveloperDTO> developers = developerService.getDevelopersByGameId(gameId);
        if (!developers.isEmpty()) {
            return ResponseEntity.ok(developers);
        }
        return ResponseEntity.notFound().build();
    }

}
