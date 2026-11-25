import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class main {

    void main () {

        IO.println("Flashcard System has started");

        while (true) {


            IO.println("Input name of flashcard set");

            String fileName = IO.readln();

            try {

            BufferedReader input = new BufferedReader(new FileReader(fileName + ".txt"));
            BufferedWriter output = new BufferedWriter(new FileWriter(fileName + "txt"));

                IO.println(fileName + " found");

            } catch (IOException e) {

                IO.println(fileName + " not found");
                IO.println("Would you like to create a new flashcard set named " + fileName + "?");

                String userAnswer = IO.readln();


                while (!(userAnswer.equals("yes") || userAnswer.equals("no"))) {

                    IO.println("Invalid response, please input \"yes\" or \"no\"");
                    userAnswer = IO.readln();
                }


                if (userAnswer.equals("yes")) {

                    try {

                        File cardFile = new File(fileName + ".txt");
                        cardFile.createNewFile();

                        BufferedReader input = new BufferedReader(new FileReader(fileName + ".txt"));
                        BufferedWriter output = new BufferedWriter(new FileWriter(fileName + ".txt"));

                        break;

                    } catch (Exception IOException) {
                        IO.println("Error creating file");
                    }

                }

            }
        }
    }

}