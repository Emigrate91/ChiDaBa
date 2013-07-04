package GUI;

import DB.DB;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 * this class assembles the childForm Chilliliste of the parrentForm Einloggen
 * @author Team ChiDaBa
 */
public class Chilliliste extends javax.swing.JDialog {

    private Einloggen parentForm;
    PflanzenDaten ZusatzFrame;
    Ereignisse EreignisFrame;
    MyCustomRenderer renderer = new MyCustomRenderer();
     /**
     * Creates new form Chilliliste
     */
    public Chilliliste(Einloggen parent) throws Exception {
        this.parentForm=parent;
        setIconImage(getToolkit().getImage("src/ICONS/Icon.png"));
        initComponents();
        writeTblToTblChilli();
        TblChilli.setDefaultRenderer(Object.class, renderer );
        this.TxtSuche.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        rowSorterToStringConverter = new GUI.RowSorterToStringConverter();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblChilli = new javax.swing.JTable();
        PanListe = new javax.swing.JPanel();
        TxtSuche = new javax.swing.JTextField();
        BtnInfo = new javax.swing.JButton();
        BtnNew = new javax.swing.JButton();
        BtnLogout = new javax.swing.JButton();
        lblSearchFilter = new javax.swing.JLabel();
        BtnDelete = new javax.swing.JButton();
        BtnErignisse = new javax.swing.JButton();

        rowSorterToStringConverter.setTable(TblChilli);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Chilliliste");
        setMinimumSize(null);
        setName("Chilliliste"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        TblChilli.setAutoCreateRowSorter(true);
        TblChilli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sorte", "Art", "Herkunft", "Aussaat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TblChilli);

        PanListe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, TblChilli, org.jdesktop.beansbinding.ELProperty.create("${rowSorter}"), TxtSuche, org.jdesktop.beansbinding.BeanProperty.create("text"), "");
        binding.setConverter(rowSorterToStringConverter);
        bindingGroup.addBinding(binding);

        BtnInfo.setText("Zusatzinformation");
        BtnInfo.setEnabled(false);
        BtnInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMouseEnteredSetColor(evt);
            }
        });
        BtnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInfoActionPerformed(evt);
            }
        });

        BtnNew.setText("Neuer Eintrag");
        BtnNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMouseEnteredSetColor(evt);
            }
        });
        BtnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNewActionPerformed(evt);
            }
        });

        BtnLogout.setText("Ausloggen");
        BtnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMouseEnteredSetColor(evt);
            }
        });
        BtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogoutActionPerformed(evt);
            }
        });

        lblSearchFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/magnifier_24.png"))); // NOI18N
        lblSearchFilter.setText("Search Filter:");

        BtnDelete.setText("Eintrag Löschen");
        BtnDelete.setEnabled(false);
        BtnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnDeleteBtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnDeleteBtnMouseEnteredSetColor(evt);
            }
        });
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanListeLayout = new javax.swing.GroupLayout(PanListe);
        PanListe.setLayout(PanListeLayout);
        PanListeLayout.setHorizontalGroup(
            PanListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanListeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchFilter))
                .addGap(18, 18, 18)
                .addGroup(PanListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanListeLayout.createSequentialGroup()
                        .addComponent(BtnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanListeLayout.setVerticalGroup(
            PanListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanListeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSearchFilter))
                    .addComponent(BtnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnNew)
                    .addComponent(TxtSuche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDelete))
                .addContainerGap())
        );

        BtnErignisse.setText("Ereignisse");
        BtnErignisse.setEnabled(false);
        BtnErignisse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMouseEnteredSetColor(evt);
            }
        });
        BtnErignisse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnErignisseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanListe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnErignisse, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanListe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnErignisse)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * loads the informations into the table from the Database
 * @throws Exception DB-Exception if there is an error wit the database
 */
    public final void writeTblToTblChilli() throws Exception{
    DB loadTable = new DB();
    DefaultTableModel model = (DefaultTableModel) TblChilli.getModel();
   
    Object[] columnIdentifiers = new Object[model.getColumnCount()];
    
    for(int i=0;i<model.getColumnCount();i++)
        {columnIdentifiers[i]=model.getColumnName(i);}
    
    model.setDataVector(loadTable.getTblPflanzenFromDB(), columnIdentifiers);
    }
    
    /**
     * if the User wants to close a form, a warning opens to ask him if thats whats he relly wants
     * @return the answer of the user wether he wants to close the current form or not
     */
    public boolean AskClosing()
    {
    int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Alle nicht gespeicherten Änderungen gehen verloren", "Warnung",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
    if(showConfirmDialog==0) {return true;}
    else {return false;}
    }
    
    /**
     * this method closes the Frame clean
     */
    private void CleanClose()
    {
    this.dispose();
    this.parentForm.ChilliFrame=null; // because dispose
    this.parentForm.Callback();
    }
    /**
     * query if the User wants to close all open minimized frames alongside with this Frame
     * @param framename the name of the still open Frame
     * @return the answer wether the user wants to close the frames or not
     */
    public boolean showConfirmDialog(String framename)
    {
    int showConfirmDialogZusatz = JOptionPane.showConfirmDialog(this, "Das Fenster \""+framename+"\" ist noch geöffnet\nAlle nicht gespeicherten Änderungen gehen verloren", "Warnung",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
    if(showConfirmDialogZusatz==0){return true;} 
    else {return false;}
        
    }
    /**
     * SetEnabled is State and because of that either true or false 
     * @param state enables or disables every input component
     */
    public void SetEditable(boolean state)
    {
    this.BtnErignisse.setEnabled(state);
    this.BtnInfo.setEnabled(state);
    this.BtnLogout.setEnabled(state);
    this.BtnNew.setEnabled(state);
    this.TblChilli.setEnabled(state);
    this.TxtSuche.setEnabled(state);
    }
    /**
     * when the button Logout is clicked the method CleanClose shall be called
     */
    private void BtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogoutActionPerformed
    this.CleanClose();
    }//GEN-LAST:event_BtnLogoutActionPerformed
/**
 * ckecks wich row is selectet and opens the next frame 
 */
    private void BtnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInfoActionPerformed
    if(this.TblChilli.getSelectedRow()!=-1) {    
        
        DB con = new DB();
        Object sorte=this.TblChilli.getModel().getValueAt(this.TblChilli.getSelectedRow(), 0);
        Object art=this.TblChilli.getModel().getValueAt(this.TblChilli.getSelectedRow(), 1);
        try {
            Object PlantID =con.getPlantID(sorte, art);
            this.ZusatzFrame = new PflanzenDaten(this, PlantID);
            this.SetEditable(false);
            this.ZusatzFrame.setVisible(true); 
            this.ZusatzFrame.loaded=true;
            } 
        
        catch (Exception ex) {System.err.println(ex.getMessage());}
        }
    }//GEN-LAST:event_BtnInfoActionPerformed
/**
 * opens the Frame Neu and disables the current Frame
 * @exception opens an error message if the new frame cannot be openend
 */
    private void BtnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNewActionPerformed
        try {
            this.ZusatzFrame = new PflanzenDaten(this);
            this.SetEditable(false);
            this.ZusatzFrame.setTitle("Neuer Eintrag");
            this.ZusatzFrame.setVisible(true); 
            this.ZusatzFrame.loaded=true;
            
        } 
        
        catch (Exception ex) {System.err.println(ex.getMessage());}
    }//GEN-LAST:event_BtnNewActionPerformed
/**
 * opens the Frame Ereignisse for an selected row and loads the related information
 * @exception opens an error mesage if the informations cannot be pulled from the Database
 */
    private void BtnErignisseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnErignisseActionPerformed
    if(this.TblChilli.getSelectedRow()!=-1) {
        DB con = new DB();
        Object sorte=this.TblChilli.getModel().getValueAt(this.TblChilli.getSelectedRow(), 0);
        Object art=this.TblChilli.getModel().getValueAt(this.TblChilli.getSelectedRow(), 1);

        try {
            Object PlantID =con.getPlantID(sorte, art);
            Object EreignissID = con.getEreigniss_fk(PlantID);
            this.EreignisFrame = new Ereignisse(this, EreignissID);
            this.SetEditable(false);
            this.EreignisFrame.setVisible(true);
            } 
        catch (Exception ex) { System.err.println(ex.getMessage());}
        }
    }//GEN-LAST:event_BtnErignisseActionPerformed
/**
 * checks wich windows are open and closes them if Chililiste is closed
 */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    if(this.ZusatzFrame!=null) // if Zusatzrame is open
        {
        if(this.showConfirmDialog("Zusatzinformation"))
           {this.ZusatzFrame.CleanClose();} 
        else {return;}
        }
        
    
    if(this.EreignisFrame!=null) // if ErignisFrame is open
        {
         if(this.EreignisFrame.DüngerForm!=null)
            {
            if(this.showConfirmDialog("Neuer Dünger"))
                {
                this.EreignisFrame.DüngerForm.CleanClose();    
                this.EreignisFrame.CleanClose();
                }
            else {return;}
            }          
        else
            {
            if(this.showConfirmDialog("Ereignisse"))
                {this.EreignisFrame.CleanClose();}
            else {return;}            
            }
        } 
    
    // Close this Window
    this.CleanClose();
    }//GEN-LAST:event_formWindowClosing

     /**
     * Creates a TableCellRenderer
     * 
     * highlight the row on click on and enables the buttons, which need a
     * selected value
     * 
     */ 
     public class MyCustomRenderer extends DefaultTableCellRenderer{
    
     public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) {
        super.getTableCellRendererComponent(table, value, isSelected,hasFocus, row, column);
        
        if(table.isRowSelected(row)){
            setBackground(new Color(177,47,46));
            if(table.getSelectedRowCount()==1){
                setButtons(true);
            }
            else{
                setButtons(false);
            }
        }
        
        else{   
        setBackground(null); 
        }
  
        return this;
        }
     }
     
    public void setButtons(boolean b){
        BtnInfo.setEnabled(b);
        BtnErignisse.setEnabled(b);
        BtnDelete.setEnabled(b);
    } 
    
    private void BtnMouseExitedSetColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMouseExitedSetColor
    evt.getComponent().setBackground(null);
    }//GEN-LAST:event_BtnMouseExitedSetColor

    private void BtnMouseEnteredSetColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMouseEnteredSetColor
    evt.getComponent().setBackground(new Color(177,47,46));
    }//GEN-LAST:event_BtnMouseEnteredSetColor

    private void BtnDeleteBtnMouseExitedSetColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDeleteBtnMouseExitedSetColor
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnDeleteBtnMouseExitedSetColor

    private void BtnDeleteBtnMouseEnteredSetColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDeleteBtnMouseEnteredSetColor
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnDeleteBtnMouseEnteredSetColor

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Möchten Sie diesen Datensatz wirklich vollständig löschen?", "Warnung",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
        if(showConfirmDialog==0)
            {
            DB con = new DB();
            Object sorte=this.TblChilli.getModel().getValueAt(this.TblChilli.getSelectedRow(), 0);
            Object art=this.TblChilli.getModel().getValueAt(this.TblChilli.getSelectedRow(), 1);            
            
            try {
                // get PlantID
                Object PlantID =con.getPlantID(sorte, art);
                // Speichere Werte Zwischen 
                Object EreignisID = con.getEreigniss_fk(PlantID);
                Object PflanzenDatenID = con.getPflanzenDaten_FK(PlantID);

                // Delete Pflanze:
                con.deletePflanze(PlantID);

                // Delete Pflanzen Daten:
                con.deletePflanzenDaten(PflanzenDatenID); 

                // Delete Ereignisse:    
                con.deleteEreignis(EreignisID);

                // ereignis update:
                this.writeTblToTblChilli();
                this.setButtons(false);
            } 

            catch (Exception ex) {System.err.println(ex.getMessage());}       


            }

        else {}            
    }//GEN-LAST:event_BtnDeleteActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnErignisse;
    private javax.swing.JButton BtnInfo;
    private javax.swing.JButton BtnLogout;
    private javax.swing.JButton BtnNew;
    private javax.swing.JPanel PanListe;
    private javax.swing.JTable TblChilli;
    private javax.swing.JTextField TxtSuche;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearchFilter;
    private GUI.RowSorterToStringConverter rowSorterToStringConverter;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
