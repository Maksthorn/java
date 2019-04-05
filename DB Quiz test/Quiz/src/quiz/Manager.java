package quiz;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Grim
 */
public class Manager {
    private static StorageManager stMan;
    private Question[] questions = new Question[500];
    private int numQuestions;
    private int level;
    private int score;
    private Question currentQuestion;
            
            
   public static int getRandom(int iMax ,int iMin){
        int iRand = 0;
        iRand=(int)Math.round(Math.random()*(iMax-iMin))+iMin;
        return iRand;
    }
   
   public Manager(String db) throws ClassNotFoundException, SQLException{
       stMan = new StorageManager(db);
       level = 1;
       populateQuestions();
   
   }

    public static StorageManager getStMan() {
        return stMan;
    }
    
    public void addQuestions(String question, int questionID) throws SQLException{
        questions[numQuestions] = new Question(question , questionID );
        numQuestions++;
    
    }
    
    public void populateQuestions() throws SQLException{
    
        numQuestions = 0;
        String SQL = "SELECT question_id , question FROM questions WHERE level="+level;
        ResultSet result = stMan.query(SQL);
        while(result.next()){
            int questionID = result.getInt("question_id");
            String question = result.getString("question");
            
            addQuestions(question , questionID);
        }
    }
    
    public String getQuestion(){
        //returns random question 
        currentQuestion = questions[getRandom(0,numQuestions - 1)];
        return currentQuestion.toString();
    }
    
    public boolean answer(char answer){
        if(currentQuestion.isCorrect(answer)){
            score++;
            return true;
        }else{
            score--;
            return false;
        }
        
    }
   
}
