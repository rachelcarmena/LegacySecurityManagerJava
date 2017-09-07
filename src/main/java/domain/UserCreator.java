package domain;

import infrastructure.RequestData;

public class UserCreator {
    private PasswordEncrypter passwordEncrypter;

    public UserCreator(PasswordEncrypter passwordEncrypter) {
        this.passwordEncrypter = passwordEncrypter;
    }

    public User createFrom(RequestData requestData) {
        String encryptedPassword = passwordEncrypter.encrypt(requestData.getPassword());
        return new User(requestData.getUsername(),
                requestData.getFullName(),
                encryptedPassword);
    }
}
