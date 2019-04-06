package quiz;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Grim
 */
public class GUI extends javax.swing.JFrame {
private Manager manager;

    public GUI() {
        try {
            initComponents();
            manager = new Manager("Quiz.accdb"); //passes the name of the db to the manager class
            lblTier.setText(manager.getTier() + ""); // populates the side bar
            lblScore.setText(manager.getScore() + ""); // populates the side bar
            txtDisplay.setText(manager.getQuestion()); // populates the main display with the question
            
            
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
    public void answer(char letter){
    try {
        boolean correct = manager.answer(letter);
        if(correct){
            JOptionPane.showMessageDialog(this, "Answer was wrong");
            txtDisplay.setText(manager.getQuestion());
            lblTier.setText(manager.getTier() + "");
        }else{
            JOptionPane.showMessageDialog(this, "Answer was correct");
            txtDisplay.setText(manager.getQuestion());
            lblScore.setText(manager.getScore() + "");
            
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
        jLabel1 = new javax.swing.JLabel();
        lblTier = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtona = new javax.swing.JButton();
        jButtonb = new javax.swing.JButton();
        jButtonc = new javax.swing.JButton();
        jButtond = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDisplay = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Question Tier :");

        lblTier.setText("tier");

        jLabel2.setText("Score :");

        lblScore.setText("score");

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblScore)
                    .addComponent(jLabel2)
                    .addComponent(lblTier))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScore)
                .addContainerGap(227, Short.MAX_VALUE))
        );

        getContentPane().add(dataPanel, java.awt.BorderLayout.LINE_END);

        jPanel2.setLayout(new java.awt.GridLayout());

        jButtona.setText("A");
        jPanel2.add(jButtona);

        jButtonb.setText("B");
        jButtonb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonbActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonb);

        jButtonc.setText("C");
        jButtonc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonc);

        jButtond.setText("D");
        jPanel2.add(jButtond);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.GridLayout());

        txtDisplay.setEditable(false);
        txtDisplay.setColumns(20);
        txtDisplay.setRows(5);
        jScrollPane1.setViewportView(txtDisplay);

        jPanel3.add(jScrollPane1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbActionPerformed
        answer('B');
    }//GEN-LAST:event_jButtonbActionPerformed

    private void jButtoncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncActionPerformed
         answer('C');
    }//GEN-LAST:event_jButtoncActionPerformed

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
                new GUI().setVisible(true);
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblTier;
    private javax.swing.JTextArea txtDisplay;
    // End of variables declaration//GEN-END:variables
}