package com.info2023.tpfinal.controller;

import com.info2023.tpfinal.entity.GameTask;
import com.info2023.tpfinal.service.GameTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tpf/tasks")
public class GameTaskController {

    private final GameTaskService gameTaskService;

    public GameTaskController(GameTaskService taskService) {
        this.gameTaskService = taskService;
    }


    @PostMapping("/{taskId}/assign-to-developer/{developerId}")
    public ResponseEntity<GameTask> assignTaskToDeveloper(@PathVariable UUID taskId, @PathVariable UUID developerId) {
        GameTask assignedTask = gameTaskService.assignTaskToDeveloper(taskId, developerId);
        if (assignedTask != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(assignedTask);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{taskId}/assign-to-game/{gameId}")
    public ResponseEntity<GameTask> assignTaskToGame(@PathVariable UUID taskId, @PathVariable UUID gameId) {
        GameTask assignedTask = gameTaskService.assignTaskToGame(taskId, gameId);
        if (assignedTask != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(assignedTask);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search-by-developer/{developerId}")
    public ResponseEntity<List<GameTask>> getTasksByDeveloper(@PathVariable UUID developerId) {
        List<GameTask> tasks = gameTaskService.getTasksByDeveloper(developerId);
        if (tasks != null) {
            return ResponseEntity.ok(tasks);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{taskId}/update-status")
    public ResponseEntity<GameTask> updateTaskStatus(@PathVariable UUID taskId, @RequestParam String status) {
        try {
            GameTask.StatusTask statusTask = GameTask.StatusTask.valueOf(status.toUpperCase());
            GameTask updatedTask = gameTaskService.updateTaskStatus(taskId, statusTask);
            return ResponseEntity.ok(updatedTask);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/search-by-status")
    public ResponseEntity<List<GameTask>> searchTasksByStatus(@RequestParam String status) {
        try {
            GameTask.StatusTask statusTask = GameTask.StatusTask.valueOf(status.toUpperCase());
            List<GameTask> tasks = gameTaskService.searchTasksByStatus(statusTask);
            if (!tasks.isEmpty()) {
                return ResponseEntity.ok(tasks);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/search-by-game/{gameId}")
    public ResponseEntity<List<GameTask>> searchTasksByGame(@PathVariable UUID gameId) {
        List<GameTask> tasks = gameTaskService.searchTasksByGame(gameId);
        if (tasks != null) {
            return ResponseEntity.ok(tasks);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search-past-deadline")
    public ResponseEntity<List<GameTask>> searchTasksPastDeadline() {
        List<GameTask> tasks = gameTaskService.searchTasksPastDeadline();
        return ResponseEntity.ok(tasks);
    }
}
