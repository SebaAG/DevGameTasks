package com.info2023.tpfinal.repository;

import com.info2023.tpfinal.entity.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface GameRepository extends CrudRepository<Game, UUID> {
    List<Game> findByReleaseDateAfter(LocalDate releaseDate);

    List<Game> findByReleaseDateBefore(LocalDate releaseDate);

    Optional<Game> findById(UUID uuid);

}
