/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author Grim
 */
public class Question {
    private String question;
    private int questionID;
    private Answer[] answers = new Answer[6];

    public Question(String question ,int questionID ) {
        this.question = question;
        this.questionID = questionID;
        String SQL = "SELECT answer , correct_answer FROM answers WHERE questionFK ="+this.questionID;
       
    }
    
    public static int getRandom(int iMax ,int iMin){
        int iRand = 0;
        iRand=(int)Math.round(Math.random()*(iMax-iMin))+iMin;
        return iRand;
    }
    
}
