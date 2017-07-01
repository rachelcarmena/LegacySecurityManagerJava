package unit_tests;

import org.junit.Before;
import org.junit.Test;
import user_creation.*;

import static org.mockito.Mockito.*;


public class CreatingUserTest {

    private UserDataRetrieval userDataRetrieval;
    private Reporter reporter;
    private CreatingUser creatingUser;

    @Before
    public void setUp() throws Exception {
        userDataRetrieval = mock(UserDataRetrieval.class);
        reporter = mock(Reporter.class);
        creatingUser = new CreatingUser(userDataRetrieval, reporter, new ReverseEncryption());
    }

    @Test
    public void creating_user_with_valid_password() {
        String password = "12345678";
        String encryptedPassword = "87654321";
        UserData userData = new UserData("pepe", "pepe lopes", password, password);
        when(userDataRetrieval.invoke()).thenReturn(
            userData
        );

        creatingUser.execute();

        verify(reporter).reportSuccessCreatingUser(
            "Saving Details for User (pepe, pepe lopes, 87654321)\n"
        );
    }

    @Test
    public void creating_user_using_a_password_that_is_to_short() {
        when(userDataRetrieval.invoke()).thenReturn(
            new UserData("pepe", "pepe lopes", "1234567", "1234567")
        );

        creatingUser.execute();

        verify(reporter).reportError("Password must be at least 8 characters in length");
    }

    @Test
    public void creating_user_using_passwords_that_do_not_match() {
        when(userDataRetrieval.invoke()).thenReturn(
            new UserData("pepe", "pepe lopes", "1234567", "xkofjsofis")
        );

        creatingUser.execute();

        verify(reporter).reportError("The passwords don't match");
    }
}
