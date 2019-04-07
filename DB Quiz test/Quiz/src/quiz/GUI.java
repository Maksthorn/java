package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Grim
 */
public class GUI extends javax.swing.JFrame {
private Manager manager;
private StorageManager stMan;
private Question quest;

    public GUI() throws SQLException, ClassNotFoundException {
        try {
            initComponents();
            manager = new Manager("Quiz.accdb"); //passes the name of the db to the manager class
            lblTier.setText(manager.getTier() + ""); // populates the side bar
            lblChance.setText(manager.getChance() + ""); // populates the side bar
            lblScore.setText(manager.getScore() + ""); // populates the side bar
            lblAttempt.setText(manager.getAttempt() + ""); // populates the side bar
            txtDisplay.setText(manager.getQuestion()); // populates the main display with the question
            
            jTextAnswer.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   /* try {
                        String input = jTextAnswer.getText();
                        System.out.println(input);
                        String SQL = "SELECT Answer, Correct FROM Answers WHERE QuestionFK="+ quest.getQuestionID()+" AND Correct =" +input;
                        //selects questions based on tier
                        ResultSet result = stMan.query(SQL);
                        
                    } catch (SQLException ex) {
                        System.err.println("Class not found exception in GUI constructor " + ex);
                        
                    }*/
                   
                   // takes input from jtext
                   String input = jTextAnswer.getText();
                   //take character and pass it to answer method
                   char c = input.charAt(0);
                   
                   try{
                        answer(c);
                   }catch(InputMismatchException ex){System.err.println("err in jtext input" + ex);}
                   //System.out.println(c);
                }
            
            });
            
            
        } catch (ClassNotFoundException ex) {
            //prints out error message and creates a pop up in the JOptionPane
            System.err.println("Class not found exception in GUI constructor " + ex);
            JOptionPane.showMessageDialog(this, "Application has ran into an ClassNotFound error " + ex);

        } catch (SQLException ex) {
             //prints out error message and creates a pop up in the JOptionPane
            System.err.println("SQL error in GUI constructor " + ex);
            JOptionPane.showMessageDialog(this, "Application has ran into an SQL error " + ex);
        }
    }
    
    public void actionPerformed(ActionEvent e){
                   /* try {
                        String input = jTextAnswer.getText();
                        System.out.println(input);
                        String SQL = "SELECT Answer, Correct FROM Answers WHERE QuestionFK="+ quest.getQuestionID()+" AND Correct =" +input;
                        //selects questions based on tier
                        ResultSet result = stMan.query(SQL);
                        
                    } catch (SQLException ex) {
                        System.err.println("Class not found exception in GUI constructor " + ex);
                        
                    }*/
                   
                   String input = jTextAnswer.getText();
                   char c = input.charAt(0);
                   try{
                        answer(c);
                   }catch(InputMismatchException ex){System.err.println("err in jtext input" + ex);}
                   //System.out.println(c);
                }
    
    public void answer(char letter){
    try {
        //calls the answer method from the manager class to check answer
        boolean correct = manager.answer(letter);
        
        //if true
        if(correct){
            JOptionPane.showMessageDialog(this, "Answer was correct");
            txtDisplay.setText(manager.getQuestion());
            lblTier.setText(manager.getTier() + "");
            lblScore.setText(manager.getScore() + ""); // populates the side bar
            lblAttempt.setText(manager.getAttempt() + ""); // populates the side bar
        }else{
            JOptionPane.showMessageDialog(this, "Answer was wrong");
            txtDisplay.setText(manager.getQuestion());
            lblChance.setText(manager.getChance() + "");
            lblAttempt.setText(manager.getAttempt() + ""); // populates the side bar
            
        }
    } catch (SQLException ex) {
        System.err.println("Error in answer " + ex);
        JOptionPane.showMessageDialog(this, "Error in answer " + ex);
    }
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataPanel = new javax.swing.JPanel();
        lblTier = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblChance = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblAttempt = new javax.swing.JLabel();
        jTextAnswer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtona = new javax.swing.JButton();
        jButtonb = new javax.swing.JButton();
        jButtonc = new javax.swing.JButton();
        jButtond = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDisplay = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTier.setText("question");

        jLabel2.setText("Type Answer");

        lblChance.setText("chance");

        jLabel1.setText("Question num");

        jLabel3.setText("Chances");

        jLabel4.setText("Score:");

        lblScore.setText("points");

        jLabel5.setText("Attempts:");

        lblAttempt.setText("att num");

        jTextAnswer.setToolTipText("Press Enter to Submit");
        jTextAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAnswerActionPerformed(evt);
            }
        });

        jLabel6.setText("Alternatively");

        jLabel7.setText("below 'A' or 'D'");

        jLabel8.setText("(case sensitive)");

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblChance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(lblScore)
                    .addComponent(jLabel5)
                    .addComponent(lblAttempt)
                    .addComponent(jTextAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(lblTier)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblChance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAttempt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        getContentPane().add(dataPanel, java.awt.BorderLayout.LINE_END);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jButtona.setText("A");
        jButtona.setToolTipText("Option A for above question");
        jButtona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonaActionPerformed(evt);
            }
        });
        jPanel2.add(jButtona);

        jButtonb.setText("B");
        jButtonb.setToolTipText("Option B for above question");
        jButtonb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonbActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonb);

        jButtonc.setText("C");
        jButtonc.setToolTipText("Option C for above question");
        jButtonc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonc);

        jButtond.setText("D");
        jButtond.setToolTipText("Option D for above question");
        jButtond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtondActionPerformed(evt);
            }
        });
        jPanel2.add(jButtond);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        txtDisplay.setEditable(false);
        txtDisplay.setColumns(20);
        txtDisplay.setRows(5);
        jScrollPane1.setViewportView(txtDisplay);

        jPanel3.add(jScrollPane1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // pass button value  
    private void jButtonbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbActionPerformed
        answer('B');
    }//GEN-LAST:event_jButtonbActionPerformed
    // pass button value  
    private void jButtoncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncActionPerformed
         answer('C');
    }//GEN-LAST:event_jButtoncActionPerformed
    // pass button value  
    private void jButtondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtondActionPerformed
        answer('D');
    }//GEN-LAST:event_jButtondActionPerformed
    // pass button value  
    private void jButtonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaActionPerformed
        answer('A');
    }//GEN-LAST:event_jButtonaActionPerformed

    private void jTextAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAnswerActionPerformed
        //do nothing 
    }//GEN-LAST:event_jTextAnswerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                } catch (SQLException ex) {
                    System.err.println("SQLException cought in gui()" +ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("ClassNotFoundException cought in gui()" +ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dataPanel;
    private javax.swing.JButton jButtona;
    private javax.swing.JButton jButtonb;
    private javax.swing.JButton jButtonc;
    private javax.swing.JButton jButtond;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextAnswer;
    private javax.swing.JLabel lblAttempt;
    private javax.swing.JLabel lblChance;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblTier;
    private javax.swing.JTextArea txtDisplay;
    // End of variables declaration//GEN-END:variables
}
