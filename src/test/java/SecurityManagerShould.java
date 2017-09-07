import infraestructure.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
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
        verify(console, times(4)).readLine();
        verifyNoMoreInteractions(console);
    }

    @Test
    public void not_create_a_user_if_password_length_less_than_eight_characters() throws IOException {
        SecurityManager.console = console;

        when(console.readLine()).thenReturn("Rachel", "Rachel M.", "0123456", "0123456");
        SecurityManager.createUser();

        verify(console).print("Enter a username");
        verify(console).print("Enter your full name");
        verify(console).print("Enter your password");
        verify(console).print("Re-enter your password");
        verify(console, times(4)).readLine();
        verify(console).print("Password must be at least 8 characters in length");
        verifyNoMoreInteractions(console);
    }

    @Test
    public void create_a_user_if_passwords_match_and_have_eight_characters() throws IOException {
        SecurityManager.console = console;

        when(console.readLine()).thenReturn("Rachel", "Rachel M.", "01234567", "01234567");
        SecurityManager.createUser();

        verify(console).print("Enter a username");
        verify(console).print("Enter your full name");
        verify(console).print("Enter your password");
        verify(console).print("Re-enter your password");
        verify(console, times(4)).readLine();
        verify(console).print("Saving Details for User (Rachel, Rachel M., 76543210)\n");
        verifyNoMoreInteractions(console);
    }

    @Test
    public void create_a_user_if_passwords_match_and_have_more_than_eight_characters() throws IOException {
        SecurityManager.console = console;

        when(console.readLine()).thenReturn("Rachel", "Rachel M.", "0123456789", "0123456789");
        SecurityManager.createUser();

        verify(console).print("Enter a username");
        verify(console).print("Enter your full name");
        verify(console).print("Enter your password");
        verify(console).print("Re-enter your password");
        verify(console, times(4)).readLine();
        verify(console).print("Saving Details for User (Rachel, Rachel M., 9876543210)\n");
        verifyNoMoreInteractions(console);
    }

}