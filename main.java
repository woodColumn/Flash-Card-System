import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class main {

    void main () {

        IO.println("Flashcard System has started");						

        while (true) {                                                                          // While loop that runs until either a user's inputed flashcard set is found, or
                                                                                                // a new file is successfully created
											
            IO.println("Input name of flashcard set");

            String fileName = IO.readln();

            try {                                                                               // Try to set up buffered reader and writer using the file user inputed
                                                                                                // (file name = flashcard set name + ".txt")

            BufferedReader input = new BufferedReader(new FileReader(fileName + ".txt"));
            BufferedWriter output = new BufferedWriter(new FileWriter(fileName + ".txt"));

                IO.println(fileName + " found");                                                // If BufferedReader is successfully created, the file must exist. Inform the user and break
                                                                                                // out of the loop
		break;

            } catch (IOException e) {                                                           // If BufferedReader is not successfully created, the file could not be found. Inform the
                                                                                                // user and ask if they would like to create a new flashcard set

                IO.println(fileName + " not found");						
                IO.println("Would you like to create a new flashcard set named " + fileName + "?");

                String userAnswer = IO.readln();


                while (!(userAnswer.equals("yes") || userAnswer.equals("no"))) {                 // Repeatedly ask for user input until it is either "yes" or "no"

                    IO.println("Invalid response, please input \"yes\" or \"no\"");
                    userAnswer = IO.readln();
                }


                if (userAnswer.equals("yes")) {							// If user answers "yes" try to create a new file using the inputed flashcard set name.
												// If the file is successfully created, break out of the loop.
                    try {									// If the file is not successfully created, indicated by "new BufferedReader" causing an
												// error, inform the user and continue the loop
                        File cardFile = new File(fileName + ".txt");				// If the user answers "no" continue the loop
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