/**
 * Flash card
 *
 * Flash card that contains a question, answer, number of times user has gotten the card correct, and number of times the
 * user has gotten the card wrong
 *
 * @author Logan Gierahn
 * @version November 27, 2026
 *
*/

public class FlashCard {

    private String question;                            // question contains the question
    private String answer;                              // answer contains the answer
    private int numCorrect = 0;                         // numCorrect contains the number of times the user has gotten the card correct
    private int numIncorrect = 0;                       // numIncorrect contains the number of times the user has gotten the card incorrect
    private boolean favorite = false;                   // If favorite is true, user has labeled the card as a favorite


    FlashCard(String question, String answer) {

        this.question = question;
        this.answer = answer;
    }

    FlashCard(String question, String answer, int numCorrect, int numIncorrect, boolean favorite) {

        this.question = question;
        this.answer = answer;
        this.numCorrect = numCorrect;
        this.numIncorrect = numIncorrect;
        this.favorite = favorite;
    }


    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getNumCorrect() {
        return numCorrect;
    }

    public int getNumIncorrect() {
        return numIncorrect;
    }

    public boolean getFavoriteStatus() {
        return favorite;
    }


    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void addCorrect() {
        numCorrect++;
    }

    public void addIncorrect() {
        numIncorrect++;
    }

    public void toggleFavorite() {
        if (favorite == true) {
            favorite = false;
        } else {
            favorite = true;
        }
    }
}