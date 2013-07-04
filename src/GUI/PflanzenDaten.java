package GUI;

import DB.DB;
import DataStructur.Art;
import DataStructur.Sorte;
import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;

/**
 *
 * @author Team ChiDaBa
 */
public final class PflanzenDaten extends javax.swing.JDialog  {
    
    public Chilliliste ParentForm;
    Object PlantID; // indicates new / info
    Object ArtID=null;
    private SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy.MM.dd");
    public boolean InfoView=false;
    public boolean neuView = false;
    public boolean loaded = false;
    
    DefaultListCellRenderer renderer = new DefaultListCellRenderer()
        {
        @Override
        public void paint(Graphics g) 
            {
            setForeground(Color.BLACK);
            super.paint(g);
            }
        };
    
    /**
     * Creates new form Zusatzinformationen
     */
    public PflanzenDaten(Chilliliste parent, Object PlantID) throws Exception { 
        this.ParentForm=parent;
        this.PlantID=PlantID;
        initComponents();
        
        // "Look and feel":
        setIconImage(getToolkit().getImage("src/ICONS/Icon.png"));
        this.InfoView=true;
        this.setInfoView(InfoView);    
        this.SetDisabledComponentsReadable();

        // load content;
        loadCBboxes();
        setAttributeFields();

        // set frame titel:
        String name = this.CBSorte.getSelectedItem()+"_"+this.CBArt.getSelectedItem();
        this.setTitle("Informationen von \"" + name + "\n:");
    }
    
    // Konstruktor für "neu"
    public PflanzenDaten(Chilliliste parent) throws Exception {
        setIconImage(getToolkit().getImage("src/ICONS/Icon.png"));
        this.ParentForm=parent;
        initComponents();          
        this.SetDisabledComponentsReadable();
        loadCBboxes();
        this.neuView=true;
        setNeuView();
    }
    
    public void setNeuView(){
        this.CheckBox.setVisible(false);
        this.BtnReset.setVisible(false);
        this.BtnDel.setVisible(false);
        this.lblViewStateIcon.setVisible(false);
   }
            
    
    public ArrayList getPflanzenDatenObjekt(Object PlantID) throws Exception {
        DB con =new DB();
        return con.getPlantAttributes(PlantID);
    }
    
    public void setAttributeFields() throws Exception {
    // get Attributes from DB:
    ArrayList daten=getPflanzenDatenObjekt(PlantID);
    
    // set AttributeFields:
    this.TxtName.setText(String.valueOf(daten.get(0)));
    this.CBSorte.setSelectedItem(daten.get(1));
    this.CBArt.setSelectedItem(daten.get(2));
    this.CBTopfgröße.setSelectedItem(daten.get(3));
    this.CBHerkunft.setSelectedItem(daten.get(4));
    this.BtnColorChoose.setBackground(new Color(Integer.parseInt(String.valueOf(daten.get(5)))));
    this.SpinScoville.setValue(daten.get(6));
    this.TxtGrad.setText(String.valueOf(daten.get(7)));
    this.SpinReifPfl.setValue(daten.get(8));
    this.SpinReifSort.setValue(daten.get(9));
    this.SpinZeit.setValue(daten.get(10));
    this.SpinReifErtragGw.setValue(daten.get(11));
    this.SpinReifErtragStk.setValue(daten.get(12));
    this.SpinDatAussaat.setValue(new SimpleDateFormat("dd.MM.yyyy").parse(String.valueOf(daten.get(13))));
    this.SpinDatKeimung.setValue(new SimpleDateFormat("dd.MM.yyyy").parse(String.valueOf(daten.get(14))));
    }
    
    public final void loadCBboxes() throws Exception
    {
    setSorteList();
    setHerkunftList();
    setArtList();
    setTopfgroesseList();   
    }
    
    public void setSorteList() throws Exception{    
    DB con= new DB();
    ArrayList names = con.getList("sorte", "tbl_sorte");
    updateCB(CBSorte, names);
    }
    
    public void setArtList() throws Exception{    
    DB con= new DB();
    ArrayList names = con.getList("art", "tbl_art");
    updateCB(CBArt, names);
    }
    
    public void setTopfgroesseList() throws Exception{    
    DB con= new DB();
    ArrayList names = con.getList("topf_gr", "tbl_topf");
    updateCB(CBTopfgröße, names);
    }

    public void setHerkunftList() throws Exception{    
    DB con= new DB();
    ArrayList names = con.getList("herkunft", "tbl_herkunft");
    updateCB(CBHerkunft, names);
    }  
    
    public void updateCB(JComboBox t, ArrayList upToDate)
        {
        DefaultComboBoxModel model = (DefaultComboBoxModel) t.getModel();

        for(Object e : upToDate.toArray()){
            if(model.getIndexOf(e)==-1)
                {model.insertElementAt(e, upToDate.indexOf(e));}
            }   

    model.setSelectedItem(model.getElementAt(0));
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

        PanNeu = new javax.swing.JPanel();
        LblInfo = new javax.swing.JLabel();
        InfoPanel = new javax.swing.JPanel();
        LblName = new javax.swing.JLabel();
        LblSorte = new javax.swing.JLabel();
        LblArt = new javax.swing.JLabel();
        LblScoville = new javax.swing.JLabel();
        LblGrad = new javax.swing.JLabel();
        LblFarbe = new javax.swing.JLabel();
        LblReifPfl = new javax.swing.JLabel();
        LblReifPflTag = new javax.swing.JLabel();
        LblReifSort = new javax.swing.JLabel();
        LblReifSortTag = new javax.swing.JLabel();
        LblErtragGw = new javax.swing.JLabel();
        LblErtragStk = new javax.swing.JLabel();
        LblHerkunft = new javax.swing.JLabel();
        LblGesZeit = new javax.swing.JLabel();
        LblGesZeitTag = new javax.swing.JLabel();
        LblDatumAussaat = new javax.swing.JLabel();
        LblDatumKeimung = new javax.swing.JLabel();
        LblTopfgröße = new javax.swing.JLabel();
        TxtName = new javax.swing.JTextField();
        SpinScoville = new javax.swing.JSpinner();
        SliderGrad = new javax.swing.JSlider();
        TxtGrad = new javax.swing.JTextField();
        SpinReifPfl = new javax.swing.JSpinner();
        SpinReifSort = new javax.swing.JSpinner();
        SpinReifErtragGw = new javax.swing.JSpinner();
        SpinReifErtragStk = new javax.swing.JSpinner();
        CBHerkunft = new javax.swing.JComboBox();
        SpinZeit = new javax.swing.JSpinner();
        BtnColorChoose = new javax.swing.JButton();
        SpinDatAussaat = new javax.swing.JSpinner();
        SpinDatKeimung = new javax.swing.JSpinner();
        CBTopfgröße = new javax.swing.JComboBox();
        CBSorte = new javax.swing.JComboBox();
        CBArt = new javax.swing.JComboBox();
        lblEditReifeSort = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BtnSave = new javax.swing.JButton();
        CheckBox = new javax.swing.JCheckBox();
        BtnReset = new javax.swing.JButton();
        BtnDel = new javax.swing.JButton();
        BtnAbbr = new javax.swing.JButton();
        lblViewStateIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PanNeu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LblInfo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Icon.png"))); // NOI18N
        LblInfo.setText("Bitte tragen Sie hier Ihre Informationen ein:");

        javax.swing.GroupLayout PanNeuLayout = new javax.swing.GroupLayout(PanNeu);
        PanNeu.setLayout(PanNeuLayout);
        PanNeuLayout.setHorizontalGroup(
            PanNeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanNeuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanNeuLayout.setVerticalGroup(
            PanNeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        InfoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LblName.setText("Name:");

        LblSorte.setText("Sorte:");

        LblArt.setText("Art:");

        LblScoville.setText("Scoville:");

        LblGrad.setText("Schärfegrad:");

        LblFarbe.setText("Farbe:");

        LblReifPfl.setText("Reifezeit Pflanze:");

        LblReifPflTag.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblReifPflTag.setText("Tag");

        LblReifSort.setText("Reifezeit Sorte:");

        LblReifSortTag.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblReifSortTag.setText("Tag");
        LblReifSortTag.setToolTipText("");

        LblErtragGw.setText("Ertrag (Gramm):");

        LblErtragStk.setText("Ertrag (Stück):");

        LblHerkunft.setText("Herkunft:");

        LblGesZeit.setText("Gesamtzeit");

        LblGesZeitTag.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblGesZeitTag.setText("Tag");
        LblGesZeitTag.setToolTipText("");

        LblDatumAussaat.setText("Datum Aussaat:");

        LblDatumKeimung.setText("Datum Keimung:");

        LblTopfgröße.setText("Topfgröße:");

        SpinScoville.setModel(new javax.swing.SpinnerNumberModel(0, 0, 16000000, 1));
        SpinScoville.setName("SpinScoville"); // NOI18N

        SliderGrad.setMaximum(10);
        SliderGrad.setValue(5);

        TxtGrad.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, SliderGrad, org.jdesktop.beansbinding.ELProperty.create("${value}"), TxtGrad, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        TxtGrad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtGradActionPerformed(evt);
            }
        });

        SpinReifPfl.setModel(new javax.swing.SpinnerNumberModel(1, 1, 365, 1));
        SpinReifPfl.setToolTipText("");
        SpinReifPfl.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinReifPflStateChanged(evt);
            }
        });

        SpinReifSort.setModel(new javax.swing.SpinnerNumberModel(1, 1, 365, 1));
        SpinReifSort.setToolTipText("");
        SpinReifSort.setEnabled(false);
        SpinReifSort.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinReifSortStateChanged(evt);
            }
        });

        SpinReifErtragGw.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10000, 1));
        SpinReifErtragGw.setToolTipText("");
        SpinReifErtragGw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SpinReifErtragGwMouseClicked(evt);
            }
        });
        SpinReifErtragGw.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinReifErtragGwStateChanged(evt);
            }
        });

        SpinReifErtragStk.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10000, 1));
        SpinReifErtragStk.setToolTipText("");
        SpinReifErtragStk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SpinReifErtragStkMouseClicked(evt);
            }
        });
        SpinReifErtragStk.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinReifErtragStkStateChanged(evt);
            }
        });

        CBHerkunft.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<neues Land>" }));
        CBHerkunft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBHerkunftActionPerformed(evt);
            }
        });

        SpinZeit.setModel(new javax.swing.SpinnerNumberModel(1, 1, 365, 1));
        SpinZeit.setToolTipText("");
        SpinZeit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SpinZeitMouseClicked(evt);
            }
        });
        SpinZeit.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinZeitStateChanged(evt);
            }
        });

        BtnColorChoose.setText(" ");
        BtnColorChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnColorChooseActionPerformed(evt);
            }
        });

        SpinDatAussaat.setModel(new javax.swing.SpinnerDateModel());
        SpinDatAussaat.setEditor(new javax.swing.JSpinner.DateEditor(SpinDatAussaat, "dd.MM.yyyy"));
        SpinDatAussaat.setToolTipText("");
        SpinDatAussaat.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinDatAussaatStateChanged(evt);
            }
        });

        SpinDatKeimung.setModel(new javax.swing.SpinnerDateModel());
        SpinDatKeimung.setEditor(new javax.swing.JSpinner.DateEditor(SpinDatKeimung, "dd.MM.yyyy"));
        SpinDatKeimung.setToolTipText("");

        CBTopfgröße.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Neue größe>" }));
        CBTopfgröße.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBTopfgrößeActionPerformed(evt);
            }
        });

        CBSorte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<neue Sorte>" }));
        CBSorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBSorteActionPerformed(evt);
            }
        });

        CBArt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<neue Art>" }));
        CBArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBArtActionPerformed(evt);
            }
        });

        lblEditReifeSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/edit.png"))); // NOI18N
        lblEditReifeSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditReifeSortMouseClicked(evt);
            }
        });

        BtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/save_24.png"))); // NOI18N
        BtnSave.setText("Speichern");
        BtnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnSave.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        BtnSave.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMouseEnteredSetColor(evt);
            }
        });
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        CheckBox.setText("Bearbeiten");
        CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxActionPerformed(evt);
            }
        });

        BtnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/arrow_circle_left_24.png"))); // NOI18N
        BtnReset.setText("Zurücksetzen");
        BtnReset.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        BtnReset.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMouseEnteredSetColor(evt);
            }
        });
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });

        BtnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/trash_24.png"))); // NOI18N
        BtnDel.setText("Löschen");
        BtnDel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        BtnDel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnDel.setVerifyInputWhenFocusTarget(false);
        BtnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMouseEnteredSetColor(evt);
            }
        });
        BtnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDelActionPerformed(evt);
            }
        });

        BtnAbbr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/cancel_24.png"))); // NOI18N
        BtnAbbr.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        BtnAbbr.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnAbbr.setLabel("Abbrechen");
        BtnAbbr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMouseExitedSetColor(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMouseEnteredSetColor(evt);
            }
        });
        BtnAbbr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAbbrActionPerformed(evt);
            }
        });

        lblViewStateIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/app_48.png"))); // NOI18N
        lblViewStateIcon.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/app_lock_48.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(CheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblViewStateIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(BtnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAbbr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblViewStateIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnAbbr, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout InfoPanelLayout = new javax.swing.GroupLayout(InfoPanel);
        InfoPanel.setLayout(InfoPanelLayout);
        InfoPanelLayout.setHorizontalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LblTopfgröße, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblArt)
                            .addComponent(LblSorte)
                            .addComponent(LblScoville)
                            .addComponent(LblGrad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblName)
                            .addComponent(LblFarbe))
                        .addGap(6, 6, 6)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SpinScoville, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addComponent(SliderGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(TxtGrad))
                            .addComponent(TxtName)
                            .addComponent(BtnColorChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CBTopfgröße, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CBSorte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CBArt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(LblReifPfl, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(LblGesZeit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LblReifSort, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(LblErtragGw, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LblErtragStk, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LblHerkunft, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblDatumAussaat, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(LblDatumKeimung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEditReifeSort)
                .addGap(6, 6, 6)
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SpinDatAussaat, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpinDatKeimung, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBHerkunft, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpinReifErtragGw, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addComponent(SpinReifPfl, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblReifPflTag, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addComponent(SpinReifSort, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblReifSortTag, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addComponent(SpinZeit, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblGesZeitTag, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SpinReifErtragStk, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        InfoPanelLayout.setVerticalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblName))
                                .addGap(12, 12, 12)
                                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CBSorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblSorte))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CBArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblArt)))
                            .addComponent(LblReifPfl))
                        .addGap(12, 12, 12)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblScoville)
                            .addComponent(SpinScoville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblGrad)
                            .addComponent(TxtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SliderGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblFarbe)
                            .addComponent(BtnColorChoose))
                        .addGap(12, 12, 12)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBTopfgröße, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblTopfgröße)))
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEditReifeSort, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SpinReifPfl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblReifPflTag))
                                .addGap(12, 12, 12)
                                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LblReifSortTag)
                                    .addComponent(SpinReifSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblReifSort))))
                        .addGap(12, 12, 12)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SpinZeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblGesZeitTag)
                            .addComponent(LblGesZeit))
                        .addGap(9, 9, 9)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblErtragGw)
                            .addComponent(SpinReifErtragGw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SpinReifErtragStk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblErtragStk))
                        .addGap(12, 12, 12)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBHerkunft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblHerkunft))
                        .addGap(9, 9, 9)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblDatumAussaat)
                            .addComponent(SpinDatAussaat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SpinDatKeimung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblDatumKeimung))))
                .addGap(20, 20, 20))
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(InfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanNeu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(PanNeu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(InfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SetDisabledComponentsReadable()
    {
    // ComboBoxes with own renderer: 
    this.CBArt.setRenderer(renderer);
    this.CBHerkunft.setRenderer(renderer);
    this.CBSorte.setRenderer(renderer);
    this.CBTopfgröße.setRenderer(renderer);

    //Spinner with own Method: SetSpinnerDisablesTextColor
    this.SetSpinnerDisablesTextColor(this.SpinDatAussaat, Color.BLACK);
    this.SetSpinnerDisablesTextColor(this.SpinDatKeimung, Color.BLACK);
    this.SetSpinnerDisablesTextColor(this.SpinReifErtragGw, Color.BLACK);
    this.SetSpinnerDisablesTextColor(this.SpinReifErtragStk, Color.BLACK);
    this.SetSpinnerDisablesTextColor(this.SpinReifPfl, Color.BLACK);
    this.SetSpinnerDisablesTextColor(this.SpinReifSort, Color.BLACK);
    this.SetSpinnerDisablesTextColor(this.SpinScoville, Color.BLACK);
    this.SetSpinnerDisablesTextColor(this.SpinZeit, Color.BLACK);
    

    }
    
    private void SetSpinnerDisablesTextColor(JSpinner spinner, Color color)
    {((DefaultEditor)spinner.getEditor()).getTextField().setDisabledTextColor(color);}
    
    public void CleanClose() // not the best way :-(
    {
    this.dispose();
    this.ParentForm.ZusatzFrame=null; // because dispose
    this.ParentForm.SetEditable(true);   
    }    
    
    private void setInfoView(boolean b)
    {       
    this.BtnSave.setEnabled(!b);
    this.BtnDel.setEnabled(!b);
    this.BtnReset.setEnabled(!b);
    this.CBArt.setEnabled(!b);    
    this.CBSorte.setEnabled(!b);
    this.CBHerkunft.setEnabled(false);
    this.CBTopfgröße.setEnabled(!b);
    this.SliderGrad.setEnabled(!b);
    this.SpinDatAussaat.setEnabled(!b);
    this.SpinDatKeimung.setEnabled(!b);
    this.SpinReifErtragGw.setEnabled(!b);
    this.SpinReifErtragStk.setEnabled(!b);
    this.SpinReifPfl.setEnabled(!b);
    this.SpinReifSort.setEnabled(false);
    this.SpinScoville.setEnabled(!b);
    this.SpinZeit.setEnabled(!b);
    this.TxtGrad.setEditable(!b);
    this.TxtName.setEditable(false);
    this.BtnColorChoose.setFocusable(!b);
    this.lblEditReifeSort.setEnabled(!b);
    this.lblViewStateIcon.setEnabled(!b);
    }
    
    private boolean CbErrorCheck(){
    boolean state = true;
    if(this.CBSorte.getSelectedIndex()==this.CBSorte.getItemCount()-1) {
        CBSorte.setBackground(Color.red);
        state = false;
    }
    
    if(this.CBArt.getSelectedIndex()==this.CBArt.getItemCount()-1) {
        CBArt.setBackground(Color.red);
        state = false;
    }
    
    if(this.CBHerkunft.getSelectedIndex()==this.CBHerkunft.getItemCount()-1) {
        CBHerkunft.setBackground(Color.red);
        state = false;
    }
    
    if(this.CBTopfgröße.getSelectedIndex()==this.CBTopfgröße.getItemCount()-1) {
        CBTopfgröße.setBackground(Color.red);
        state = false;
    }
    
    return state;
    }
    
    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        Object sorte = this.CBSorte.getSelectedItem();
        Object art = this.CBArt.getSelectedItem();
        boolean cbError = CbErrorCheck();  
        DB con = new DB(); 
        
        try {
            int existID =con.CheckPlantExist(sorte, art);
            // Wenn alle Eingaben korrekt sind:
            if (cbError && (existID==-1 || existID==this.PlantID)){
                // Wenn es sich um eine neue Chili handelt:
                if (this.neuView) {
                    UpdateHerkunft();
                    int SorteID = con.getSorteID(new Sorte(String.valueOf(this.CBSorte.getSelectedItem())));
                    // erstelle neue Chili:
                    this.PlantID = con.NeuePflanze((int) ArtID, SorteID);  
                }
            
                // ändere bzw setze Daten:
                UpdateSorteReifezeit();
                UpdatePflanzenDaten();
                UpdateAttributes();

                // Update Chilliliste View:
                this.ParentForm.writeTblToTblChilli();
                
               
            
                // Falls eine neue Chili erstellt wurde:
                if (this.neuView) {
                    this.CleanClose();
                } 
        
                // Falls eine Chili bearbeitet wurde:
                else {
                    this.CheckBox.setSelected(false);
                    this.setInfoView(true);
                }
            } 
            // Falls ein Fehler auftrat:
            else {
                // Falls falscher Wert in Combobox:
                if(!cbError){
                JOptionPane.showMessageDialog(this,"Ungültige(r) Wert(e)","Eingabe Fehler", JOptionPane.ERROR_MESSAGE);   
                }
                // Falls diese Pflanze bereits existiert:
                else{
                JOptionPane.showMessageDialog(
                        this,"Die Kombination: \"" + String.valueOf(sorte) 
                        + "\" und \"" + String.valueOf(art) + "\" existiert bereits"
                        ,"Eingabe Fehler", JOptionPane.ERROR_MESSAGE);    
                
                // Highlight values 
                this.CBArt.setBackground(Color.red);
                this.CBSorte.setBackground(Color.red);
                }
            }     
        }          
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
       if (this.neuView) {
        this.ParentForm.setButtons(false);
       }
    }//GEN-LAST:event_BtnSaveActionPerformed

    public void UpdateAttributes() throws Exception{            
    }
    public void UpdatePflanzenDaten() throws Exception{
        DB con = new DB();
        
        // hole Fremdschlüssel:
        Object topf_fk=con.getTopfID(this.CBTopfgröße.getSelectedItem());
        Object ID = con.getPflanzenDaten_FK(PlantID);
        
        // sammle daten in ArrayList:
        ArrayList daten = new ArrayList();
        daten.add(this.SpinScoville.getValue());                                    // Scoville
        daten.add(this.TxtGrad.getText());                                          // Schärfegrad
        daten.add(Integer.toString(this.BtnColorChoose.getBackground().getRGB()));  // Color
        daten.add(topf_fk);                                                         // Topf_fk
        daten.add(this.SpinReifPfl.getValue());                                     // Reifezeit Pflanze
        daten.add(this.SpinZeit.getValue());                                        // Gesamtzeit
        daten.add(this.SpinReifErtragGw.getValue());                                // Ertrag in g
        daten.add(this.SpinReifErtragStk.getValue());                               // Ertrag in Stück
        daten.add(ID);                                                              // Pflanzen Daten ID
        
        con.UpdatePflanzenDaten(daten);
        
        // Datum Aussat und Keimung Speichern:
        ID = con.getEreigniss_fk(PlantID);
        daten.clear();
        daten.add(this.SpinDatAussaat.getValue());
        daten.add(this.SpinDatKeimung.getValue());
        daten.add(ID); 
        
        con.UpdateEreignisse(daten);
    }
  
    
    public void UpdateHerkunft() throws Exception{
        // Update Art:
        String art = String.valueOf(this.CBArt.getSelectedItem());
        String herkunft = String.valueOf(this.CBHerkunft.getSelectedItem());
        
        Art a = new Art(art, herkunft);
        // falls bereits vergeben:
        DB con = new DB();
        
        this.ArtID = a.getExistArtID();
        if(ArtID==-1){
        a.saveInDB();
        ArtID = a.getArtID();
        }
        // Speicher ID in tblPflanzen
        con.UpdateFKinPflanzen("art_fk", (int) ArtID, PlantID);        
    }
 
    public void UpdateSorteReifezeit() throws Exception{
        // Update Sorte:
        Sorte s = new Sorte(String.valueOf(this.CBSorte.getSelectedItem()));
        int SortID= s.getSorteID();
        // Falls Reifezeit verändert wurde:
        if(s.getReifezeit()!=(int)this.SpinReifSort.getValue()){
            DB con = new DB();
            con.UpdateSorteReifezeit(SortID, (int)this.SpinReifSort.getValue());
        }
        // Speicher SortID in tblPflanzen
        DB con = new DB();
        con.UpdateFKinPflanzen("sorte_fk", SortID, PlantID);
    }   
    
    private void BtnAbbrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbbrActionPerformed
        if (!this.InfoView) {
            if (this.ParentForm.AskClosing()) {
                this.CleanClose();
            }
        } 
        else {
            this.CleanClose();
        }
    }//GEN-LAST:event_BtnAbbrActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    if(this.ParentForm.AskClosing())
        {this.CleanClose();}
    }//GEN-LAST:event_formWindowClosing

    private void BtnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDelActionPerformed
    int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Möchten Sie diesen Datensatz wirklich vollständig löschen?", "Warnung",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
    if(showConfirmDialog==0)
        {
        DB con = new DB();
        
        try {
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
            this.ParentForm.writeTblToTblChilli();
            
            // Form schließen
            this.CleanClose();
        } 
        
        catch (Exception ex) {System.err.println(ex.getMessage());}       
        
        
        }
    
    else {}
    
    
    }//GEN-LAST:event_BtnDelActionPerformed

    private void TxtGradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtGradActionPerformed

    }//GEN-LAST:event_TxtGradActionPerformed

    private void SpinReifPflStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinReifPflStateChanged
    if(this.SpinReifPfl.getValue()==1)
        this.LblReifPflTag.setText("Tag");
    
    else
       this.LblReifPflTag.setText("Tage"); 
    }//GEN-LAST:event_SpinReifPflStateChanged

    private void SpinReifSortStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinReifSortStateChanged
    if(this.SpinReifSort.getValue()==1)
        this.LblReifSortTag.setText("Tag");
    
    else
       this.LblReifSortTag.setText("Tage"); 
    }//GEN-LAST:event_SpinReifSortStateChanged

    private void SpinReifErtragGwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SpinReifErtragGwMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SpinReifErtragGwMouseClicked

    private void SpinReifErtragGwStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinReifErtragGwStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SpinReifErtragGwStateChanged

    private void SpinReifErtragStkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SpinReifErtragStkMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SpinReifErtragStkMouseClicked

    private void SpinReifErtragStkStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinReifErtragStkStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SpinReifErtragStkStateChanged

    private void CBHerkunftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBHerkunftActionPerformed
        // set default Background color
        this.CBHerkunft.setBackground(null);
        
        // Aufruf der statischen Methode showConfirmDialog()
        if(this.CBHerkunft.getSelectedIndex()==this.CBHerkunft.getItemCount()-1){    
            
            // Texfeld für das JOptionPane erstellen    
            JTextField herkunft = new JTextField();

            // Objekte für das JOptionPane
            Object[] message = {"Herkunftsland:", herkunft};

            // JOptionPane erstellen 
            JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
            pane.createDialog(this, "Herkunft").setVisible(true);

            try{
                // falls der eintrag nicht existiert    
                if(((DefaultComboBoxModel)(CBHerkunft.getModel())).getIndexOf(herkunft.getText())==-1){
                    // Eingaben überprüfen:
                    if(herkunft.getText().isEmpty()){this.CBHerkunft.setSelectedIndex(0);}

                else
                    {
                        // neue Herkunft in die db eintragen:
                        DB con = new DB();
                        con.InsertIntoHerkunft(herkunft.getText());
                        this.CBHerkunft.insertItemAt(herkunft.getText(), this.CBHerkunft.getItemCount()-1);
                        this.CBHerkunft.setSelectedItem(herkunft.getText());
                    }        
                }
                // falls der eintrag existiert    
                else {JOptionPane.showMessageDialog(this, "Herkunft bereits vorhanden", "Error", JOptionPane.ERROR_MESSAGE);}
            }

            catch(Exception e){System.err.println(e.getMessage());}
        }  
    }//GEN-LAST:event_CBHerkunftActionPerformed
       
    private void SpinZeitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SpinZeitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SpinZeitMouseClicked

    private void SpinZeitStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinZeitStateChanged
    if(this.SpinZeit.getValue()==1)
        this.LblGesZeitTag.setText("Tag");
    
    else
       this.LblGesZeitTag.setText("Tage"); 
    }//GEN-LAST:event_SpinZeitStateChanged

    private void BtnColorChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnColorChooseActionPerformed
        if (!this.InfoView) {
            Color newColor = JColorChooser.showDialog(this, "Wähle Sie eine Farbe", this.BtnColorChoose.getBackground());
            this.BtnColorChoose.setBackground(newColor);
        }
    }//GEN-LAST:event_BtnColorChooseActionPerformed

    private void SpinDatAussaatStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinDatAussaatStateChanged
        this.SpinDatKeimung.setValue(this.SpinDatAussaat.getNextValue());
        this.SpinDatKeimung.setModel(new javax.swing.SpinnerDateModel((Date) this.SpinDatAussaat.getNextValue(), (Comparable) this.SpinDatAussaat.getValue(), null, java.util.Calendar.DAY_OF_MONTH));
    }//GEN-LAST:event_SpinDatAussaatStateChanged

    private void CBTopfgrößeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTopfgrößeActionPerformed
        // set default Background color
        this.CBTopfgröße.setBackground(null);
        
        if(this.CBTopfgröße.getSelectedIndex()==this.CBTopfgröße.getItemCount()-1){    
            // Texfeld für das JOptionPane erstellen    
            JTextField groesse = new JTextField();


            // Objekte für das JOptionPane
            Object[] message = {"Größenbezeichnung:", groesse};

            // JOptionPane erstellen 
            JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
            pane.createDialog(this, "Topfgröße").setVisible(true);

            try{
                // falls der eintrag nicht existiert    
                if(((DefaultComboBoxModel)(CBTopfgröße.getModel())).getIndexOf(groesse.getText())==-1){
                    // Eingaben überprüfen:
                    if(groesse.getText().isEmpty())
                        {this.CBTopfgröße.setSelectedIndex(0);}

                else
                    {
                        // neue Größe in die db eintragen:
                        DB con = new DB();
                        con.InsertIntoTopfGr(groesse.getText());
                        
                        this.CBTopfgröße.insertItemAt(groesse.getText(), this.CBTopfgröße.getItemCount()-1);
                        this.CBTopfgröße.setSelectedItem(groesse.getText());
                    }        
                }
                // falls der eintrag existiert    
                else {JOptionPane.showMessageDialog(this, "Topfgröße bereits vorhanden", "Error", JOptionPane.ERROR_MESSAGE);}
            }

            catch(Exception e){System.err.println(e.getMessage());}

        }    
    }//GEN-LAST:event_CBTopfgrößeActionPerformed

    private void CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxActionPerformed
        if(CheckBox.isSelected())
        {
            this.CheckBox.setSelected(false);
            int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Möchten Sie sich wirklich Einträge editieren/löschen?", "Schreibberechtigung",JOptionPane.YES_NO_OPTION ,JOptionPane.WARNING_MESSAGE);
            if(showConfirmDialog==0)
                {
                this.InfoView=false;    
                this.setInfoView(InfoView);
                this.CheckBox.setSelected(true);
                }

            else
            {this.CheckBox.setSelected(false);}
        }

        else
        {
            this.CheckBox.setSelected(true);
            int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Nicht gespeicherte Einträge werden zurückgesetzt", "Schreibberechtigung",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
            if(showConfirmDialog==0){
                try {this.setAttributeFields();} 
                catch (Exception ex) {System.err.println(ex.getMessage());}
                this.InfoView=true;
                this.setInfoView(InfoView);
                this.CheckBox.setSelected(false);
            }

            else
            {this.CheckBox.setSelected(true);}
        }   
    }//GEN-LAST:event_CheckBoxActionPerformed

    public void setNameUpdate(){
    String name = this.CBSorte.getSelectedItem()+"_"+this.CBArt.getSelectedItem();
    this.TxtName.setText(name);
    this.setTitle("Informationen von \"" + name + "\n:");
    }
    
    private void CBSorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBSorteActionPerformed
        // set default Background color
        this.CBSorte.setBackground(null);
        
        Sorte s=new Sorte(null,0);
        // Falls letzter eintrag <neue Sorte> ausgewählt:
        if(this.CBSorte.getSelectedIndex()==this.CBSorte.getItemCount()-1){
            // Texfeld und Spinner für das JOptionPane erstellen    
            JTextField sorte = new JTextField();
            JSpinner reifezeit = new JSpinner();
            reifezeit.setModel(this.SpinReifSort.getModel());

            // Objekte für das JOptionPane
            Object[] message = {"Sortenname:", sorte,"Reifezeit", reifezeit};

            // JOptionPane erstellen 
            JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
            pane.createDialog(this, "Neue Sorte").setVisible(true);


            try{
                // falls sortenname nicht existiert    
                if(((DefaultComboBoxModel)(CBSorte.getModel())).getIndexOf(sorte.getText())==-1){
                    // Eingaben überprüfen:
                    if(sorte.getText().isEmpty() || reifezeit.getValue()==null)
                        {//this.CBSorte.setSelectedIndex(0);}
                        {this.CBSorte.setSelectedIndex(0);}    
                        }
                    else
                        {  
                        s = new Sorte(sorte.getText(), (int) reifezeit.getValue());
                        try {
                            s.saveInDB();
                            this.CBSorte.insertItemAt(sorte.getText(), this.CBSorte.getItemCount()-1);
                            this.CBSorte.setSelectedItem(sorte.getText());                        
                        } 

                        catch (Exception ex) {System.err.println(ex.getMessage());}
                        }        

                }
            // falls der sortenname existiert    
            else {JOptionPane.showMessageDialog(this, "Sorte bereits vorhanden", "Error", JOptionPane.ERROR_MESSAGE);}
            }
        catch(Exception e){System.err.println(e.getMessage());}
        } 
        
        // falls ein existierender Eintrag gewählt wurde:
        else{
            try {s = new Sorte(String.valueOf(CBSorte.getSelectedItem()));}
            catch (Exception ex) {System.err.println(ex.getMessage());}       
        }
    this.SpinReifSort.setValue(s.getReifezeit());
    setNameUpdate();     
    }//GEN-LAST:event_CBSorteActionPerformed

    private void CBArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBArtActionPerformed
        // set default Background color
        this.CBArt.setBackground(null);
        // Falls letzter eintrag <neue Art> ausgewählt:
        if(this.CBArt.getSelectedIndex()==this.CBArt.getItemCount()-1){   
            // Texfelder für das JOptionPane erstellen    
            JTextField art = new JTextField();

            // Objekte für das JOptionPane
            Object[] message = {"Artenname:", art};

            // JOptionPane erstellen 
            JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
            pane.createDialog(this, "Art").setVisible(true);

            try{
                // falls der eintrag nicht existiert    
                if(((DefaultComboBoxModel)(CBArt.getModel())).getIndexOf(art.getText())==-1){
                    // Eingaben überprüfen:
                    if(art.getText().isEmpty())
                        {this.CBArt.setSelectedIndex(0);}
                else{  
                    this.CBArt.insertItemAt(art.getText(), this.CBArt.getItemCount()-1);
                    this.CBArt.setSelectedItem(art.getText());
                    }     

                }
                // falls der eintrag existiert    
                else {JOptionPane.showMessageDialog(this, "Art bereits vorhanden", "Error", JOptionPane.ERROR_MESSAGE);}
            }
            catch(Exception e){System.err.println(e.getMessage());}
        } 
        else {
        } 
    setNameUpdate();      
    }//GEN-LAST:event_CBArtActionPerformed

    private void lblEditReifeSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditReifeSortMouseClicked
        if(!this.SpinReifSort.isEnabled() && !this.InfoView){
            int eingabe = JOptionPane.showConfirmDialog(this,
                        "Möchten Sie das Reifezeit für die gesamte Sorte: \""+this.CBSorte.getSelectedItem()+"\" ändern?",
                        "Diese Reifezeit ist sortenbezogen",
                        JOptionPane.YES_NO_OPTION);

        if(eingabe==0){this.SpinReifSort.setEnabled(true);}
        if(eingabe==1){this.SpinReifSort.setEnabled(false);}
        }
    }//GEN-LAST:event_lblEditReifeSortMouseClicked

    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
    if(this.ParentForm.AskClosing()){
        try {this.setAttributeFields();} 
        catch (Exception ex) {System.err.println(ex.getMessage());}
        }
    }//GEN-LAST:event_BtnResetActionPerformed

    private void BtnMouseExitedSetColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMouseExitedSetColor
    evt.getComponent().setBackground(null);
    }//GEN-LAST:event_BtnMouseExitedSetColor

    private void BtnMouseEnteredSetColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMouseEnteredSetColor
    evt.getComponent().setBackground(new Color(177,47,46));
    }//GEN-LAST:event_BtnMouseEnteredSetColor
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAbbr;
    private javax.swing.JButton BtnColorChoose;
    private javax.swing.JButton BtnDel;
    private javax.swing.JButton BtnReset;
    private javax.swing.JButton BtnSave;
    private javax.swing.JComboBox CBArt;
    private javax.swing.JComboBox CBHerkunft;
    private javax.swing.JComboBox CBSorte;
    private javax.swing.JComboBox CBTopfgröße;
    private javax.swing.JCheckBox CheckBox;
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JLabel LblArt;
    private javax.swing.JLabel LblDatumAussaat;
    private javax.swing.JLabel LblDatumKeimung;
    private javax.swing.JLabel LblErtragGw;
    private javax.swing.JLabel LblErtragStk;
    private javax.swing.JLabel LblFarbe;
    private javax.swing.JLabel LblGesZeit;
    private javax.swing.JLabel LblGesZeitTag;
    private javax.swing.JLabel LblGrad;
    private javax.swing.JLabel LblHerkunft;
    private javax.swing.JLabel LblInfo;
    private javax.swing.JLabel LblName;
    private javax.swing.JLabel LblReifPfl;
    private javax.swing.JLabel LblReifPflTag;
    private javax.swing.JLabel LblReifSort;
    private javax.swing.JLabel LblReifSortTag;
    private javax.swing.JLabel LblScoville;
    private javax.swing.JLabel LblSorte;
    private javax.swing.JLabel LblTopfgröße;
    private javax.swing.JPanel PanNeu;
    private javax.swing.JSlider SliderGrad;
    private javax.swing.JSpinner SpinDatAussaat;
    private javax.swing.JSpinner SpinDatKeimung;
    private javax.swing.JSpinner SpinReifErtragGw;
    private javax.swing.JSpinner SpinReifErtragStk;
    private javax.swing.JSpinner SpinReifPfl;
    private javax.swing.JSpinner SpinReifSort;
    private javax.swing.JSpinner SpinScoville;
    private javax.swing.JSpinner SpinZeit;
    private javax.swing.JTextField TxtGrad;
    private javax.swing.JTextField TxtName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEditReifeSort;
    private javax.swing.JLabel lblViewStateIcon;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
