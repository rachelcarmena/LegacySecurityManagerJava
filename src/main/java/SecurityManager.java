
import infraestructure.Console;

import java.io.IOException;

public class SecurityManager {

    public static Console console = new Console();

    public static void createUser() {

        String username = null;
        String fullName = null;
        String password = null;
        String confirmPassword = null;
        try {
            username = requestFor("Enter a username");
            fullName = requestFor("Enter your full name");
            password = requestFor("Enter your password");
            confirmPassword = requestFor("Re-enter your password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!password.equals(confirmPassword)) {
            console.print("The passwords don't match");
            return;
        }

        if (password.length() < 8) {
            console.print("Password must be at least 8 characters in length");
            return;
        }

        // Encrypt the password (just reverse it, should be secure)
        String encryptedPassword = new StringBuilder(password).reverse().toString();

        console.print(String.format(
                "Saving Details for User (%s, %s, %s)\n",
                username,
                fullName,
                encryptedPassword));
    }

    private static String requestFor(String message) throws IOException {
        console.print(message);
        return console.readLine();
    }
}