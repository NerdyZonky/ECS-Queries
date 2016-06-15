
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

/**@author Marco Schubert*/
/**builds GUI of the main window;
*gets values through poperties class from properties file;
*gets SQL command through SQLQueries class;
*executes SQL commands through queries class
*/
public class assignment extends javax.swing.JFrame {
    
    properties prop = new properties();
    
    public assignment() {
        initComponents();
        
        SQLQueries sql = new SQLQueries();
        queries queries = new queries();
        
        if(prop.getView("view").equals("assignmentNotDone")){
            this.jLabel2.setText("nicht erledige Aufträge");
            this.offerNotDoneTable.setModel(queries.getAssignmentModel(sql.getSQLAssignmentNotDoneModel()));
            this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLCountAssigmentNotDone()));
            this.offerNotDoneSumEK.setText(queries.sqlCommand(sql.getSQLSumEkAssigmentNotDone()));
            this.offerNotDoneSumNetto.setText(queries.sqlCommand(sql.getSQLSumNettoAssigmentNotDone()));
            this.countOfferDone.setText(queries.sqlCommand(sql.getSQLCountAssigmentDone()));
            this.offerAll.setText(queries.sqlCommand(sql.getSQLCountAssigmentAll()));
            this.offerNotDonePercent.setText(queries.roundPercentValues(this.offerNotDoneAmount.getText(), this.offerAll.getText()));
        }
        
        if(prop.getView("view").equals("assignmentWithoutOffer")){
            this.jLabel2.setText("Angebote ohne Aufträge");
            this.jLabel9.setText("mit Auftrag");
            this.jLabel10.setText("alle Aufträge");
            this.jLabel7.setVisible(false);
            this.offerNotDoneSumEK.setVisible(false);
            this.jLabel8.setVisible(false);
            this.offerNotDoneSumNetto.setVisible(false);
            
            this.offerNotDoneTable.setModel(queries.getOfferWithoutAssignmentModel(sql.getSQLAssignmentWithoutOfferModel()));
        
            this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLCountAssignmentWithoutOffer()));
            this.countOfferDone.setText(queries.sqlCommand(sql.getSQLCountAssignmentWithOffer()));
            this.offerAll.setText(queries.sqlCommand(sql.getSQLCountAssignmentAllOfferWithoutAssignment()));
            this.offerNotDonePercent.setText(queries.roundPercentValues(this.offerNotDoneAmount.getText(), this.offerAll.getText())); 
            
        }
        
        if(prop.getView("view").equals("negativeStock")){
            this.jLabel2.setText("Anzahl neg.LB:");
            this.jLabel6.setText("Summe neg.LB:");
            this.jLabel9.setText("Anzahl pos.LB:");
            this.jLabel10.setText("Summe pos.LB:");
            this.jLabel7.setText("Anzahl null.LB:");
            this.jLabel8.setText("Summe null.LB:");
            this.jLabel3.setVisible(false);
            this.offerNotDoneSearchFrom.setVisible(false);
            this.jLabel4.setVisible(false);
            this.offerNotDoneSearchTo.setVisible(false);
            
            
            this.offerNotDoneTable.setModel(queries.getNegativeStockModel(sql.getSQLNegativeStockModel()));
            this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLCountNegativeStock()));
            this.offerNotDonePercent.setText(queries.sqlCommand(sql.getSQLSumNegativeStock()));
            this.countOfferDone.setText(queries.sqlCommand(sql.getSQLSumPostitiveStock()));
            this.offerAll.setText(queries.sqlCommand(sql.getSQCountNullStock()));
            this.offerNotDoneSumEK.setText(queries.sqlCommand(sql.getSQLSumPostitiveStock()));

        }
        
        if(prop.getView("view").equals("punctualDelivery")){
            this.jLabel2.setText("Lieferverzug");
            this.jLabel9.setText("Pünktlich:");
            this.jLabel10.setText("Gesamt:");
            this.jLabel7.setVisible(false);
            this.offerNotDoneSumEK.setVisible(false);
            this.jLabel8.setVisible(false);
            this.offerNotDoneSumNetto.setVisible(false);
            this.offerNotDoneTable.setModel(queries.getPunctualDeliveryModel(sql.getSQLPunctualDeliveryModel()));
            this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLSumNotPunctualPunctualDelivery()));
            this.countOfferDone.setText(queries.sqlCommand(sql.getSQLSumPunctualPunctualDelivery()));
            this.offerNotDonePercent.setText(queries.roundPercentValues(this.offerNotDoneAmount.getText(), this.offerAll.getText()));
  
            /**cast offerNotDoneAmount and countOfferDone to int and add them 
            together to get total amount*/
            int ondaINT = Integer.valueOf(this.offerNotDoneAmount.getText());
            int codINT = Integer.valueOf(this.countOfferDone.getText());
            int resINT = ondaINT + codINT; 
            
            /**cast amount back to string*/
            this.offerAll.setText(String.valueOf(resINT));
            this.offerNotDonePercent.setText(queries.roundPercentValues(this.offerNotDoneAmount.getText(), this.offerAll.getText()));
        }
        
        
        if(prop.getView("view").equals("grossProfit")){
            this.jLabel2.setText("Erträge");
            this.jLabel5.setText("Gesamt:");
            this.jLabel3.setText("Jahr");
            
            this.jLabel5.setVisible(false);
            this.offerNotDoneAmount.setVisible(false);
            this.jLabel6.setVisible(false);
            this.offerNotDonePercent.setVisible(false);
            this.jLabel9.setVisible(false);
            this.countOfferDone.setVisible(false);
            this.jLabel10.setVisible(false);
            this.offerAll.setVisible(false);
            this.jLabel7.setVisible(false);
            this.offerNotDoneSumEK.setVisible(false);
            this.jLabel8.setVisible(false);
            this.offerNotDoneSumNetto.setVisible(false);
            this.jLabel4.setVisible(false);
            this.offerNotDoneSearchTo.setVisible(false);
            
            this.offerNotDoneTable.setModel(queries.getGrossProfitModel(sql.getSQLGrossProfitModel()));


        }
        
        if(prop.getView("view").equals("sales")){
            this.jLabel2.setText("Umsätze");
            this.jLabel3.setText("Jahr");
            
            
            this.jLabel5.setVisible(false);
            this.offerNotDoneAmount.setVisible(false);
            this.jLabel6.setVisible(false);
            this.offerNotDonePercent.setVisible(false);
            this.jLabel9.setVisible(false);
            this.countOfferDone.setVisible(false);
            this.jLabel10.setVisible(false);
            this.offerAll.setVisible(false);
            this.jLabel7.setVisible(false);
            this.offerNotDoneSumEK.setVisible(false);
            this.jLabel8.setVisible(false);
            this.offerNotDoneSumNetto.setVisible(false);
            this.jLabel4.setVisible(false);
            this.offerNotDoneSearchTo.setVisible(false);
            
            this.offerNotDoneTable.setModel(queries.getSalesModel(sql.getSQLSalesModel()));


        }
        
        
        if(prop.getView("view").equals("margin")){
            this.jLabel2.setText("Marge");
            this.jLabel3.setText("Nr.");
            
            
            this.jLabel5.setVisible(false);
            this.offerNotDoneAmount.setVisible(false);
            this.jLabel6.setVisible(false);
            this.offerNotDonePercent.setVisible(false);
            this.jLabel9.setVisible(false);
            this.countOfferDone.setVisible(false);
            this.jLabel10.setVisible(false);
            this.offerAll.setVisible(false);
            this.jLabel7.setVisible(false);
            this.offerNotDoneSumEK.setVisible(false);
            this.jLabel8.setVisible(false);
            this.offerNotDoneSumNetto.setVisible(false);
            this.jLabel4.setVisible(false);
            this.offerNotDoneSearchTo.setVisible(false);
            
            this.offerNotDoneTable.setModel(queries.getMarginModel(sql.getSQLMarginModel()));

        }
        
        
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollBar1 = new javax.swing.JScrollBar();
        jComboBox1 = new javax.swing.JComboBox<>();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        offerNotDoneTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        offerNotDoneSearchTo = new javax.swing.JTextField();
        offerNotDoneSearchFrom = new javax.swing.JTextField();
        offerNotDoneSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        offerNotDoneAmount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        offerNotDonePercent = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        offerNotDoneSumEK = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        offerNotDoneSumNetto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        offerAll = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        countOfferDone = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        offerNotDoneTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(offerNotDoneTable);

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N

        jLabel3.setText("von:");

        jLabel4.setText("bis:");

        offerNotDoneSearchFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offerNotDoneSearchFromActionPerformed(evt);
            }
        });

        offerNotDoneSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database(2).png"))); // NOI18N
        offerNotDoneSearch.setText("Suche");
        offerNotDoneSearch.setBorder(null);
        offerNotDoneSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offerNotDoneSearchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel5.setText("Anzahl:");

        offerNotDoneAmount.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        offerNotDoneAmount.setText("0");

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel6.setText("in %:");

        offerNotDonePercent.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        offerNotDonePercent.setText("0");

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel7.setText("EK gesamt (in €) :");

        offerNotDoneSumEK.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        offerNotDoneSumEK.setText("0");

        jLabel8.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel8.setText("Netto gesamt (in €) :");

        offerNotDoneSumNetto.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        offerNotDoneSumNetto.setText("0");

        jLabel9.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel9.setText("Aufträge erledigt:");

        offerAll.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        offerAll.setText("0");

        jLabel10.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel10.setText("Aufträge gesamt: ");

        countOfferDone.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        countOfferDone.setText("0");

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon("/home/marco/Downloads/icons/xlsBIG.png")); // NOI18N
        jMenuItem1.setText("Export");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_COMMA, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon("/home/marco/Downloads/settings.png")); // NOI18N
        jMenuItem2.setText("Settings");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(offerNotDoneAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(offerNotDonePercent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(offerAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(countOfferDone, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(offerNotDoneSumEK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(offerNotDoneSumNetto, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(142, 142, 142)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(offerNotDoneSearchFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(8, 8, 8)
                        .addComponent(offerNotDoneSearchTo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(offerNotDoneSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 580, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(offerNotDoneSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(offerNotDoneSearchFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(offerNotDoneSearchTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(offerNotDoneAmount)
                    .addComponent(jLabel9)
                    .addComponent(countOfferDone)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(offerNotDoneSumEK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(offerNotDonePercent)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(offerAll)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(offerNotDoneSumNetto))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        launcher launch = new launcher();
        this.setVisible(false);
        launch.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void offerNotDoneSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offerNotDoneSearchActionPerformed
        
       
        SQLQueries sql = new SQLQueries();
        queries queries = new queries();
   
        String searchFrom = this.offerNotDoneSearchFrom.getText();
        String searchTo = this.offerNotDoneSearchTo.getText();
        
        
        if(prop.getView("view").equals("assignmentNotDone")){
            
            if(searchFrom.equals("") && searchTo.equals("")){
                this.offerNotDoneTable.setModel(queries.getAssignmentModel(sql.getSQLAssignmentNotDoneModel()));
                this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLCountAssigmentNotDone()));
                this.offerNotDoneSumEK.setText(queries.sqlCommand(sql.getSQLSumEkAssigmentNotDone()));
                this.offerNotDoneSumNetto.setText(queries.sqlCommand(sql.getSQLSumNettoAssigmentNotDone()));
                this.countOfferDone.setText(queries.sqlCommand(sql.getSQLCountAssigmentDone()));
                this.offerAll.setText(queries.sqlCommand(sql.getSQLCountAssigmentAll()));
                this.offerNotDonePercent.setText(queries.roundPercentValues(this.offerNotDoneAmount.getText(), this.offerAll.getText()));
                
            }
            
            else{
            sql.getSQLSearch(searchFrom, searchTo);
            this.offerNotDoneTable.setModel(queries.getAssignmentModel(sql.getSQLAssigmentNotDoneModelSearch()));
            this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLCountAssigmentNotDoneSearch()));
            this.offerNotDoneSumEK.setText(queries.sqlCommand(sql.getSQLSumEkAssigmentNotDoneSearch()));
            this.offerNotDoneSumNetto.setText(queries.sqlCommand(sql.getSQLSumNettoAssigmentNotDoneSearch()));
            this.countOfferDone.setText(queries.sqlCommand(sql.getSQLCountAssigmentDoneSearch()));
            this.offerAll.setText(queries.sqlCommand(sql.getSQLCountAssigmentAllSearch()));
            this.offerNotDonePercent.setText(queries.roundPercentValues(this.offerNotDoneAmount.getText(), this.offerAll.getText()));
  
            }  
        }
        
    
        if(prop.getView("view").equals("assignmentWithoutOffer")){
            
            if(searchFrom.equals("") && searchTo.equals("")){
                this.offerNotDoneTable.setModel(queries.getOfferWithoutAssignmentModel(sql.getSQLAssignmentWithoutOfferModel()));
                this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLCountAssignmentWithoutOffer()));
                this.countOfferDone.setText(queries.sqlCommand(sql.getSQLCountAssignmentWithOffer()));
                this.offerAll.setText(queries.sqlCommand(sql.getSQLCountAssignmentAllOfferWithoutAssignment()));
                this.offerNotDonePercent.setText(queries.roundPercentValues(this.offerNotDoneAmount.getText(), this.offerAll.getText())); 
            }
            
            else{
            sql.getSQLSearch(searchFrom, searchTo);
            this.offerNotDoneTable.setModel(queries.getOfferWithoutAssignmentModel(sql.getSQLAssignmentWithoutOfferModelSearch()));
            this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLCountAssignmentWithoutOfferSearch()));
            this.countOfferDone.setText(queries.sqlCommand(sql.getSQLCountAssignmentWithOfferSearch()));
            this.offerAll.setText(queries.sqlCommand(sql.getSQLCountAssignmentAllOfferWithoutAssignmentSearch()));
            this.offerNotDonePercent.setText(queries.roundPercentValues(this.offerNotDoneAmount.getText(), this.offerAll.getText()));
            }
        }
        
        if(prop.getView("view").equals("negativeStock")){
            this.offerNotDoneTable.setModel(queries.getNegativeStockModel(sql.getSQLNegativeStockModel()));
            this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLCountNegativeStock()));
            this.offerNotDonePercent.setText(queries.sqlCommand(sql.getSQLSumNegativeStock()));
            this.countOfferDone.setText(queries.sqlCommand(sql.getSQLSumPostitiveStock()));
            this.offerAll.setText(queries.sqlCommand(sql.getSQCountNullStock()));
            this.offerNotDoneSumEK.setText(queries.sqlCommand(sql.getSQLSumPostitiveStock()));

        }
        
        if(prop.getView("view").equals("punctualDelivery")){
            if(searchFrom.equals("") && searchTo.equals("")){
                this.offerNotDoneTable.setModel(queries.getPunctualDeliveryModel(sql.getSQLPunctualDeliveryModel()));
                this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLSumNotPunctualPunctualDelivery()));
                this.countOfferDone.setText(queries.sqlCommand(sql.getSQLSumPunctualPunctualDelivery()));
                     
                /**cast offerNotDoneAmount and countOfferDone to int and add them 
                together to get total amount*/
                int ondaINT = Integer.valueOf(this.offerNotDoneAmount.getText());
                int codINT = Integer.valueOf(this.countOfferDone.getText());
                int resINT = ondaINT + codINT; 
            
                /**cast amount back to string*/
                this.offerAll.setText(String.valueOf(resINT));
                this.offerNotDonePercent.setText(queries.roundPercentValues(this.offerNotDoneAmount.getText(), this.offerAll.getText()));
 
            }
            
            else{
                sql.getSQLSearch(searchFrom, searchTo);
                this.offerNotDoneTable.setModel(queries.getPunctualDeliveryModel(sql.getSQLPunctualDeliveryModelSearch()));
                this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLSumNotPunctualPunctualDeliverySearch()));
                this.countOfferDone.setText(queries.sqlCommand(sql.getSQLSumPunctualPunctualDeliverySearch()));

                /**cast offerNotDoneAmount and countOfferDone to int and add them 
                together to get total amount*/
                int ondaINT = Integer.valueOf(this.offerNotDoneAmount.getText());
                int codINT = Integer.valueOf(this.countOfferDone.getText());
                int resINT = ondaINT + codINT; 
            
                /**cast amount back to string*/
                this.offerAll.setText(String.valueOf(resINT));
                this.offerNotDonePercent.setText(queries.roundPercentValues(this.offerNotDoneAmount.getText(), this.offerAll.getText()));
            
            }
            
        }
        
        
        if(prop.getView("view").equals("grossProfit")){
            if(searchFrom.equals("")){
                this.offerNotDoneTable.setModel(queries.getGrossProfitModel(sql.getSQLGrossProfitModel()));
                this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLGrossProfitTotal()));
                
 
            }
            
            else{
                sql.getSQLYear(searchFrom);
                this.offerNotDoneTable.setModel(queries.getGrossProfitModel(sql.getSQLGrossProfitModelSearch()));
                this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLGrossProfitTotalSearch()));

        
            
            }
            
        }
        
       
       if(prop.getView("view").equals("sales")){
            if(searchFrom.equals("")){
                this.offerNotDoneTable.setModel(queries.getSalesModel(sql.getSQLSalesModel()));
                this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLSalesTotal()));
                
 
            }
            
            else{
                sql.getSQLYear(searchFrom);
                this.offerNotDoneTable.setModel(queries.getSalesModel(sql.getSQLSalesModelSearch()));
                this.offerNotDoneAmount.setText(queries.sqlCommand(sql.getSQLSalesTotalSearch()));

        
            
            }
            
        }
       
       
       if(prop.getView("view").equals("margin")){
            if(searchFrom.equals("")){
                this.offerNotDoneTable.setModel(queries.getMarginModel(sql.getSQLMarginModel()));
 
                
 
            }
            
            else{
                sql.getSQLYear(searchFrom);
                this.offerNotDoneTable.setModel(queries.getMarginModel(sql.getSQLMarginModelSearch()));
       }
            
        }
    
    }//GEN-LAST:event_offerNotDoneSearchActionPerformed

    private void offerNotDoneSearchFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offerNotDoneSearchFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_offerNotDoneSearchFromActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        queries queries = new queries();
        csvExport csv = new csvExport();
        FileChooser chooser = new FileChooser();

        try {
            csv.writeCSVfile(offerNotDoneTable);
        } catch (IOException ex) {
            Logger.getLogger(assignment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(assignment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(assignment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * 
     * 
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
            java.util.logging.Logger.getLogger(assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new assignment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countOfferDone;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel offerAll;
    private javax.swing.JLabel offerNotDoneAmount;
    private javax.swing.JLabel offerNotDonePercent;
    private javax.swing.JButton offerNotDoneSearch;
    private javax.swing.JTextField offerNotDoneSearchFrom;
    private javax.swing.JTextField offerNotDoneSearchTo;
    private javax.swing.JLabel offerNotDoneSumEK;
    private javax.swing.JLabel offerNotDoneSumNetto;
    private javax.swing.JTable offerNotDoneTable;
    // End of variables declaration//GEN-END:variables

}

