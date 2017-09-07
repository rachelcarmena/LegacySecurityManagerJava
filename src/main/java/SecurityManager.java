import domain.PasswordEncrypter;
import domain.User;
import domain.UserCreator;
import infrastructure.Console;
import infrastructure.RequestData;
import infrastructure.UserRepository;
import domain.PasswordChecker;

import java.util.Optional;

public class SecurityManager {

    public static Console console = new Console();

    public static void createUser() {
        Optional<RequestData> requestData = RequestData.with(console).execute();
        if (!requestData.isPresent())
            return;

        String password = requestData.get().getPassword();
        PasswordChecker passwordChecker = PasswordChecker.with(console);
        if (!passwordChecker.isValid(password))
            return;

        UserCreator userCreator = new UserCreator(new PasswordEncrypter());
        User user = userCreator.createFrom(requestData.get());

        UserRepository userRepository = new UserRepository(console);
        userRepository.save(user);
    }

}