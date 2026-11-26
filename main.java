import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class main {

    void main () throws IOException {

        String fileName;                                                                        // This String will hold the file name without the ".txt" ending
        String userAnswer;                                                                      // This String will hold user inputs
        ArrayList<FlashCard> cards = new ArrayList<>();                                         // This arraylist will hold each flash card in the current set

    BufferedReader input;


    IO.println("Flashcard System has started");

        while (true) {                                                                          // While loop that runs until either a user's inputed flashcard set is found, or
                                                                                                // a new file is successfully created

            IO.println("Input name of flashcard set");

            fileName = IO.readln();

            try {                                                                               // Try to set up buffered reader using the file user inputed
                                                                                                // (actual name of file = fileName + ".txt")

                input = new BufferedReader(new FileReader(fileName + ".txt"));

                IO.println(fileName + " found");                                                // If BufferedReader is successfully created, the file must exist. Inform the user and break
                                                                                                // out of the loop
                break;

            } catch (IOException e) {                                                           // If BufferedReader is not successfully created, the file could not be found. Inform the
                                                                                                // user and ask if they would like to create a new flashcard set

                IO.println(fileName + " not found");
                IO.println("Would you like to create a new flashcard set named " + fileName + "?");

                userAnswer = IO.readln();


                while (!(userAnswer.equals("yes") || userAnswer.equals("no"))) {                // Repeatedly ask for user input until it is either "yes" or "no"

                    IO.println("Invalid response, please input \"yes\" or \"no\"");
                    userAnswer = IO.readln();
                }


                if (userAnswer.equals("yes")) {                                             // If user answers "yes" try to create a new file using the inputed flashcard set name.
                                                                                            // If the file is successfully created, break out of the loop.
                    try {                                                                   // If the file is not successfully created, indicated by "new BufferedReader" causing an
                                                                                            // error, inform the user and continue the loop
                        File cardFile = new File(fileName + ".txt");                        // If the user answers "no" continue the loop
                        cardFile.createNewFile();

                        input = new BufferedReader(new FileReader(fileName + ".txt"));

                        break;

                    } catch (Exception IOException) {
                        IO.println("Error creating file");
                    }

                }

            }
        }

        String flashCardData;                   // String to contain one line of the flash card set file (question,answer)

        try {

            flashCardData = input.readLine();   // Read in one line of the file

        } catch (IOException e) {
            throw new IOException();
        }

        while (!(flashCardData == null)) {                                                          // While there is still data in the file, use .split to make an array containing
                                                                                                    // each flash card's data, then use this data to create a new Flash card and
            String[] flashCardDataArray = flashCardData.split(",");                                 // add it to the cards arraylist
            FlashCard flashCard = new FlashCard(flashCardDataArray[0], flashCardDataArray[1]);

            cards.add(flashCard);
            flashCardData = input.readLine();
        }

        input.close();

        while (true) {                                                              // Main loop. Asks user if they want to view cards, study, or exit. Loop continues
                                                                                    // until user types "exit", in which case the program terminates
            IO.println("Would you like to view cards, study, or exit?");
            userAnswer = IO.readln();

            while (!(userAnswer.equals("view") || userAnswer.equals("study") || userAnswer.equals("exit"))) {

                IO.println("Invalid response, please input \"view\", \"study\", or \"exit\"");
                userAnswer = IO.readln();
            }

            if (userAnswer.equals("exit")) {
                return;
            }

            if (userAnswer.equals("view")) {

                viewCards(cards, fileName);

            }

        }


    }

	
    public void viewCards(ArrayList<FlashCard> cards, String fileName) throws IOException {     // Function that displays cards, and allows for editing

        IO.println();

        String userAnswer;

        while (true) {                                                                          // Loop that displays cards, then allows user to make changes until
                                                                                                // user decides to return
            displayCards(cards);

            IO.println("Would you like to add a card, edit a card, or return?");
            userAnswer = IO.readln();

            while (!(userAnswer.equals("add") || userAnswer.equals("edit") || userAnswer.equals("return"))) {   // Ask user if they would like to "add", "edit", or "return"
                                                                                                                // until they type a valid input
                IO.println("Invalid response, please input \"add\", \"edit\", or \"return\"");
                userAnswer = IO.readln();
            }

            if (userAnswer.equals("add")) {                     // If user selects add, ask for the question and answer until valid inputs
                                                                // A valid input cannot have a comma (messes up file) or be empty (messes up reading file)
                IO.println("What is the question?");            // After the question and answer are gotten, create a new flashcard and update the file
                String question = IO.readln();

                while (true) {

                    if (question.indexOf(",") != -1) {
                        IO.println("Question cannot contain commas. Try again");
                    } else if (question == null || question.equals("")) {
                        IO.println("What is the question?");
                    } else {
                        break;
                    }

                    question = IO.readln();
                }

                IO.println("What is the answer?");
                String answer = IO.readln();

                    while (true) {

                        if (answer.indexOf(",") != -1) {
                            IO.println("Answer cannot contain commas. Try again");
                        } else if (answer == null || answer.equals("")) {
                            IO.println("What is the answer?");
                        } else {
                            break;
                        }

                        answer = IO.readln();
                    }

                cards.add(new FlashCard(question, answer));
                updateFile(cards, fileName);

            } else if (userAnswer.equals("edit")) {     // If user selects edit, and there are no cards, repeat loop (will then display that there are no cards)
                                                        // If there are cards, ask user to enter card number until valid
                int cardNumber;

                if (cards.size() != 0) {

                    IO.println("Select flashcard number to edit");

                    while (true) {                              // Loop that continually prompts user for card number until they put in a valid one

                        try {

                            cardNumber = Integer.parseInt(IO.readln());

                            if (cardNumber < 1 || cardNumber > cards.size()) {

                                IO.println("Card #" + cardNumber + " does not exist. Please select from one of the following cards");
                                displayCards(cards);

                            } else {
                                break;
                            }

                        } catch (Exception e) {

                            IO.println("Type a whole number");

                        }

                    }


                    IO.println("Would you like to change the question, change the answer, delete, or quit?");       // Asks user how they would like to edit the card until valid input
                    userAnswer = IO.readln();

                    while (!(userAnswer.equals("question") || userAnswer.equals("answer") || userAnswer.equals("delete") || userAnswer.equals("quit"))) {

                        IO.println("Invalid response, please input \"question\", \"answer\", \"delete\", or \"quit\"");
                        userAnswer = IO.readln();
                    }

                    if (userAnswer.equals("question")) {        // If user selects question, prompt them for the new question until it is valid.
                                                                // Once the question is valid, change the selected card's question and update the file
                        IO.println("What is the question?");
                        String question = IO.readln();

                        while (true) {

                            if (question.indexOf(",") != -1) {
                                IO.println("Question cannot contain commas. Try again");
                            } else if (question == null || question.equals("")) {
                                IO.println("What is the question?");
                            } else {
                                break;
                            }

                            question = IO.readln();
                        }

                        cards.get(cardNumber - 1).setQuestion(question);
                        updateFile(cards, fileName);

                    } else if (userAnswer.equals("answer")) {   // If user selects answer, prompt them for the new answer until it is valid.
                                                                // Once the answer is valid, change the selected card's answer and update the file
                        IO.println("What is the answer?");
                        String answer = IO.readln();

                        while (true) {

                            if (answer.indexOf(",") != -1) {
                                IO.println("Answer cannot contain commas. Try again");
                            } else if (answer == null || answer.equals("")) {
                                IO.println("What is the answer?");
                            } else {
                                break;
                            }

                            answer = IO.readln();
                        }

                        cards.get(cardNumber - 1).setAnswer(answer);
                        updateFile(cards, fileName);

                    } else if (userAnswer.equals("delete")) {

                        cards.remove(cardNumber - 1);
                        updateFile(cards, fileName);

                    }

                }

            } else {        // If the user didn't type either "add" or "edit", they must've typed return. Returns to main loop.
                return;
            }
        }
    }


    public void updateFile(ArrayList<FlashCard> cards, String fileName) throws IOException {    // Rewrites flashcard set csv file using current card array

        BufferedWriter output = new BufferedWriter(new FileWriter(fileName + ".txt"));

        for (int i = 0; i < cards.size(); i++) {

            output.write(cards.get(i).getQuestion() + "," + cards.get(i).getAnswer() + "\n");
        }

        output.close();
    }


    public void displayCards(ArrayList<FlashCard> cards) {                      // Method to display current card information

        IO.println();

        if (cards.size() == 0) {                                                // If there are no cards, display unique message

            IO.println("No cards");
            IO.println();
        }

        for (int i = 0; i < cards.size(); i++) {                                // Display card information
            IO.println("#" + (i + 1));
            IO.println("Question: " + cards.get(i).getQuestion());
            IO.println("Answer: " + cards.get(i).getAnswer());
            IO.println();
        }
    }

}