/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DB.DB;
import DataStructur.Bewaesserung;
import DataStructur.Duengung;
import DataStructur.Duenger;
import DataStructur.PflanzenHoehe;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;

/**
 * This Class enables the user to store information of a certain point in time for an Chiliplant
 * and creates the form Ereignisse
 * @author Team ChiDaBa
 */
public class Ereignisse extends javax.swing.JDialog {

    private Chilliliste ParentForm;
    DüngerNeu DüngerForm;
    Object EreignissID;
    /**
     * Creates new form Eigenschaften
     */
    public Ereignisse(Chilliliste parent, Object EreignissID) throws Exception {
        this.ParentForm=parent;
        this.EreignissID=EreignissID;
        this.setTitle("Ereignisse für "+ EreignissID);
        setIconImage(getToolkit().getImage("src/ICONS/Icon.png"));
        initComponents();
        updateCBDuengerList();
        writeAllToTable(EreignissID);
        sortTble();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane = new javax.swing.JScrollPane();
        TblEreignisse = new javax.swing.JTable();
        TabbedPane = new javax.swing.JTabbedPane();
        PanelMessung = new javax.swing.JPanel();
        LblDateH = new javax.swing.JLabel();
        LblH = new javax.swing.JLabel();
        SpinDatMess = new javax.swing.JSpinner();
        SpinH = new javax.swing.JSpinner();
        LblCm = new javax.swing.JLabel();
        PanelDünger = new javax.swing.JPanel();
        LblDateD = new javax.swing.JLabel();
        LblD = new javax.swing.JLabel();
        LblDM = new javax.swing.JLabel();
        LblCm1 = new javax.swing.JLabel();
        SpinDatDuen = new javax.swing.JSpinner();
        SpinM = new javax.swing.JSpinner();
        CBDuenger = new javax.swing.JComboBox();
        LblInf = new javax.swing.JLabel();
        PanelBewässerung = new javax.swing.JPanel();
        LblDMB = new javax.swing.JLabel();
        LblCmB = new javax.swing.JLabel();
        SpinMB = new javax.swing.JSpinner();
        LblDateD1 = new javax.swing.JLabel();
        SpinDatB = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(599, 398));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        TblEreignisse.setAutoCreateRowSorter(true);
        TblEreignisse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Datum", "Ereignis", "Dünger", "Menge in ml", "Höhe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollPane.setViewportView(TblEreignisse);

        LblDateH.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LblDateH.setText("Datum:");

        LblH.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LblH.setText("Höhe:");

        SpinDatMess.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        SpinDatMess.setModel(new javax.swing.SpinnerDateModel());
        SpinDatMess.setEditor(new javax.swing.JSpinner.DateEditor(SpinDatMess, "dd.MM.yyyy"));

        SpinH.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        SpinH.setModel(new javax.swing.SpinnerNumberModel(0, 0, 200, 1));

        LblCm.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LblCm.setText("mm");

        javax.swing.GroupLayout PanelMessungLayout = new javax.swing.GroupLayout(PanelMessung);
        PanelMessung.setLayout(PanelMessungLayout);
        PanelMessungLayout.setHorizontalGroup(
            PanelMessungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMessungLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMessungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblDateH)
                    .addComponent(LblH))
                .addGap(19, 19, 19)
                .addGroup(PanelMessungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMessungLayout.createSequentialGroup()
                        .addComponent(SpinH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblCm))
                    .addComponent(SpinDatMess, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        PanelMessungLayout.setVerticalGroup(
            PanelMessungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMessungLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMessungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblDateH)
                    .addComponent(SpinDatMess, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(PanelMessungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblH)
                    .addComponent(SpinH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblCm))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Höhen Messung", PanelMessung);

        LblDateD.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LblDateD.setText("Datum:");

        LblD.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LblD.setText("Dünger:");

        LblDM.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LblDM.setText("Menge:");

        LblCm1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LblCm1.setText("ml");

        SpinDatDuen.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        SpinDatDuen.setModel(new javax.swing.SpinnerDateModel());
        SpinDatDuen.setEditor(new javax.swing.JSpinner.DateEditor(SpinDatDuen, "dd.MM.yyyy"));

        SpinM.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        SpinM.setModel(new javax.swing.SpinnerNumberModel(0, 0, 200, 1));

        CBDuenger.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CBDuenger.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<neu>" }));
        CBDuenger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBDuengerActionPerformed(evt);
            }
        });

        LblInf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblInfMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelDüngerLayout = new javax.swing.GroupLayout(PanelDünger);
        PanelDünger.setLayout(PanelDüngerLayout);
        PanelDüngerLayout.setHorizontalGroup(
            PanelDüngerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDüngerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDüngerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblDateD)
                    .addComponent(LblD)
                    .addComponent(LblDM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDüngerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDüngerLayout.createSequentialGroup()
                        .addComponent(SpinM, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblCm1))
                    .addGroup(PanelDüngerLayout.createSequentialGroup()
                        .addComponent(CBDuenger, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblInf))
                    .addComponent(SpinDatDuen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        PanelDüngerLayout.setVerticalGroup(
            PanelDüngerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDüngerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDüngerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblDateD)
                    .addComponent(SpinDatDuen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelDüngerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDüngerLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(PanelDüngerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBDuenger, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblD)))
                    .addGroup(PanelDüngerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblInf)))
                .addGap(15, 15, 15)
                .addGroup(PanelDüngerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpinM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblDM)
                    .addComponent(LblCm1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Düngvorgang", PanelDünger);

        LblDMB.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LblDMB.setText("Menge:");

        LblCmB.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LblCmB.setText("ml");

        SpinMB.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        SpinMB.setModel(new javax.swing.SpinnerNumberModel(0, 0, 200, 1));

        LblDateD1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LblDateD1.setText("Datum:");

        SpinDatB.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        SpinDatB.setModel(new javax.swing.SpinnerDateModel());
        SpinDatB.setEditor(new javax.swing.JSpinner.DateEditor(SpinDatDuen, "dd.MM.yyyy"));

        javax.swing.GroupLayout PanelBewässerungLayout = new javax.swing.GroupLayout(PanelBewässerung);
        PanelBewässerung.setLayout(PanelBewässerungLayout);
        PanelBewässerungLayout.setHorizontalGroup(
            PanelBewässerungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBewässerungLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBewässerungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblDMB)
                    .addComponent(LblDateD1))
                .addGap(19, 19, 19)
                .addGroup(PanelBewässerungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SpinMB)
                    .addComponent(SpinDatB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblCmB)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        PanelBewässerungLayout.setVerticalGroup(
            PanelBewässerungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBewässerungLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(PanelBewässerungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblDateD1)
                    .addComponent(SpinDatB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(PanelBewässerungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpinMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblDMB)
                    .addComponent(LblCmB))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Bewässerung", PanelBewässerung);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/chart_line_64.png"))); // NOI18N
        btnAdd.setText("Hinzufügen");
        btnAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMouseEnteredSetColor(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/home_64.png"))); // NOI18N
        btnExit.setText("Zurück");
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMouseEnteredSetColor(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
/**
 * asks the parentForm if the childForm shalll be closed
 */
    public boolean AskClosingforChild() // long way to keep: PRIVATE Chilliliste ParentForm; 
    {
    return this.ParentForm.AskClosing();
    }
   /**
    * Updates the list of all aviable Duenger in the DB and in the Table
    * @throws Exception when the update of the DuengerList has failed
    */ 
    public final void updateCBDuengerList() throws Exception{    
    DB con= new DB();
    ArrayList names = con.getList("name", "tbl_duenger");
    DefaultComboBoxModel model = (DefaultComboBoxModel) this.CBDuenger.getModel();
    
    for(Object e : names.toArray()){
        if(model.getIndexOf(e)==-1)
            {model.insertElementAt(e, names.indexOf(e));}
        }
    

    model.setSelectedItem(model.getElementAt(0));
    }
    /**
     * Writes the entered values for Hoehe into the Database
     * @param EreignissID used to keep the Ereignisse in check
     * @throws Exception if the Hoehe cant be entered in the database
     */
    public void writeHoeheToTable(Object EreignissID) throws Exception
    {
    DB con = new DB();
    ArrayList<Object[]> hoehenMessungen = con.getEreignissHoeheList(this.EreignissID);
    
    DefaultTableModel model = (DefaultTableModel) this.TblEreignisse.getModel();
    
    for(Object[] e : hoehenMessungen){model.addRow(e);}
    }
    /**
     * Writes the entered values for Duengevorgang into the Database
     * @param EreignissID used to keep the Ereignisse in check
     * @throws Exception if the Duengevorgang cant be entered in the database
     */
    public void writeDuengVToTable(Object EreignissID) throws Exception
    {
    DB con = new DB();
    ArrayList<Object[]> DuengVMessungen = con.getEreignissDuengVList(this.EreignissID);
    
    DefaultTableModel model = (DefaultTableModel) this.TblEreignisse.getModel();
    
    for(Object[] e : DuengVMessungen){model.addRow(e);}
    }
    /**
     * Writes the entered values for Bewässerung into the Database
     * @param EreignissID used to keep the Ereignisse in check
     * @throws Exception if the Bewässerung cant be entered into the database
     */     
    public void writeBeWToTable(Object EreignissID) throws Exception
    {
    DB con = new DB();
    ArrayList<Object[]> BeWMessungen = con.getEreignissBeWList(this.EreignissID);
    
    DefaultTableModel model = (DefaultTableModel) this.TblEreignisse.getModel();
    
    for(Object[] e : BeWMessungen){model.addRow(e);}
    }
    
    /**
     * Writes everything Ereigniss related into the Table
     * @param EreignissID keeps check on the Ereignisse
     * @throws Exception  if an error would be encounterd while writing the values into the Database
     */
    public final void writeAllToTable(Object EreignissID) throws Exception
    {
    this.writeHoeheToTable(EreignissID);
    this.writeDuengVToTable(EreignissID);
    this.writeBeWToTable(EreignissID);
    }
   
    
    /**
     * sorts the table
     */
    public final void sortTble()
    {
    // nach Datum sortieren:
    RowSorter sorter = TblEreignisse.getRowSorter();
    ArrayList sortKeys = new ArrayList();
    sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
    sorter.setSortKeys(sortKeys);
    }
    /**
     * Enables or disables every component in the form
     * @param state bolean value to either setEnabled true or false
     */
    public void SetEditable(boolean state)
    {
    this.CBDuenger.setEnabled(state);
    this.SpinDatDuen.setEnabled(state);
    this.SpinDatMess.setEnabled(state);
    this.SpinH.setEnabled(state);
    this.SpinM.setEnabled(state);
    this.TabbedPane.setEnabled(state);
    this.TblEreignisse.setEnabled(state);
    }
    /**
     * used to close a childWinow in clean manner and to re-enable the ParentForm
     */
    public void CleanClose()
        {
        this.dispose();
        this.ParentForm.EreignisFrame=null; // because dispose
        this.ParentForm.SetEditable(true);   
        }
       
    
    private SimpleDateFormat myformatter = new SimpleDateFormat("dd.MM.yyyy");
    /**
     * When a Hoehe entry shall be added to the Table 
     */
    private void addHoehe(){
        PflanzenHoehe h = new PflanzenHoehe(EreignissID, (Date)this.SpinDatMess.getValue(),(int)this.SpinH.getValue());
        try {h.saveInDB();} 
        catch (Exception ex) {System.err.println(ex.getMessage());}
        
    DefaultTableModel deft=(DefaultTableModel)this.TblEreignisse.getModel(); 
    deft.addRow(new Object[] {myformatter.format((Date)this.SpinDatMess.getValue()),"Höhen Messung","/","/", (int)this.SpinH.getValue()   });     
    }
        /**
     * When a duengevorgang shall be added to the Table
     * @exception When an ivalid Duenger has been choosen
     */
    private void addDuengevorgang(){
        if(this.CBDuenger.getSelectedItem()!="<neu>")
        { 
        Duengung dw = new Duengung(EreignissID, (Date)this.SpinDatDuen.getValue(),String.valueOf(this.CBDuenger.getSelectedItem()),(int)(this.SpinM.getValue()));
        try {dw.saveInDB();} 
        catch (Exception ex) {Logger.getLogger(Ereignisse.class.getName()).log(Level.SEVERE, null, ex);}    
                   
        DefaultTableModel deft=(DefaultTableModel)this.TblEreignisse.getModel();
        deft.addRow(new Object[] {myformatter.format((Date)this.SpinDatDuen.getValue()),"Düngevorgang",this.CBDuenger.getSelectedItem(), SpinM.getValue(), "/" });
        }
    else
        {
        JOptionPane.showMessageDialog(this, "<neu> ist kein gültigen Dünger", "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    /**
 * enteres a new Duenger into the Database
 * @exception if the Duenger cant be saved into the Database
 */
    private void LblInfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblInfMouseClicked
       if(this.CBDuenger.getSelectedIndex()!=this.CBDuenger.getItemCount()-1 && this.DüngerForm==null)
        {
        this.DüngerForm = new DüngerNeu(this);
        this.DüngerForm.SetInfoView(true);
        
        DB getDuenger = new DB();
    
        try {
            Duenger d = getDuenger.getDuengerInfo(String.valueOf(CBDuenger.getSelectedItem()));
            this.DüngerForm.SetDuengerData(d);
        } 
        catch (Exception ex) {System.err.println(ex.getMessage());}
        
        this.DüngerForm.setVisible(true);
        }
    }//GEN-LAST:event_LblInfMouseClicked
/**
 * Opens the Frame where a new Duenger can be entered when the entry <neu> is selected
 */
    private void CBDuengerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBDuengerActionPerformed
   if(this.CBDuenger.getSelectedIndex()==this.CBDuenger.getItemCount()-1 && this.DüngerForm==null)
        {
        this.DüngerForm = new DüngerNeu(this);
        this.SetEditable(false);
        this.DüngerForm.setVisible(true);
        } 
    }//GEN-LAST:event_CBDuengerActionPerformed
/**
 * to close all childForms clean when the ParentForm is to be closed
 */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    if(this.DüngerForm!=null)
        {
        if(this.ParentForm.showConfirmDialog("Neuer Dünger"))
            {
            this.CleanClose();
            this.DüngerForm.CleanClose();
            }
        }
    else
        {if(this.ParentForm.AskClosing()){this.CleanClose();}} 
    }//GEN-LAST:event_formWindowClosing
/**
 * adds Bewaesserung to the table and into the database
 * @exception if the Bewaesserung cant be added into the Database it shall be in the Table
 */
 private void addBewaesserung(){
             Bewaesserung bw = new Bewaesserung(EreignissID, (Date)this.SpinDatDuen.getValue(),(int)(this.SpinMB.getValue()));
        try {bw.saveInDB();} 
        catch (Exception ex) {Logger.getLogger(Ereignisse.class.getName()).log(Level.SEVERE, null, ex);}
        
        DefaultTableModel deft=(DefaultTableModel)this.TblEreignisse.getModel();
        deft.addRow(new Object[] {myformatter.format((Date)this.SpinDatB.getValue()),"Bewässerung","/", SpinMB.getValue(), "/" }); 
 }    
/**
 * Indicates and adds Hohe/Duengevorgang/Bewaesserung
 * @param name the name of the used Duenger 
 */    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int openTab=this.TabbedPane.getSelectedIndex();
        // Indicate Tabs
        switch(openTab){
            case 0: this.addHoehe(); break;
            case 1: this.addDuengevorgang();break;
            case 2: this.addBewaesserung(); break;
            default: System.err.println("Tab unbekannt");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
    this.CleanClose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void BtnMouseEnteredSetColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMouseEnteredSetColor
    evt.getComponent().setBackground(new Color(177,47,46));
    }//GEN-LAST:event_BtnMouseEnteredSetColor

    private void BtnMouseExitedSetColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMouseExitedSetColor
    evt.getComponent().setBackground(null);
    }//GEN-LAST:event_BtnMouseExitedSetColor
/**
 * sets the name of Duenger
 * @param name the name of the used Duenger 
 */
    public  void setDünger(String name)
    {this.CBDuenger.setSelectedItem(name);}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CBDuenger;
    private javax.swing.JLabel LblCm;
    private javax.swing.JLabel LblCm1;
    private javax.swing.JLabel LblCmB;
    private javax.swing.JLabel LblD;
    private javax.swing.JLabel LblDM;
    private javax.swing.JLabel LblDMB;
    private javax.swing.JLabel LblDateD;
    private javax.swing.JLabel LblDateD1;
    private javax.swing.JLabel LblDateH;
    private javax.swing.JLabel LblH;
    private javax.swing.JLabel LblInf;
    private javax.swing.JPanel PanelBewässerung;
    private javax.swing.JPanel PanelDünger;
    private javax.swing.JPanel PanelMessung;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JSpinner SpinDatB;
    private javax.swing.JSpinner SpinDatDuen;
    private javax.swing.JSpinner SpinDatMess;
    private javax.swing.JSpinner SpinH;
    private javax.swing.JSpinner SpinM;
    private javax.swing.JSpinner SpinMB;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JTable TblEreignisse;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnExit;
    // End of variables declaration//GEN-END:variables

 
}
