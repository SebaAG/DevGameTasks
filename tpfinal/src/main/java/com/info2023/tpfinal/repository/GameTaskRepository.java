package com.info2023.tpfinal.repository;

import com.info2023.tpfinal.entity.Developer;
import com.info2023.tpfinal.entity.Game;
import com.info2023.tpfinal.entity.GameTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface GameTaskRepository extends CrudRepository<GameTask, UUID> {
    List<GameTask> findByDeveloper(Developer developer);
    List<GameTask> findByGame(Game game);
    List<GameTask> findByStatus(GameTask.StatusTask status);
    List<GameTask> findByDeadlineBefore(LocalDate deadline);
}
