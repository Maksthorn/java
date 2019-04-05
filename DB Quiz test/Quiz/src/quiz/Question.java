/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Grim
 */
public class Question {
    private String question;
    private int questionID;
    private Answer[] answers = new Answer[6];
    private int numAnswers = 0;

    public Question(String question ,int questionID ) throws SQLException {
        this.question = question;
        this.questionID = questionID;
        
        String SQL = "SELECT answer , correct_answer FROM answers WHERE questionFK =" + this.questionID;
        ResultSet result = Manager.getStMan().query(SQL); 
        
        while(result.next()){
            String answer = result.getString("Answer");
            boolean correct = result.getBoolean("Correct");
            //populates array with answers
            answers[numAnswers] = new Answer(answer , correct);
            numAnswers++;
        }
       
    }

    @Override
    public String toString() {
        String display = "";
        //answer options
        String letters = "ABCDEF";
        for (int i = 0; i < numAnswers; i++){
            display += answers[i].toString(letters.charAt(i)) + "\n";
        }
        //returns question and possible answer
        return question + "\n\n" + display;
    }
    
    
    public static int getRandom(int iMax ,int iMin){
        int iRand = 0;
        iRand=(int)Math.round(Math.random()*(iMax-iMin))+iMin;
        return iRand;
    }
    
    public boolean isCorrect(char letter){
        String letters = "ABCDEF";
        //answer options
        int pos = letters.indexOf(letters+"");
        return answers[pos].isCorrect();
    }
    
}
