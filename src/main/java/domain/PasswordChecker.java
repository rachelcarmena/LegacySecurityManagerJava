package domain;

import infrastructure.Console;

public class PasswordChecker {
    private static final String PASSWORD_LENGTH_ERROR_MESSAGE = "Password must be at least %d characters in length";
    private static final int MINIMUN_LENGTH = 8;

    private Console console;

    public PasswordChecker(Console console) {
        this.console = console;
    }

    public static PasswordChecker with(Console console) {
        return new PasswordChecker(console);
    }

    public boolean isValid(String password) {
        if (password.length() < MINIMUN_LENGTH) {
            console.print(String.format(PASSWORD_LENGTH_ERROR_MESSAGE, MINIMUN_LENGTH));
            return false;
        }
        return true;
    }
}
