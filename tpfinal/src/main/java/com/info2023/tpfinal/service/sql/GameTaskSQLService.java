package com.info2023.tpfinal.service.sql;

import com.info2023.tpfinal.entity.Developer;
import com.info2023.tpfinal.entity.Game;
import com.info2023.tpfinal.entity.GameTask;
import com.info2023.tpfinal.repository.DeveloperRepository;
import com.info2023.tpfinal.repository.GameRepository;
import com.info2023.tpfinal.repository.GameTaskRepository;
import com.info2023.tpfinal.service.GameTaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class GameTaskSQLService implements GameTaskService {

    private final GameTaskRepository gameTaskRepository;
    private final DeveloperRepository developerRepository;
    private final GameRepository gameRepository;

    @Override
    public GameTask assignTaskToDeveloper(UUID taskId, UUID developerId) {
        GameTask task = gameTaskRepository.findById(taskId).orElse(null);
        Developer developer = developerRepository.findById(developerId).orElse(null);

        if (task != null && developer != null) {
            task.setDeveloper(developer);
            return gameTaskRepository.save(task);
        }
        return null;
    }

    @Override
    public GameTask assignTaskToGame(UUID taskId, UUID gameId) {
        GameTask task = gameTaskRepository.findById(taskId).orElse(null);
        Game game = gameRepository.findById(gameId).orElse(null);

        if (task != null && game != null) {
            task.setGame(game);
            return gameTaskRepository.save(task);
        }
        return null;
    }

    @Override
    public List<GameTask> getTasksByDeveloper(UUID developerId) {
        Developer developer = developerRepository.findById(developerId).orElse(null);
        if (developer != null) {
            return gameTaskRepository.findByDeveloper(developer);
        }
        return null;
    }

    @Override
    public GameTask updateTaskStatus(UUID taskId, GameTask.StatusTask status) {
        GameTask task = gameTaskRepository.findById(taskId).orElse(null);
        if (task != null) {
            task.setStatus(status);
            return gameTaskRepository.save(task);
        }
        return null;
    }

    @Override
    public List<GameTask> searchTasksByStatus(GameTask.StatusTask status) {
        return gameTaskRepository.findByStatus(status);
    }

    @Override
    public List<GameTask> searchTasksByGame(UUID gameId) {
        Game game = gameRepository.findById(gameId).orElse(null);
        if (game != null) {
            return gameTaskRepository.findByGame(game);
        }
        return null;
    }

    @Override
    public List<GameTask> searchTasksPastDeadline() {
        return gameTaskRepository.findByDeadlineBefore(LocalDate.now());
    }
}