package quiz;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Grim
 */
public class Manager {
    private static StorageManager stMan; //allows to be referable without having an instance of it
    private Question[] questions = new Question[500];
    private int numQuestions;
    private int tier; //used to go into the next tier of questions
    private int score; 
    private Question currentQuestion;
           
   
   public Manager(String db) throws ClassNotFoundException, SQLException{
       stMan = new StorageManager(db);
       tier = 1;
       score = 4;
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
        String SQL = "SELECT QuestionID , Question FROM Questions WHERE tier =" + tier;
        //selects questions based on tier 
        ResultSet result = stMan.query(SQL);
        
        while(result.next()){
            int questionID = result.getInt("QuestionID");
            String question = result.getString("Question");   
            addQuestions(question , questionID);
        }
    }
    
    
     //used in getQuestion method        
   public static int getRandom(int Max ,int Min){
        int Rand = 0;
        Rand =(int)Math.round(Math.random()*(Max-Min))+Min;
        return Rand;
    }
    
    public String getQuestion(){
        //returns random question , - 1 compensates for arrays starting at 0 
        currentQuestion = questions[getRandom(0,numQuestions - 1)];
        return currentQuestion.toString();
    }
    
    //compares user input to what the answer is
    public boolean answer(char answer) throws SQLException{
        if(currentQuestion.isCorrect(answer)){
             tier++;
             populateQuestions();
            return true;
        }else{
            //if an answer is wrong lose a point
            score--;
            if(score == 0){
                System.exit(0);
            }
            return false;
        }
        
    }
   public void inscreaseDifficulty() throws SQLException{
            tier++;
            populateQuestions();
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
