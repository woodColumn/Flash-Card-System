/**
 * Flash card
 *
 * Flash card that contains a question and an answer
 *
 * @author Logan Gierahn
 * @version November 25, 2026
 *
*/

public class FlashCard {

    private String question;
    private String answer;
    private int numCorrect = 0;
    private int numIncorrect = 0;


    FlashCard(String question, String answer) {

        this.question = question;
        this.answer = answer;
    }

    FlashCard(String question, String answer, int numCorrect, int numIncorrect) {

        this.question = question;
        this.answer = answer;
        this.numCorrect = numCorrect;
        this.numIncorrect = numIncorrect;
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
}