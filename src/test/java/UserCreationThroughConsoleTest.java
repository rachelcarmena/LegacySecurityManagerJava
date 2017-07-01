import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreationThroughConsoleTest {

    @Test
    public void creating_user_with_valid_password() {
        FakeUserCreator userCreator = new FakeUserCreator(
            "pepe", "pepe lopes", "12345678", "12345678"
        );

        userCreator.createUser();

        assertThat(
            userCreator.lastPrintedLine(),
            is("Saving Details for User (pepe, pepe lopes, 87654321)\n"));
    }

    private class FakeUserCreator extends UserCreator {
        private final List<String> userInputs;
        private int linesReadNumber;
        private List<String> printedLines;

        public FakeUserCreator(String ... userInputs) {
            printedLines = new ArrayList<>();
            this.userInputs = Arrays.asList(userInputs);
            linesReadNumber = 0;
        }

        protected String readLine() throws IOException {
            String line = userInputs.get(linesReadNumber);
            linesReadNumber++;
            return line;
        }

        protected void print(String line) {
            printedLines.add(line);
        }

        public String lastPrintedLine() {
            return printedLines.get(printedLines.size() - 1);
        }
    }
}
