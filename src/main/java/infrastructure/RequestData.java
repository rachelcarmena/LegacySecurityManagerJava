package infrastructure;

import java.io.IOException;
import java.util.Optional;

public class RequestData {

    private static final String USERNAME = "Enter a username";
    private static final String FULL_NAME = "Enter your full name";
    private static final String PASSWORD = "Enter your password";
    private static final String RE_ENTER_PASSWORD = "Re-enter your password";
    private static final String PASSWORDS_NOT_MATCH_ERROR_MESSAGE = "The passwords don't match";

    private Console console;
    private String username;
    private String fullName;
    private String password;

    private RequestData(Console console) {
        this.console = console;
    }

    public static RequestData with(Console console) {
        return new RequestData(console);
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public Optional<RequestData> execute() {
        try {
            username = requestFor(USERNAME);
            fullName = requestFor(FULL_NAME);
            password = requestFor(PASSWORD);

            String confirmPassword = requestFor(RE_ENTER_PASSWORD);
            if (password.equals(confirmPassword))
                return Optional.of(this);
            console.print(PASSWORDS_NOT_MATCH_ERROR_MESSAGE);
            return Optional.empty();

        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private String requestFor(String message) throws IOException {
        console.print(message);
        return console.readLine();
    }
}