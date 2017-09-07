package infrastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    public void print(String message) {
        System.out.println(message);
    }
}
