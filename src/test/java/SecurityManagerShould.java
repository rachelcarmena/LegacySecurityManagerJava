import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SecurityManagerShould {

    @Mock
    Console console;

    @Test
    public void not_create_a_user_if_passwords_not_match() throws IOException {
        SecurityManager.console = console;

        when(console.readLine()).thenReturn("Rachel", "Rachel M.", "0123456789", "9876543210");
        SecurityManager.createUser();

        verify(console).print("Enter a username");
        verify(console).print("Enter your full name");
        verify(console).print("Enter your password");
        verify(console).print("Re-enter your password");
        verify(console).print("The passwords don't match");
    }
}