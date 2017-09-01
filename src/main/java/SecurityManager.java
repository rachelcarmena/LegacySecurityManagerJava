
import java.io.IOException;

public class SecurityManager {

    public static Console console = new Console();

    public static void createUser() {

        String username = null;
        String fullName = null;
        String password = null;
        String confirmPassword = null;
        try {
            console.print("Enter a username");
            username = console.readLine();
            console.print("Enter your full name");
            fullName = console.readLine();
            console.print("Enter your password");
            password = console.readLine();
            console.print("Re-enter your password");
            confirmPassword = console.readLine();
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
}