package GUI;

import DB.DB;
import java.awt.Color;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * This Class assembels the login window and 
 * gives the User the possibility to either Log in 
 * or to register a new User
 * @author Team ChiDaBa
 */
public class Einloggen extends javax.swing.JFrame {
    Chilliliste ChilliFrame;
    Registrieren RegFrame;
    /**
     * Creates new form Einloggen
     */
    public Einloggen(java.awt.Frame parent, boolean modal) {
        setIconImage(getToolkit().getImage("src/ICONS/Icon.png"));
        initComponents();
     }
    /**
     * Uses the SetEditable to renew the 
     * activity in Einloggen
     */
    public void Callback()
    { this.SetEditable(true);}
    /**
     * Enables or disables the Textfield, the Pwfield and the two buttons
     * @param state The boolean value of state dictates whether the window Einloggen is enabled or not
     */         
    public void SetEditable(boolean state)
    {
    this.TxtUsername.setEnabled(state);
    this.PwField.setEnabled(state);
    this.BtnAnmelden.setEnabled(state);
    this.BtnReg.setEnabled(state);
    }
    /**
     *sets the text and passwordfield to NULL 
     */
    public void clear()
    {
    this.TxtUsername.setText(null);
    this.PwField.setText(null);
    }
    /**
     * Checks if the JDialoge in question exists
     * @return if the return-Value is true then the Frame does exist, othewise false
     * @param b gets the boolean value to iconify or deiconify all frames
     */
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
    /**
     * this method sets all Windows setVisible values to False
     */  
    public void IconifiedAllWindows()
    {
    if(this.SetJDialogVisibleIfExist(this.ChilliFrame, false))
        {
        this.SetJDialogVisibleIfExist(this.ChilliFrame.ZusatzFrame, false);
        if(this.SetJDialogVisibleIfExist(this.ChilliFrame.EreignisFrame, false))
            {
            if(this.SetJDialogVisibleIfExist(this.ChilliFrame.EreignisFrame.DüngerForm, false))
                {this.SetJDialogVisibleIfExist(this.ChilliFrame.EreignisFrame.DüngerForm, false);}
            }
        }
    this.SetJDialogVisibleIfExist(this.RegFrame, false); 
    }        
    /**
     * this method sets all Windows setVisible values to True 
     */            
    public void DeiconifiedAllWindows()
    {
    if(this.SetJDialogVisibleIfExist(this.ChilliFrame, true))
        {
        this.SetJDialogVisibleIfExist(this.ChilliFrame.ZusatzFrame, true);
        if(this.SetJDialogVisibleIfExist(this.ChilliFrame.EreignisFrame, true))
            {
            if(this.SetJDialogVisibleIfExist(this.ChilliFrame.EreignisFrame.DüngerForm, true))
                {this.SetJDialogVisibleIfExist(this.ChilliFrame.EreignisFrame.DüngerForm, true);}
            }
        }
    this.SetJDialogVisibleIfExist(this.RegFrame, true);         
    }    
    /**
     * builds the frame and initialises all components
     */
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

        BtnAnmelden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/key_24.png"))); // NOI18N
        BtnAnmelden.setText("Anmelden");
        BtnAnmelden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAnmeldenMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMouseEnteredSetColor(evt);
            }
        });
        BtnAnmelden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnmeldenActionPerformed(evt);
            }
        });

        Lblname.setText("Benutzername :");

        LblPw.setText("Passwort :");

        BtnReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/man_24.png"))); // NOI18N
        BtnReg.setText("Registrieren");
        BtnReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnRegMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMouseEnteredSetColor(evt);
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
                                .addComponent(BtnAnmelden, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnReg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PwField)
                            .addComponent(TxtUsername)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAnmeldenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAnmeldenMouseClicked
 
    }//GEN-LAST:event_BtnAnmeldenMouseClicked
    /**
     * @exception e is trown when there is no conection to the database to check the Password
     * if the button Anmelden is clicked the action shall be performed
     */
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
            String md5HashedPass="";
            
            try {md5HashedPass = getPasswordMd5Hash(PwField.getPassword());} 
            catch (Exception e) {System.err.println(e.getMessage());}
        
        try {
            DB userCheck = new DB();
            userCheck.CheckLogOn(username, md5HashedPass);
            
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
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Die Datenbank ist nicht erreichbar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
     }
     
    }//GEN-LAST:event_BtnAnmeldenActionPerformed
    /**
     * calls the Registrieren frame
     */
    private void BtnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegActionPerformed
    this.clear();
    this.RegFrame = new Registrieren(this);
    this.SetEditable(false);     
    this.RegFrame.setVisible(true);
    }//GEN-LAST:event_BtnRegActionPerformed

    private void BtnRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRegMouseClicked

    }//GEN-LAST:event_BtnRegMouseClicked
    /**
     * minimizes all windows
     */
    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
    this.IconifiedAllWindows();
    }//GEN-LAST:event_formWindowIconified
    /**
     * maximizes all windows
     */
    private void formWindowDeiconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeiconified
    this.DeiconifiedAllWindows();
    }//GEN-LAST:event_formWindowDeiconified
    /**
     * gives a warning if you would like to close Einloggen while Chililiste is still open
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    if(this.ChilliFrame!=null)
        {
        if(this.ChilliFrame.showConfirmDialog("Chilliliste")){this.dispose();}
        else {return;}
        }
    else {this.dispose();}
    }//GEN-LAST:event_formWindowClosing
    /**
     * sets the Username = "" if the textfield is still filled with "Username"
     */
    private void TxtUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtUsernameMouseClicked
    if(TxtUsername.getText().equals("Username"))
    {TxtUsername.setText("");};
    }//GEN-LAST:event_TxtUsernameMouseClicked
    /**
     * clears the PwField if PASSWORT is still in it
     */
    private void PwFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PwFieldMouseClicked
    if(this.PwField.getText().equals("PASSWORT"))
        {PwField.setText("");}
    }//GEN-LAST:event_PwFieldMouseClicked

    private void BtnMouseEnteredSetColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMouseEnteredSetColor
    evt.getComponent().setBackground(new Color(177,47,46));
    }//GEN-LAST:event_BtnMouseEnteredSetColor

    private void BtnMouseExitedSetColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMouseExitedSetColor
    evt.getComponent().setBackground(null);
    }//GEN-LAST:event_BtnMouseExitedSetColor
    /**
     * encrypts the password
     */
    public String getPasswordMd5Hash(char[] password) throws Exception
    {
    // convert char array to byte array with String:
    byte[] bytePassword = new String(password).getBytes();
        
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(bytePassword,0, bytePassword.length);
        
        String hashedPass = new BigInteger(1,md5.digest()).toString(16);  
        if (hashedPass.length() < 32) {hashedPass = "0" + hashedPass;}
        
        return hashedPass;
    }
    
    
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
