package com.info2023.tpfinal.repository;

import com.info2023.tpfinal.entity.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, UUID> {

    List<Developer> findAll();

    Optional<Developer> findById(UUID uuid);

    List<Developer> findByGameUuid(UUID uuid);
}
