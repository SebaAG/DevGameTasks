package com.info2023.tpfinal.service;

import com.info2023.tpfinal.entity.GameTask;

import java.util.List;
import java.util.UUID;

public interface GameTaskService {

    GameTask assignTaskToDeveloper(UUID taskId, UUID developerId);
    GameTask assignTaskToGame(UUID taskId, UUID gameId);
    List<GameTask> getTasksByDeveloper(UUID developerId);
    GameTask updateTaskStatus(UUID taskId, GameTask.StatusTask status);
    List<GameTask> searchTasksByStatus(GameTask.StatusTask status);
    List<GameTask> searchTasksByGame(UUID gameId);
    List<GameTask> searchTasksPastDeadline();

}
