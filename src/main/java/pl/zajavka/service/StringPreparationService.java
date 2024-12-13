package pl.zajavka.service;

import org.springframework.stereotype.Service;
import pl.zajavka.domain.User;
@Service
public class StringPreparationService {

    public String prepare(final User user) {
        return String.format("%s;%s", user.getBirthDate(), user.getEmail());
    }
}
