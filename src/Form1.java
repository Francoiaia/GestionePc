
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author Francesco
 */
public class Form1 extends javax.swing.JFrame {
    static ConnectionSqlMagic CSM = new ConnectionSqlMagic("gestionaleNextPc");
    ArrayList<Inventario> inventarioList;
    ArrayList<Lavoro> workList;
    /**
     * Creates new form Form1
     */
    
    public Form1() {
        initComponents();
        showLavoro();
        showInventario();
        loadComboBox();
        setListenere();
        loadComboMod();
//        StatoBox.addItem("peppe");
//        StatoBox.addItem("pepp2e");
    }
    
    public  void cleanTable(){
        
        DefaultTableModel dm = (DefaultTableModel) Tabelluni.getModel();
        int rowCount = dm.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        dm = (DefaultTableModel) TabelluniInventario.getModel();
        rowCount = dm.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        
    }
    public void loadComboMod(){
        PezzoBoxDaMod.removeAllItems();
        TipoBoxDaMod.removeAllItems();
        for (int i = 0; i < inventarioList.size(); i++) {
            PezzoBoxDaMod.addItem(inventarioList.get(i).getPezzo());
        }
        StatoDelLavoroBoxDaMod.addItem("Inizializzato");
        TipoBoxDaMod.addItem("Riparazione");
        TipoBoxDaMod.addItem("Sostituzione");
        TipoBoxDaMod.addItem("Diagnostica");
        TipoBoxDaMod.addItem("Preventivo");
    }
    
    public void loadComboBox(){
        PezzoBox.removeAllItems();
        TipoBox.removeAllItems();
        
        
        ArrayList<Inventario> inventarioList = GetInventarioList();
        for (int i = 0; i < inventarioList.size(); i++) {
            
            PezzoBox.addItem(inventarioList.get(i).getPezzo());
            
        }
        TipoBox.addItem("Riparazione");
        TipoBox.addItem("Sostituzione");
        TipoBox.addItem("Diagnostica");
        TipoBox.addItem("Preventivo");
        
        
        PezzoBox.addItem("Nessun Componente Richiesto");
        
    }
    
    public ArrayList<Lavoro> GetLavoroList() {
        workList = new ArrayList<>();
        try{
            ResultSet query1 = CSM.selectAll("lavori");
            Lavoro lavoro;
            while (query1.next()) {
                lavoro = new Lavoro(query1.getString("cliente"),query1.getString("stato") , query1.getString("pezzo"), query1.getString("TipoDiLavoro"),query1.getInt("ID"));
                workList.add(lavoro);
            }
            
            
        }catch(Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return workList;
    }
    
    public ArrayList<Inventario> GetInventarioList(){
        inventarioList = new ArrayList<>();
        
        try {
            ConnectionSqlMagic CSM = new ConnectionSqlMagic("gestionaleNextPc");
            Inventario inventario;
            ResultSet query2 = CSM.selectAll("inventario");
            
            while (query2.next()) {
                inventario = new Inventario(query2.getString("stato"),query2.getString("pezzo") , query2.getInt("id"));
                inventarioList.add(inventario);
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            
        }
        return inventarioList;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jSplitPane1 = new javax.swing.JSplitPane();
        jFrame1 = new javax.swing.JFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NomeTeXT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PezzoBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        TipoBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Clean = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        ComponenteInventarioText = new javax.swing.JTextField();
        AddButton3 = new javax.swing.JButton();
        PANELMODIFICA = new javax.swing.JPanel();
        addButton1 = new javax.swing.JButton();
        StatoDelLavoroBoxDaMod = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        TipoBoxDaMod = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        PezzoBoxDaMod = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        NomeTextDaMod = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabelluni = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelluniInventario = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel1.setText("Aggiungere Nuovo Lavoro");

        jLabel2.setText("Nome Del Cliente");

        jLabel4.setText("Pezzo Necessario");

        jLabel5.setText("Tipo Di Lavoro");

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Clean.setText("Clean All data");
        Clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CleanActionPerformed(evt);
            }
        });

        jLabel10.setText("Aggiugni Componente Inventario");

        AddButton3.setText("ADD");
        AddButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton3ActionPerformed(evt);
            }
        });

        PANELMODIFICA.setEnabled(false);

        addButton1.setText("MODIFICA");
        addButton1.setEnabled(false);
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });

        StatoDelLavoroBoxDaMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "In Corso", "Sospeso", "Terminato" }));
        StatoDelLavoroBoxDaMod.setEnabled(false);

        jLabel9.setText("Stato Del Lavoro");

        TipoBoxDaMod.setEnabled(false);

        jLabel8.setText("Tipo Di Lavoro");

        PezzoBoxDaMod.setEnabled(false);

        jLabel7.setText("Pezzo Necessario");

        NomeTextDaMod.setEnabled(false);

        jLabel6.setText("Nome Del Cliente");

        jLabel3.setText("Modifica Lavoro Esistente");

        javax.swing.GroupLayout PANELMODIFICALayout = new javax.swing.GroupLayout(PANELMODIFICA);
        PANELMODIFICA.setLayout(PANELMODIFICALayout);
        PANELMODIFICALayout.setHorizontalGroup(
            PANELMODIFICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANELMODIFICALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PANELMODIFICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANELMODIFICALayout.createSequentialGroup()
                        .addGroup(PANELMODIFICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NomeTextDaMod, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PezzoBoxDaMod, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TipoBoxDaMod, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StatoDelLavoroBoxDaMod, 0, 151, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PANELMODIFICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)))
                    .addGroup(PANELMODIFICALayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PANELMODIFICALayout.setVerticalGroup(
            PANELMODIFICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANELMODIFICALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PANELMODIFICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NomeTextDaMod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANELMODIFICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PezzoBoxDaMod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANELMODIFICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TipoBoxDaMod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANELMODIFICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatoDelLavoroBoxDaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton1))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TipoBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NomeTeXT, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PezzoBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)))
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Clean)
                        .addGap(131, 131, 131)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PANELMODIFICA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComponenteInventarioText)
                    .addComponent(AddButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PANELMODIFICA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NomeTeXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(PezzoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addButton))
                            .addComponent(jSeparator1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComponenteInventarioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AddButton3)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(Clean))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        Tabelluni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Stato", "Pezzo", "Tipo Di Lavoro", "ID"
            }
        ));
        Tabelluni.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tabelluni.setFocusable(false);
        Tabelluni.setOpaque(false);
        jScrollPane2.setViewportView(Tabelluni);
        if (Tabelluni.getColumnModel().getColumnCount() > 0) {
            Tabelluni.getColumnModel().getColumn(0).setHeaderValue("Cliente");
            Tabelluni.getColumnModel().getColumn(1).setHeaderValue("Stato");
            Tabelluni.getColumnModel().getColumn(2).setHeaderValue("Pezzo");
            Tabelluni.getColumnModel().getColumn(3).setHeaderValue("Tipo Di Lavoro");
            Tabelluni.getColumnModel().getColumn(4).setHeaderValue("ID");
        }

        jLabel11.setText("Per modificare i dati andare premere sulla riga andare alla Tab 1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        TabelluniInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stato", "Pezzo", "ID"
            }
        ));
        jScrollPane4.setViewportView(TabelluniInventario);

        jTabbedPane1.addTab("tab3", jScrollPane4);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            String query = "INSERT INTO lavori (cliente, stato, pezzo, TipoDiLavoro, ID)"
                    + " values (?, ?, ?, ?, ?);";
            PreparedStatement preparedStmt = CSM.con.prepareStatement(query);
            preparedStmt.setString (1, NomeTeXT.getText());
            preparedStmt.setString (2, "Inizializzato");
            preparedStmt.setString (3, PezzoBox.getItemAt(PezzoBox.getSelectedIndex()));
            preparedStmt.setString (4, TipoBox.getItemAt(TipoBox.getSelectedIndex()));
            preparedStmt.setInt(5, 0);
            
            System.out.println(preparedStmt.toString());
            preparedStmt.execute();
            
        } catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        
        
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        cleanTable();
        showLavoro();
        showInventario();
        loadComboBox();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void CleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CleanActionPerformed
        CSM.wipedata();
    }//GEN-LAST:event_CleanActionPerformed

    private void AddButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton3ActionPerformed
        try {
            String query = "INSERT INTO inventario (stato, pezzo, id)"
                    + " values (?, ?, ?);";
            PreparedStatement preparedStmt = CSM.con.prepareStatement(query);
            preparedStmt.setString (1, "Presente");
            preparedStmt.setString (2, ComponenteInventarioText.getText() );
            preparedStmt.setInt(3, 0);
            
            
            System.out.println(preparedStmt.toString());
            preparedStmt.execute();
            
        } catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        loadComboBox();
    }//GEN-LAST:event_AddButton3ActionPerformed

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        

    }//GEN-LAST:event_addButton1ActionPerformed
    
    
    
    private void showInventario() {
        ArrayList<Inventario> inventarioList = GetInventarioList();
        DefaultTableModel model = (DefaultTableModel) TabelluniInventario.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
        }
        for (int i = 0; i < inventarioList.size(); i++) {
            row[0]= inventarioList.get(i).getStato();
            row[1]= inventarioList.get(i).getPezzo();
            row[2]= inventarioList.get(i).getID();
            model.addRow(row);
        }
    }
    
    public void showLavoro(){
        
        ArrayList<Lavoro> workList = GetLavoroList();
        DefaultTableModel model = (DefaultTableModel) Tabelluni.getModel();
        Object[] row = new Object[5];
        
        for (int i = 0; i < workList.size(); i++) {
            row[0]= workList.get(i).getCliente();
            row[1]= workList.get(i).getStat();
            row[2]= workList.get(i).getPezzo();
            row[3]= workList.get(i).getTipodilavoro();
            row[4] = workList.get(i).getId();
            model.addRow(row);
        }
    }
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
    java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (InstantiationException ex) {
    java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
    java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
    java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}
//</editor-fold>

/* Create and display the form */
java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        new Form1().setVisible(true);
        
    }
});
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton3;
    private javax.swing.JButton Clean;
    private javax.swing.JTextField ComponenteInventarioText;
    private javax.swing.JTextField NomeTeXT;
    private javax.swing.JTextField NomeTextDaMod;
    private javax.swing.JPanel PANELMODIFICA;
    private javax.swing.JComboBox<String> PezzoBox;
    private javax.swing.JComboBox<String> PezzoBoxDaMod;
    private javax.swing.JComboBox<String> StatoDelLavoroBoxDaMod;
    private javax.swing.JTable Tabelluni;
    private javax.swing.JTable TabelluniInventario;
    private javax.swing.JComboBox<String> TipoBox;
    private javax.swing.JComboBox<String> TipoBoxDaMod;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
    
    private void setListenere() {
        Tabelluni.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if(event.getValueIsAdjusting() == true){
                    // do some actions here, for example
                    // print first column value from selected row
                    //jTabbedPane1.setSelectedIndex(0);
                    System.out.println("Tabelluni");
                    DefaultTableModel dm = (DefaultTableModel) Tabelluni.getModel();
                    Vector elementAt = (Vector) dm.getDataVector().elementAt(Tabelluni.getSelectedRow());
                    NomeTextDaMod.setText((String) elementAt.get(0));
                    loadComboMod();
                    for (int i = 0; i < PezzoBoxDaMod.getItemCount(); i++) {
                        if(PezzoBoxDaMod.getItemAt(i).equals((String) elementAt.get(2))){
                            PezzoBoxDaMod.setSelectedIndex(i);
                        }
                    }
                    for (int i = 0; i < TipoBoxDaMod.getItemCount(); i++) {
                        if(TipoBoxDaMod.getItemAt(i).equals((String) elementAt.get(3))){
                            TipoBoxDaMod.setSelectedIndex(i);
                        }
                    }
                    for (int i = 0; i < StatoDelLavoroBoxDaMod.getItemCount(); i++) {
                        if(StatoDelLavoroBoxDaMod.getItemAt(i).equals((String) elementAt.get(1))){
                            StatoDelLavoroBoxDaMod.setSelectedIndex(i);
                        }
                    }
                    
                    
                    //String[] value = elementAt.toString().split(",");
                    //NomeTextDaMod.setText();
                }
            }
        });
        
        
        TabelluniInventario.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if(event.getValueIsAdjusting() == true){
                // do some actions here, for example
                // print first column value from selected row
                //jTabbedPane1.setSelectedIndex(0);
                System.out.println("Inventario");
                DefaultTableModel dm = (DefaultTableModel) TabelluniInventario.getModel();
                
                Vector<Lavoro> elementAt = (Vector<Lavoro>) dm.getDataVector().elementAt(TabelluniInventario.getSelectedRow());
                
            }
        });
    }
    
}
