import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

    void main () {

        IO.println("Flashcard System has started");
        IO.println("Input name of flashcard set");

        String fileName = IO.readln();

        try (BufferedReader b = new BufferedReader(new FileReader(fileName + ".txt"))) {

            IO.println(fileName + " found");

        } catch (IOException e) {

            IO.println(fileName + " not found");
            
            
        }
    }

}
