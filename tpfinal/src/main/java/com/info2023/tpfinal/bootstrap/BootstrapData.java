package com.info2023.tpfinal.bootstrap;

import com.info2023.tpfinal.entity.Developer;
import com.info2023.tpfinal.entity.Game;
import com.info2023.tpfinal.entity.GameTask;
import com.info2023.tpfinal.model.csv.DeveloperCsvRecord;
import com.info2023.tpfinal.model.csv.GameCsvRecord;
import com.info2023.tpfinal.model.csv.GameTaskCsvRecord;
import com.info2023.tpfinal.repository.DeveloperRepository;
import com.info2023.tpfinal.repository.GameRepository;
import com.info2023.tpfinal.repository.GameTaskRepository;
import com.info2023.tpfinal.service.csv.DeveloperCsvService;
import com.info2023.tpfinal.service.csv.GameCsvService;
import com.info2023.tpfinal.service.csv.GameTaskCsvService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BootstrapData implements CommandLineRunner {

    private final GameRepository gameRepository;
    private final GameCsvService gameCsvService;
    private final DeveloperRepository developerRepository;
    private final DeveloperCsvService developerCsvService;
    private final GameTaskRepository gameTaskRepository;
    private final GameTaskCsvService gameTaskCsvService;


    @Override
    public void run(String... args) throws Exception {
        log.info("Running BootstrapData");

        loadDeveloperData();
        loadGameData();
        loadGameTaskData();
    }

    private void loadGameData() throws IOException {
        if (gameRepository.count() < 5) {
            Resource resource = new ClassPathResource("csvdata/game_data.csv");
            File file = resource.getFile();
            List<GameCsvRecord> gameCsvRecordList = gameCsvService.convertCSV(file);

            if (!gameCsvRecordList.isEmpty()) {
                log.info("Loading games in the DB");
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                for (GameCsvRecord gameCsvRecord : gameCsvRecordList) {
                    LocalDate releaseDate = LocalDate.parse(gameCsvRecord.getReleaseDate(), dateFormatter);
                    Game game = Game.builder()
                            .title(gameCsvRecord.getTitle())
                            .description(gameCsvRecord.getDescription())
                            .releaseDate(releaseDate)
                            .build();
                    gameRepository.save(game);
                }
            }
        }
    }

    private void loadDeveloperData() throws IOException {
        if (developerRepository.count() < 5) {
            Resource resource = new ClassPathResource("csvdata/developer_data.csv");
            File file = resource.getFile();
            List<DeveloperCsvRecord> developerCsvRecordList = developerCsvService.convertCSV(file);

            if (!developerCsvRecordList.isEmpty()) {
                log.info("Loading developers in the DB");
                for (DeveloperCsvRecord developerCsvRecord : developerCsvRecordList) {
                    Developer developer = Developer.builder()
                            .name(developerCsvRecord.getName())
                            .email(developerCsvRecord.getEmail())
                            .role(developerCsvRecord.getRole())
                            .build();
                    developerRepository.save(developer);
                }
            }
        }
    }

    private void loadGameTaskData() throws IOException {
        if (gameTaskRepository.count() < 5) {
            Resource resource = new ClassPathResource("csvdata/gametask_data.csv");
            File file = resource.getFile();
            List<GameTaskCsvRecord> gameTaskCsvRecordList = gameTaskCsvService.convertCSV(file);

            if (!gameTaskCsvRecordList.isEmpty()) {
                log.info("Loading tasks in the DB");
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                for (GameTaskCsvRecord gameTaskCsvRecord : gameTaskCsvRecordList) {
                    LocalDate releaseDate = LocalDate.parse(gameTaskCsvRecord.getDeadline(), dateFormatter);
                    GameTask gameTask = GameTask.builder()
                            .description(gameTaskCsvRecord.getDescription())
                            .deadline(releaseDate) // Asignar el valor de releaseDate al campo deadline
                            .status(gameTaskCsvRecord.getStatus())
                            .build();
                    gameTaskRepository.save(gameTask);
                }
            }
        }
    }
}
