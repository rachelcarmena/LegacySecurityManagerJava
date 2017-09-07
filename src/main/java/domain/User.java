package domain;

public class User {
    private String username;
    private String fullName;
    private String encryptedPassword;

    public User(String username, String fullName, String encryptedPassword) {
        this.username = username;
        this.fullName = fullName;
        this.encryptedPassword = encryptedPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }
}
