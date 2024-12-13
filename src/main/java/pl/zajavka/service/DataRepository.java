package pl.zajavka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import pl.zajavka.domain.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class DataRepository {

    public List<User> readUsers() {
        try {
            return Files.readAllLines(ResourceUtils.getFile("classpath:users.csv").toPath()).stream()
                    .map(this::mapUser)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();
        } catch (IOException ex) {
            log.error("Error reading users.csv");
            return List.of();
        }
    }

    private Optional<User> mapUser(String line) {
        if (!line.contains("@")) {
            return Optional.empty();
        }
        List<String> lineAsList = Arrays.asList(line.split(";"));
        return Optional.of(User.builder()
                .email(lineAsList.get(0))
                .name(lineAsList.get(1))
                .publicName(lineAsList.get(2))
                .birthDate(LocalDate.parse(lineAsList.get(3)))
                .build());
    }

    public void save(final List<String> processed) {
        try {
            Files.write(Paths.get("build/result.txt"), processed);
        } catch (IOException ex) {
            log.error("Error saving data", ex);
        }
    }
}
