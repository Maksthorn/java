package quiz;

/**
 *
 * @author Grim
 */
//answer class used for retrieving data with accessors and mutators
public class Answer {
    private String answer;
    private boolean correct;

    public Answer(String answer, boolean correct) {
        this.answer = answer;
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    //bool used to retrive answer from db
    public boolean correctAnswer() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    //used for proccessing chars from answer options
    public String toString(char letter) {
        return letter + ": " + answer;
    }
    
}
