package GUI;

import DB.DB;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Wraith
 */
public class Einloggen extends javax.swing.JFrame {
    Chilliliste ChilliFrame;
    Registrieren RegFrame;
    /**
     * Creates new form Einloggen
     */
    public Einloggen(java.awt.Frame parent, boolean modal) {
        setIconImage(getToolkit().getImage("Icon.png"));
        initComponents();
     }
    
    public void Callback()
    { this.SetEditable(true);}
             
    public void SetEditable(boolean state)
    {
    this.TxtUsername.setEnabled(state);
    this.PwField.setEnabled(state);
    this.BtnAnmelden.setEnabled(state);
    this.BtnReg.setEnabled(state);
    }
    
    public void clear()
    {
    this.TxtUsername.setText(null);
    this.PwField.setText(null);
    }

    public boolean SetJDialogVisibleIfExist(JDialog Dialog, boolean b)
    {
    if(Dialog!=null)
        {
        Dialog.setVisible(b);
        return true;
        }
    
    else
        {return false;}
    }
  
    public void IconifiedAllWindows()
    {
    if(this.SetJDialogVisibleIfExist(this.ChilliFrame, false))
        {
        this.SetJDialogVisibleIfExist(this.ChilliFrame.ZusatzFrame, false);
        this.SetJDialogVisibleIfExist(this.ChilliFrame.NeuFrame, false);
        if(this.SetJDialogVisibleIfExist(this.ChilliFrame.EreignisFrame, false))
            {
            if(this.SetJDialogVisibleIfExist(this.ChilliFrame.EreignisFrame.DüngerForm, false))
                {this.SetJDialogVisibleIfExist(this.ChilliFrame.EreignisFrame.DüngerForm, false);}
            }
        }
    this.SetJDialogVisibleIfExist(this.RegFrame, false); 
    }        
                
    public void DeiconifiedAllWindows()
    {
    if(this.SetJDialogVisibleIfExist(this.ChilliFrame, true))
        {
        this.SetJDialogVisibleIfExist(this.ChilliFrame.ZusatzFrame, true);
        this.SetJDialogVisibleIfExist(this.ChilliFrame.NeuFrame, true);
        if(this.SetJDialogVisibleIfExist(this.ChilliFrame.EreignisFrame, true))
            {
            if(this.SetJDialogVisibleIfExist(this.ChilliFrame.EreignisFrame.DüngerForm, true))
                {this.SetJDialogVisibleIfExist(this.ChilliFrame.EreignisFrame.DüngerForm, true);}
            }
        }
    this.SetJDialogVisibleIfExist(this.RegFrame, true);         
    }    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblWelcome = new javax.swing.JLabel();
        PanLog = new javax.swing.JPanel();
        TxtUsername = new javax.swing.JTextField();
        PwField = new javax.swing.JPasswordField();
        LblLogin = new javax.swing.JLabel();
        BtnAnmelden = new javax.swing.JButton();
        Lblname = new javax.swing.JLabel();
        LblPw = new javax.swing.JLabel();
        BtnReg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Einloggen");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
            public void windowDeiconified(java.awt.event.WindowEvent evt) {
                formWindowDeiconified(evt);
            }
        });

        LblWelcome.setText("Willkommen auf unserer Chilizucht-Datenbank!");

        PanLog.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TxtUsername.setText("Username");
        TxtUsername.setName("Username"); // NOI18N
        TxtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtUsernameMouseClicked(evt);
            }
        });

        PwField.setText("PASSWORT");
        PwField.setToolTipText("");
        PwField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PwFieldMouseClicked(evt);
            }
        });

        LblLogin.setText("Bitte loggen sie sich mit ihrem Benutzernamen und Password ein!");

        BtnAnmelden.setText("Anmelden");
        BtnAnmelden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAnmeldenMouseClicked(evt);
            }
        });
        BtnAnmelden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnmeldenActionPerformed(evt);
            }
        });

        Lblname.setText("Benutzername :");

        LblPw.setText("Passwort :");

        BtnReg.setText("Registrieren");
        BtnReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnRegMouseClicked(evt);
            }
        });
        BtnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanLogLayout = new javax.swing.GroupLayout(PanLog);
        PanLog.setLayout(PanLogLayout);
        PanLogLayout.setHorizontalGroup(
            PanLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanLogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanLogLayout.createSequentialGroup()
                        .addGroup(PanLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lblname)
                            .addComponent(LblPw))
                        .addGap(31, 31, 31)
                        .addGroup(PanLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanLogLayout.createSequentialGroup()
                                .addComponent(BtnAnmelden, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnReg, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PwField, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(LblLogin))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        PanLogLayout.setVerticalGroup(
            PanLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanLogLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(LblLogin)
                .addGap(18, 18, 18)
                .addGroup(PanLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lblname))
                .addGap(18, 18, 18)
                .addGroup(PanLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PwField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblPw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAnmelden)
                    .addComponent(BtnReg))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblWelcome)
                    .addComponent(PanLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblWelcome)
                .addGap(18, 18, 18)
                .addComponent(PanLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAnmeldenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAnmeldenMouseClicked
 
    }//GEN-LAST:event_BtnAnmeldenMouseClicked
 
    private void BtnAnmeldenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnmeldenActionPerformed
    boolean empty=false;
    this.Lblname.setForeground(Color.black);
    this.LblPw.setForeground(Color.black);
            
    if(this.TxtUsername.getText().isEmpty())
        {
        this.Lblname.setForeground(Color.red);
        empty=true;
        }
    
    if(this.PwField.getPassword().length==0)
        {
        this.LblPw.setForeground(Color.red);
        empty=true;
        }
        
    if(empty==true)
        {
        JOptionPane.showMessageDialog(this, "Bitte füllen Sie alle Felder aus", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
     if (!empty) {
        String username = this.TxtUsername.getText();
        String pw = this.PwField.getText();
        boolean userExists = false;
        boolean pwCorrect = false;
        
        try {
            DB userCheck = new DB();
            userCheck.CheckLogOn(username, pw);
            
            if (userCheck.getuserValidity()) {
                this.ChilliFrame = new Chilliliste(this);
                this.SetEditable(false);
                this.clear();
                this.ChilliFrame.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(this, "Passwort oder Benutzname falsch", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Die Datenbank ist nicht erreichbar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
     }
     
    }//GEN-LAST:event_BtnAnmeldenActionPerformed

    private void BtnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegActionPerformed
    this.clear();
    this.RegFrame = new Registrieren(this);
    this.SetEditable(false);     
    this.RegFrame.setVisible(true);
    }//GEN-LAST:event_BtnRegActionPerformed

    private void BtnRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRegMouseClicked

    }//GEN-LAST:event_BtnRegMouseClicked

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
    this.IconifiedAllWindows();
    }//GEN-LAST:event_formWindowIconified

    private void formWindowDeiconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeiconified
    this.DeiconifiedAllWindows();
    }//GEN-LAST:event_formWindowDeiconified

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    if(this.ChilliFrame!=null)
        {
        if(this.ChilliFrame.showConfirmDialog("Chilliliste")){this.dispose();}
        else {return;}
        }
    else {this.dispose();}
    }//GEN-LAST:event_formWindowClosing

    private void TxtUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtUsernameMouseClicked
    if(TxtUsername.getText().equals("Username"))
    {TxtUsername.setText("");};
    }//GEN-LAST:event_TxtUsernameMouseClicked

    private void PwFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PwFieldMouseClicked
    if(this.PwField.getText().equals("PASSWORT"))
        {PwField.setText("");}
    }//GEN-LAST:event_PwFieldMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
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
            java.util.logging.Logger.getLogger(Einloggen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Einloggen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Einloggen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Einloggen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the dialog */   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Einloggen dialog = new Einloggen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnmelden;
    private javax.swing.JButton BtnReg;
    private javax.swing.JLabel LblLogin;
    private javax.swing.JLabel LblPw;
    private javax.swing.JLabel LblWelcome;
    private javax.swing.JLabel Lblname;
    private javax.swing.JPanel PanLog;
    private javax.swing.JPasswordField PwField;
    private javax.swing.JTextField TxtUsername;
    // End of variables declaration//GEN-END:variables
}
