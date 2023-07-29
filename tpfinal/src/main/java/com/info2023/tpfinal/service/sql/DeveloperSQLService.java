package com.info2023.tpfinal.service.sql;

import com.info2023.tpfinal.entity.Developer;
import com.info2023.tpfinal.entity.Game;
import com.info2023.tpfinal.model.dto.DeveloperDTO;
import com.info2023.tpfinal.repository.DeveloperRepository;
import com.info2023.tpfinal.repository.GameRepository;
import com.info2023.tpfinal.service.DeveloperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeveloperSQLService implements DeveloperService {

    private DeveloperRepository developerRepository;
    private GameRepository gameRepository;

    @Override
    public Developer addDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public List<DeveloperDTO> getAllDevelopers() {
        List<Developer> developers = developerRepository.findAll();
        return developers.stream()
                .map(developer -> new DeveloperDTO(developer.getUuid(), developer.getName(), developer.getEmail(),
                        developer.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public Developer assignDeveloperToGame(UUID developerId, UUID gameId) {
        Developer developer = developerRepository.findById(developerId).orElse(null);
        Game game = gameRepository.findById(gameId).orElse(null);

        if (developer != null && game != null) {
            developer.setGame(game);
            return developerRepository.save(developer);
        }
        return null;
    }

    @Override
    public List<DeveloperDTO> getDevelopersByGameId(UUID gameId) {
        List<Developer> developers = developerRepository.findByGameUuid(gameId);
        return developers.stream()
                .map(developer -> new DeveloperDTO(
                        developer.getUuid(),
                        developer.getName(),
                        developer.getEmail(),
                        developer.getRole()))
                .collect(Collectors.toList());
    }
}
