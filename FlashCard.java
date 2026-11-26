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

    FlashCard(String question, String answer) {

        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}