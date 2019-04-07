package quiz;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Grim
 */
public class Manager {
    private static StorageManager stMan; //allows to be referable without having an instance of it
    private Question[] questions = new Question[15];
    private int questionNum;
    private int tier; //used to go into the next tier of questions
    private int chance;
    private double score;
    private int attempt;
    private Question currentQuestion;
   
    //instantiate variables
   public Manager(String db) throws ClassNotFoundException, SQLException{
       stMan = new StorageManager(db);
       tier = 1;
       chance = 4;
       score = 0.0;
       attempt = 1;
       addQuestions();

   }
    
   //add question objects to questions array
    public void addQuestions(String question, int questionID) throws SQLException{
        questions[questionNum] = new Question(question , questionID );
        questionNum++;
    
    }
    
    public void addQuestions() throws SQLException{
        //reset  
        questionNum = 0;
        String SQL = "SELECT QuestionID , Question FROM Questions WHERE tier =" + tier;
        //selects questions based on tier 
        ResultSet result = stMan.query(SQL);
        
        while(result.next()){
            int questionID = result.getInt("QuestionID");
            String question = result.getString("Question");   
            Manager.this.addQuestions(question , questionID);
        }
    }
    
    
     //used in getQuestion method  range of questions      
   public static int getRandom(int Max ,int Min){
        int Rand = 0;
        Rand =(int)Math.round(Math.random()*(Max-Min))+Min;
        return Rand;
    }
    
    public String getQuestion(){
        //returns random question , - 1 compensates for arrays starting at 0
        //uses the min max range min is 0 max is last element in array - 1
        currentQuestion = questions[getRandom(0,questionNum - 1)];
        return currentQuestion.toString();
    }
    
    //compares user input to what the answer is
    public boolean answer(char answer) throws SQLException{
        if(currentQuestion.isCorrect(answer)){
             upDifficulty();
             
             if(attempt == 2){
                 score += 0.5;
                 //set num attempt back to 1 to reset
                 attempt = 1;
             }else{
                 score++;
             }
             
             if(tier == 12){
                 System.out.println("you win");
                 System.exit(0);
             }
             
            return true;
        }else{
            //if an answer is wrong lose a chance
            attempt++;
            chance--;
            if(chance == 0){
                System.exit(0);
            }
            return false;
        }
        
    }
    
   public void upDifficulty() throws SQLException{
            tier++;
            addQuestions();
   }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int score) {
        this.chance = score;
    }
   

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }
    
    
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public static StorageManager getStMan() {
        return stMan;
    }
}