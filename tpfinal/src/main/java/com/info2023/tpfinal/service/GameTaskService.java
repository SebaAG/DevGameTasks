package com.info2023.tpfinal.service;

import com.info2023.tpfinal.entity.GameTask;
import com.info2023.tpfinal.model.dto.GameTaskDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface GameTaskService {

    List<GameTaskDTO> getAllGamesTask();
    GameTask assignTaskToDeveloper(UUID taskId, UUID developerId, String taskDescription, LocalDate taskDeadline);
    GameTask assignTaskToGame(UUID taskId, UUID gameId);
    List<GameTask> getTasksByDeveloper(UUID developerId);
    GameTask updateTaskStatus(UUID taskId, GameTask.StatusTask status);
    List<GameTask> searchTasksByStatus(GameTask.StatusTask status);
    List<GameTask> searchTasksByGame(UUID gameId);
    List<GameTask> searchTasksPastDeadline();

}
