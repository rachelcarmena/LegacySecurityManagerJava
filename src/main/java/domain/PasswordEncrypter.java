package domain;

public class PasswordEncrypter {
    public String encrypt(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
