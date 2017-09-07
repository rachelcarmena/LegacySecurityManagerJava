package infrastructure;

import domain.User;

public class UserRepository {
    private static final String USER_SAVING_DETAILS_PATTERN = "Saving Details for User (%s, %s, %s)\n";

    private Console console;

    public UserRepository(Console console) {
        this.console = console;
    }

    public void save(User user) {
        console.print(String.format(
                USER_SAVING_DETAILS_PATTERN,
                user.getUsername(),
                user.getFullName(),
                user.getEncryptedPassword()));

    }
}
