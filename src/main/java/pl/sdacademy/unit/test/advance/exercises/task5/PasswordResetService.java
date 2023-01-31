package pl.sdacademy.unit.test.advance.exercises.task5;

import java.time.LocalDateTime;
import java.util.UUID;

public class PasswordResetService {

    private static final String BODY_TEMPLATE = "Twoje tymczasowe hasło wygenerowane dnia REPLACE_DATE o godzinie REPLACE_TIME to REPLACE_PASSWORD";


    private final PasswordProvider passwordProvider;
    private final DateTimeProvider dateTimeProvider;

    public PasswordResetService(PasswordProvider passwordProvider, DateTimeProvider dateTimeProvider) {
        this.passwordProvider = passwordProvider;
        this.dateTimeProvider = dateTimeProvider;
    }


    public String generateEmailBodyMessage() {
        LocalDateTime currentDateTime = dateTimeProvider.currentDateTime();
        String newPassword = passwordProvider.generateNewPassword();

        return BODY_TEMPLATE
                .replace("REPLACE_DATE", currentDateTime.toLocalDate().toString())
                .replace("REPLACE_TIME", currentDateTime.toLocalTime().toString())
                .replace("REPLACE_PASSWORD", newPassword);
    }
}
