/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DB.DB;
import DataStructur.Duenger;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author mn
 */
public class DüngerNeu extends javax.swing.JDialog {
    
    Ereignisse parentform;
    private boolean InfoViewState=false;
    /**
     * Creates new form Duenger
     */
    public DüngerNeu(Ereignisse parent) {
        this.parentform = parent;
        setIconImage(getToolkit().getImage("src/ICONS/Icon.png"));
        initComponents();
    }

    
    public void SetInfoView(boolean state) 
    {
    this.setTitle("InfoView");
    this.TxtName.setEditable(!state);
    this.SpinKalium.setEnabled(!state);
    this.SpinMag.setEnabled(!state);
    this.SpinPhos.setEnabled(!state);
    this.SpinStick.setEnabled(!state);
    this.BtnAbbr.setText("OK");
    this.BtnOk.setVisible(!state);
    this.InfoViewState=state;
    
    //Spinner with own Method: SetSpinnerDisablesTextColor
    this.SetSpinnerDisablesTextColor(this.SpinKalium, Color.BLACK);
    this.SetSpinnerDisablesTextColor(this.SpinMag, Color.BLACK);
    this.SetSpinnerDisablesTextColor(this.SpinPhos, Color.BLACK);
    this.SetSpinnerDisablesTextColor(this.SpinStick, Color.BLACK);
    }
    
    // change DefaultEditor to ge a better view
    private void SetSpinnerDisablesTextColor(JSpinner spinner, Color color)
        {((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().setDisabledTextColor(color);}
    
    public void SetDuengerData(Duenger duenger)
    {
    this.TxtName.setText(duenger.getName());
    this.SpinKalium.setValue(duenger.getKalium());
    this.SpinMag.setValue(duenger.getMagnesium());
    this.SpinPhos.setValue(duenger.getPhosphat());  
    this.SpinStick.setValue(duenger.getStickstoff());  
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblName = new javax.swing.JLabel();
        TxtName = new javax.swing.JTextField();
        LblStick = new javax.swing.JLabel();
        SpinStick = new javax.swing.JSpinner();
        LblStickE = new javax.swing.JLabel();
        LblPhos = new javax.swing.JLabel();
        SpinPhos = new javax.swing.JSpinner();
        LblPhosE = new javax.swing.JLabel();
        LblKalium = new javax.swing.JLabel();
        SpinKalium = new javax.swing.JSpinner();
        LblKaliumE = new javax.swing.JLabel();
        LblMag = new javax.swing.JLabel();
        SpinMag = new javax.swing.JSpinner();
        LblMagE = new javax.swing.JLabel();
        BtnOk = new javax.swing.JButton();
        BtnAbbr = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Neuer Dünger");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        LblName.setText("Produktname:");

        LblStick.setText("Stickstoff:");

        SpinStick.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        LblStickE.setText("mg");

        LblPhos.setText("Phosphat:");

        SpinPhos.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        LblPhosE.setText("mg");

        LblKalium.setText("Kalium:");

        SpinKalium.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        LblKaliumE.setText("mg");

        LblMag.setText("Magnesium:");

        SpinMag.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        LblMagE.setText("mg");

        BtnOk.setText("OK");
        BtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOkActionPerformed(evt);
            }
        });

        BtnAbbr.setText("Abbrechen");
        BtnAbbr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAbbrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblName)
                            .addComponent(LblStick)
                            .addComponent(LblPhos)
                            .addComponent(LblKalium)
                            .addComponent(LblMag))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SpinMag, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LblMagE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(SpinStick, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LblStickE))
                            .addComponent(TxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SpinPhos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LblPhosE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SpinKalium, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LblKaliumE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAbbr, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblName)
                    .addComponent(TxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblStick)
                    .addComponent(SpinStick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblStickE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblPhos)
                    .addComponent(SpinPhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblPhosE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblKalium)
                    .addComponent(SpinKalium, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblKaliumE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblMag)
                    .addComponent(SpinMag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblMagE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnOk)
                    .addComponent(BtnAbbr))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        public void CleanClose()
        {
        this.dispose();
        this.parentform.DüngerForm=null; // because dispose
        this.parentform.SetEditable(true);   
        } 
    
    private void BtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOkActionPerformed
        if (!this.TxtName.getText().isEmpty()) 
            {
            Duenger neu = new Duenger(TxtName.getText(), (int)SpinStick.getValue(), (int)SpinPhos.getValue(), (int)SpinKalium.getValue(), (int)SpinMag.getValue());
            DB InsertDuenger = new DB();
            try {
                if(InsertDuenger.getDuengerInfo(TxtName.getText())==null)
                    {
                    try {InsertDuenger.InsertIntoDuenger(neu);} 
                    catch (Exception ex) {System.err.println(ex.getMessage());}

                    try {this.parentform.updateCBDuengerList();}             
                    catch (Exception ex) {System.err.println(ex.getMessage());}

                    this.parentform.setDünger(this.TxtName.getText());
                    this.CleanClose();
                    }
                
                else {JOptionPane.showMessageDialog(this, "Name bereits vergeben", "Error", JOptionPane.ERROR_MESSAGE);}
                } 
            catch (Exception ex) {System.err.println(ex.getMessage());}
            }
        else
            {
            JOptionPane.showMessageDialog(this, "Bitte füllen Sie alle Felder aus", "Error", JOptionPane.ERROR_MESSAGE);
            }   
    }//GEN-LAST:event_BtnOkActionPerformed

    private void BtnAbbrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbbrActionPerformed
    if(this.InfoViewState)
        {this.CleanClose();}
    else
        {
        if(this.parentform.AskClosingforChild())
            {this.CleanClose();}
        }
    }//GEN-LAST:event_BtnAbbrActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    
        if(this.InfoViewState || this.parentform.AskClosingforChild())
        {this.CleanClose();}
    }//GEN-LAST:event_formWindowClosing
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAbbr;
    private javax.swing.JButton BtnOk;
    private javax.swing.JLabel LblKalium;
    private javax.swing.JLabel LblKaliumE;
    private javax.swing.JLabel LblMag;
    private javax.swing.JLabel LblMagE;
    private javax.swing.JLabel LblName;
    private javax.swing.JLabel LblPhos;
    private javax.swing.JLabel LblPhosE;
    private javax.swing.JLabel LblStick;
    private javax.swing.JLabel LblStickE;
    private javax.swing.JSpinner SpinKalium;
    private javax.swing.JSpinner SpinMag;
    private javax.swing.JSpinner SpinPhos;
    private javax.swing.JSpinner SpinStick;
    private javax.swing.JTextField TxtName;
    // End of variables declaration//GEN-END:variables
}
