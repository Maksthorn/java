package quiz;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Grim
 */
public class Manager {
    private static StorageManager storeMan;
    private Question[] questions = new Question[500];
    private int numQuestions;
    private int tier; //used to go into the next tier of questions
    private int score; 
    private Question currentQuestion;
            
   //used in getQuestion method        
   public static int getRandom(int Max ,int Min){
        int Rand = 0;
        Rand =(int)Math.round(Math.random()*(Max-Min))+Min;
        return Rand;
    }
   
   public Manager(String db) throws ClassNotFoundException, SQLException{
       storeMan = new StorageManager(db);
       tier = 1;
       populateQuestions();
   
   }

    public static StorageManager getStoreMan() {
        return storeMan;
    }
    
    public void addQuestions(String question, int questionID) throws SQLException{
        questions[numQuestions] = new Question(question , questionID );
        numQuestions++;
    
    }
    
    public void populateQuestions() throws SQLException{
    
        numQuestions = 0;
        String SQL = "SELECT question_id , question FROM questions WHERE tier =" + tier;
        //selects questions based on tier 
        ResultSet result = storeMan.query(SQL);
        
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
    
    public boolean answer(char answer) throws SQLException{
        if(currentQuestion.isCorrect(answer)){
            //if the answer is correct gain a point
            score++;
            populateQuestions();
            if (score == 3){
                tier++;
                 populateQuestions();
            }
            if(score == 5){
                tier++;
                 populateQuestions();
            }
            return true;
        }else{
            //if an answer is wrong lose a point
            score--;
             populateQuestions();
            return false;
        }
        
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
   
}
