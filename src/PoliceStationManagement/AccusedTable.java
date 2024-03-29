package PoliceStationManagement;
import SQLPackage.*;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;



public class AccusedTable extends javax.swing.JFrame {

    DefaultTableModel Model;
    
/**
     * Creates new form AccusedTable
     */
     AccusedUpdate accusedupdate = new AccusedUpdate();
    String acc_id,acc_caseNo,acc_name,acc_age,acc_fathersName,acc_village,acc_thana,acc_Thana,acc_district,acc_pre_address,acc_pre_thana,acc_pre_district;;
    public AccusedTable() {
       
        initComponents();
        setTitle("Accused Table");
        Font font = new Font("Tahoma", Font.PLAIN, 20);
        this.AccusedTable.setFont(font);
        int gap = 15;
        this.AccusedTable.setRowHeight(this.AccusedTable.getRowHeight()+gap);
        try {
            ShowAccused();
            
        } catch (SQLException ex) {
            Logger.getLogger(VictimTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Accused> AccusedList() throws SQLException
    {
        ArrayList<Accused> AccusedList = new ArrayList<>();
        ConnectMSSQL cnObj = new ConnectMSSQL();
        cnObj.connectDB();
        String Query1="SELECT * FROM Accused";  
        Statement st=cnObj.connection.createStatement();
        ResultSet rs= st.executeQuery(Query1);
        Accused AccusedObj;
        while(rs.next())
        {
            AccusedObj=new Accused(rs.getInt("AccusedId"),rs.getInt("CaseNo"),rs.getString("AccusedName"),rs.getInt("Age"),rs.getString("FathersName"),rs.getString("Village"),rs.getString("Thana"),rs.getInt("DistrictId"),rs.getString("PresentAddress"),rs.getString("PresentThana"),rs.getInt("PresentDistrictId"));
            AccusedList.add(AccusedObj);
        }
        return AccusedList;
    }

    public void ShowAccused() throws SQLException
    {
        ArrayList<Accused> aList = AccusedList();
        DefaultTableModel Model= (DefaultTableModel)AccusedTable.getModel();
        Object[] row= new Object[11];
        for(int i=0;i<aList.size();i++)
        {
            row[0]=aList.get(i).getAccusedId();
            row[1]=aList.get(i).getCaseNo();
            row[2]=aList.get(i).getAccusedName();
            row[3]=aList.get(i).getAge();
            row[4]=aList.get(i).getFathersName();  
            row[5]=aList.get(i).getVillage();
            row[6]=aList.get(i).getThana();
            row[7]=aList.get(i).getDistrictId();
            row[8]=aList.get(i).getPresentAddress(); 
            row[9]=aList.get(i).getPresentThana();
            row[10]=aList.get(i).getPresentDistrictId();
            Model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jButton_back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AccusedTable = new javax.swing.JTable();
        SearchComboBox = new javax.swing.JComboBox<>();
        SearchTextField = new javax.swing.JTextField();
        AccusedUpdateButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        AccusedComboBox = new javax.swing.JComboBox<>();
        Sort = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jButton_back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_back.setText("BACK");
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_back);
        jButton_back.setBounds(70, 650, 170, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ACCUSED TABLE");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(410, 130, 410, 110);

        AccusedTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AccusedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AccusedId", "CaseNo", "AccusedName", "Age", "Father'sName", "Village", "Thana", "District", "PresentAdress", "PresentThana", "PresentDistrict"
            }
        ));
        AccusedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AccusedTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AccusedTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 240, 1230, 350);

        SearchComboBox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SearchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"--Select--", "AccusedId", "CaseNo", "AccusedName", "Age", "Father'sName", "Village", "Thana", "District", "PresentAdress", "PresentThana", "PresentDistrict"}));
        jPanel1.add(SearchComboBox);
        SearchComboBox.setBounds(190, 40, 220, 40);

        SearchTextField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        SearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(SearchTextField);
        SearchTextField.setBounds(520, 40, 430, 40);

        AccusedUpdateButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AccusedUpdateButton.setText("UPDATE");
        AccusedUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccusedUpdateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AccusedUpdateButton);
        AccusedUpdateButton.setBounds(840, 640, 170, 50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Search :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(440, 50, 80, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Search By : ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 50, 110, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PoliceStationManagement/logo.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(1030, 10, 210, 210);

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton);
        deleteButton.setBounds(1050, 640, 160, 50);

        AccusedComboBox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AccusedComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AccusedId", "CaseNo", "AccusedName", "Age", "Father'sName", "Village", "Thana", "District", "PresentAddress", "PresentThana", "PresentDistrict" }));
        AccusedComboBox.setToolTipText("");
        AccusedComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccusedComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(AccusedComboBox);
        AccusedComboBox.setBounds(190, 100, 220, 40);

        Sort.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Sort.setForeground(new java.awt.Color(255, 255, 255));
        Sort.setText("SORT:");
        jPanel1.add(Sort);
        Sort.setBounds(70, 112, 80, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PoliceStationManagement/bg_pic.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1250, 880);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        // TODO add your handling code here:
          MainPage mObj = new MainPage();
        mObj.show();
        this.setVisible(false);
    }//GEN-LAST:event_jButton_backActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        try{
            ConnectMSSQL cnObj = new ConnectMSSQL();
            cnObj.connectDB();
            int row = AccusedTable.getSelectedRow();
            String value = (AccusedTable.getModel().getValueAt(row, 0).toString());
            String query = "DELETE FROM Accused WHERE AccusedId = "+value;
            PreparedStatement pst = (PreparedStatement) cnObj.connection.prepareStatement(query);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) AccusedTable.getModel();
            model.setRowCount(0);
            ShowAccused();
            JOptionPane.showMessageDialog(null,"Deleted Successfully!!");
            
        }
        catch(Exception e){
            Logger.getLogger(VictimPage.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void SearchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextFieldKeyReleased
        // TODO add your handling code here:
        String columnToSearch = SearchComboBox.getSelectedItem().toString();
        String stringToSearch = SearchTextField.getText();
        try{
            ConnectMSSQL cnObj = new ConnectMSSQL();
            cnObj.connectDB();
            DefaultTableModel Model= (DefaultTableModel)AccusedTable.getModel();
            Model.setRowCount(0);
            Object[] row= new Object[11];
            if("AccusedId".equals(columnToSearch))
            {
                String query = "SELECT * FROM Accused WHERE AccusedId LIKE'%"+stringToSearch+"%'";
                Statement st=cnObj.connection.createStatement();
                ResultSet rs= st.executeQuery(query);
                while(rs.next()){
                    row[0] = rs.getInt("AccusedId");
                    row[1] = rs.getInt("CaseNo");
                    row[2] = rs.getString("AccusedName");
                    row[3] = rs.getInt("Age");
                    row[4] = rs.getString("FathersName");
                    row[5] = rs.getString("Village");
                    row[6] = rs.getString("Thana");
                    row[7] = rs.getInt("DistrictId");
                    row[8] = rs.getString("PresentAddress");
                    row[9] = rs.getString("PresentThana");
                    row[10] = rs.getInt("PresentDistrictId");
                    Model.addRow(row);
                }
            
            }
            else if("CaseNo".equals(columnToSearch))
            {
                String query = "SELECT * FROM Accused WHERE CaseNo LIKE'%"+stringToSearch+"%'";
                Statement st=cnObj.connection.createStatement();
                ResultSet rs= st.executeQuery(query);
                while(rs.next()){
                    row[0] = rs.getInt("AccusedId");
                    row[1] = rs.getInt("CaseNo");
                    row[2] = rs.getString("AccusedName");
                    row[3] = rs.getInt("Age");
                    row[4] = rs.getString("FathersName");
                    row[5] = rs.getString("Village");
                    row[6] = rs.getString("Thana");
                    row[7] = rs.getInt("DistrictId");
                    row[8] = rs.getString("PresentAddress");
                    row[9] = rs.getString("PresentThana");
                    row[10] = rs.getInt("PresentDistrictId");
                    Model.addRow(row);
                }
            
            }
            else if("AccusedName".equals(columnToSearch))
            {
                String query = "SELECT * FROM Accused WHERE AccusedName LIKE'%"+stringToSearch+"%'";
                Statement st=cnObj.connection.createStatement();
                ResultSet rs= st.executeQuery(query);
                while(rs.next()){
                    row[0] = rs.getInt("AccusedId");
                    row[1] = rs.getInt("CaseNo");
                    row[2] = rs.getString("AccusedName");
                    row[3] = rs.getInt("Age");
                    row[4] = rs.getString("FathersName");
                    row[5] = rs.getString("Village");
                    row[6] = rs.getString("Thana");
                    row[7] = rs.getInt("DistrictId");
                    row[8] = rs.getString("PresentAddress");
                    row[9] = rs.getString("PresentThana");
                    row[10] = rs.getInt("PresentDistrictId");
                    Model.addRow(row);
                }
            
            }
            else if("Age".equals(columnToSearch))
            {
                String query = "SELECT * FROM Accused WHERE Age LIKE'%"+stringToSearch+"%'";
                Statement st=cnObj.connection.createStatement();
                ResultSet rs= st.executeQuery(query);
                while(rs.next()){
                    row[0] = rs.getInt("AccusedId");
                    row[1] = rs.getInt("CaseNo");
                    row[2] = rs.getString("AccusedName");
                    row[3] = rs.getInt("Age");
                    row[4] = rs.getString("FathersName");
                    row[5] = rs.getString("Village");
                    row[6] = rs.getString("Thana");
                    row[7] = rs.getInt("DistrictId");
                    row[8] = rs.getString("PresentAddress");
                    row[9] = rs.getString("PresentThana");
                    row[10] = rs.getInt("PresentDistrictId");
                    Model.addRow(row);
                }
            
            }
            else if("Father'sName".equals(columnToSearch))
            {
                String query = "SELECT * FROM Accused WHERE FathersName LIKE'%"+stringToSearch+"%'";
                Statement st=cnObj.connection.createStatement();
                ResultSet rs= st.executeQuery(query);
                while(rs.next()){
                    row[0] = rs.getInt("AccusedId");
                    row[1] = rs.getInt("CaseNo");
                    row[2] = rs.getString("AccusedName");
                    row[3] = rs.getInt("Age");
                    row[4] = rs.getString("FathersName");
                    row[5] = rs.getString("Village");
                    row[6] = rs.getString("Thana");
                    row[7] = rs.getInt("DistrictId");
                    row[8] = rs.getString("PresentAddress");
                    row[9] = rs.getString("PresentThana");
                    row[10] = rs.getInt("PresentDistrictId");
                    Model.addRow(row);
                }
            
            }
            else if("Village".equals(columnToSearch))
            {
                String query = "SELECT * FROM Accused WHERE Village LIKE'%"+stringToSearch+"%'";
                Statement st=cnObj.connection.createStatement();
                ResultSet rs= st.executeQuery(query);
                while(rs.next()){
                    row[0] = rs.getInt("AccusedId");
                    row[1] = rs.getInt("CaseNo");
                    row[2] = rs.getString("AccusedName");
                    row[3] = rs.getInt("Age");
                    row[4] = rs.getString("FathersName");
                    row[5] = rs.getString("Village");
                    row[6] = rs.getString("Thana");
                    row[7] = rs.getInt("DistrictId");
                    row[8] = rs.getString("PresentAddress");
                    row[9] = rs.getString("PresentThana");
                    row[10] = rs.getInt("PresentDistrictId");
                    Model.addRow(row);
                }
            
            }
            else if("Thana".equals(columnToSearch))
            {
                String query = "SELECT * FROM Accused WHERE Thana LIKE'%"+stringToSearch+"%'";
                Statement st=cnObj.connection.createStatement();
                ResultSet rs= st.executeQuery(query);
                while(rs.next()){
                    row[0] = rs.getInt("AccusedId");
                    row[1] = rs.getInt("CaseNo");
                    row[2] = rs.getString("AccusedName");
                    row[3] = rs.getInt("Age");
                    row[4] = rs.getString("FathersName");
                    row[5] = rs.getString("Village");
                    row[6] = rs.getString("Thana");
                    row[7] = rs.getInt("DistrictId");
                    row[8] = rs.getString("PresentAddress");
                    row[9] = rs.getString("PresentThana");
                    row[10] = rs.getInt("PresentDistrictId");
                    Model.addRow(row);
                }
            
            }
            else if("District".equals(columnToSearch))
            {
                String query = "SELECT * FROM Accused WHERE DistrictId LIKE'%"+stringToSearch+"%'";
                Statement st=cnObj.connection.createStatement();
                ResultSet rs= st.executeQuery(query);
                while(rs.next()){
                    row[0] = rs.getInt("AccusedId");
                    row[1] = rs.getInt("CaseNo");
                    row[2] = rs.getString("AccusedName");
                    row[3] = rs.getInt("Age");
                    row[4] = rs.getString("FathersName");
                    row[5] = rs.getString("Village");
                    row[6] = rs.getString("Thana");
                    row[7] = rs.getInt("DistrictId");
                    row[8] = rs.getString("PresentAddress");
                    row[9] = rs.getString("PresentThana");
                    row[10] = rs.getInt("PresentDistrictId");
                    Model.addRow(row);
                }
            
            }
            else if("PresentAdress".equals(columnToSearch))
            {
                String query = "SELECT * FROM Accused WHERE PresentAddress LIKE'%"+stringToSearch+"%'";
                Statement st=cnObj.connection.createStatement();
                ResultSet rs= st.executeQuery(query);
                while(rs.next()){
                    row[0] = rs.getInt("AccusedId");
                    row[1] = rs.getInt("CaseNo");
                    row[2] = rs.getString("AccusedName");
                    row[3] = rs.getInt("Age");
                    row[4] = rs.getString("FathersName");
                    row[5] = rs.getString("Village");
                    row[6] = rs.getString("Thana");
                    row[7] = rs.getInt("DistrictId");
                    row[8] = rs.getString("PresentAddress");
                    row[9] = rs.getString("PresentThana");
                    row[10] = rs.getInt("PresentDistrictId");
                    Model.addRow(row);
                }
            
            }
            else if("PresentThana".equals(columnToSearch))
            {
                String query = "SELECT * FROM Accused WHERE PresentThana LIKE'%"+stringToSearch+"%'";
                Statement st=cnObj.connection.createStatement();
                ResultSet rs= st.executeQuery(query);
                while(rs.next()){
                    row[0] = rs.getInt("AccusedId");
                    row[1] = rs.getInt("CaseNo");
                    row[2] = rs.getString("AccusedName");
                    row[3] = rs.getInt("Age");
                    row[4] = rs.getString("FathersName");
                    row[5] = rs.getString("Village");
                    row[6] = rs.getString("Thana");
                    row[7] = rs.getInt("DistrictId");
                    row[8] = rs.getString("PresentAddress");
                    row[9] = rs.getString("PresentThana");
                    row[10] = rs.getInt("PresentDistrictId");
                    Model.addRow(row);
                }
            
            }
            else if("PresentDistrict".equals(columnToSearch))
            {
                String query = "SELECT * FROM Accused WHERE PresentDistrictId LIKE'%"+stringToSearch+"%'";
                Statement st=cnObj.connection.createStatement();
                ResultSet rs= st.executeQuery(query);
                while(rs.next()){
                    row[0] = rs.getInt("AccusedId");
                    row[1] = rs.getInt("CaseNo");
                    row[2] = rs.getString("AccusedName");
                    row[3] = rs.getInt("Age");
                    row[4] = rs.getString("FathersName");
                    row[5] = rs.getString("Village");
                    row[6] = rs.getString("Thana");
                    row[7] = rs.getInt("DistrictId");
                    row[8] = rs.getString("PresentAddress");
                    row[9] = rs.getString("PresentThana");
                    row[10] = rs.getInt("PresentDistrictId");
                    Model.addRow(row);
                }
            
            }
            else if("".equals(columnToSearch))
            {
                ShowAccused();
            }
        }catch(Exception e){
            Logger.getLogger(VictimPage.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_SearchTextFieldKeyReleased

    private void AccusedUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccusedUpdateButtonActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        
        accusedupdate.setVisible(true);
        accusedupdate.jTextField_caseId.setText(acc_caseNo);
        accusedupdate.jTextField_name.setText(acc_name);
        accusedupdate.jTextField_age.setText(acc_age);
        accusedupdate.jTextField_fathersName.setText(acc_fathersName);
        accusedupdate.jTextField_village.setText(acc_village);
        accusedupdate.jTextField4_thana.setText(acc_caseNo);
        accusedupdate.jComboBox_district.addItem(acc_district);
        accusedupdate.jTextField_presentAddress.setText(acc_pre_address);
        accusedupdate.jTextField_presentThana.setText(acc_pre_thana);
        accusedupdate.jComboBox_presentDistrict.addItem(acc_pre_district);
    }//GEN-LAST:event_AccusedUpdateButtonActionPerformed

    private void AccusedTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccusedTableMouseClicked
        // TODO add your handling code here:
         int selectedRow = AccusedTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) AccusedTable.getModel();
        
         acc_id = model.getValueAt(selectedRow, 0).toString();
         acc_caseNo = model.getValueAt(selectedRow, 1).toString();
         acc_name = model.getValueAt(selectedRow, 2).toString();
         acc_age = model.getValueAt(selectedRow, 3).toString();
         acc_fathersName = model.getValueAt(selectedRow, 4).toString();
         acc_village = model.getValueAt(selectedRow, 5).toString();
         acc_Thana = model.getValueAt(selectedRow, 6).toString();
         acc_district = model.getValueAt(selectedRow, 7).toString();
         acc_pre_address = model.getValueAt(selectedRow, 8).toString();
         acc_pre_thana = model.getValueAt(selectedRow, 9).toString();
         acc_pre_district = model.getValueAt(selectedRow, 10).toString();
    }//GEN-LAST:event_AccusedTableMouseClicked
public ArrayList<Accused> AccusedListTable(String Query) throws SQLException
    {
        ArrayList<Accused> AccusedList = new ArrayList<>();
        ConnectMSSQL cnObj = new ConnectMSSQL();
        cnObj.connectDB();
        Statement st=cnObj.connection.createStatement();
        ResultSet rs= st.executeQuery(Query);
        Accused AccusedObj;
        while(rs.next())
        {
            AccusedObj=new Accused(rs.getInt("AccusedId"),rs.getInt("CaseNo"),rs.getString("AccusedName"),rs.getInt("Age"),rs.getString("FathersName"),rs.getString("Village"),rs.getString("Thana"),rs.getInt("DistrictId"),rs.getString("PresentAddress"),rs.getString("PresentThana"),rs.getInt("PresentDistrictId"));
            AccusedList.add(AccusedObj);
        }
        return AccusedList;
    }

    public void ShowAccusedTable(String query) throws SQLException
    {
        ArrayList<Accused> atList = AccusedListTable(query);
        DefaultTableModel Model= new DefaultTableModel();
   
        Model.setColumnIdentifiers(new Object[]{"AccusedId","CaseNo","AccusedName","Age","FathersName","Village","Thana","DistrictId","PresentAddress","PresentThana","PresentDistrictId"});
        Object[] row=new Object[11];
        for(int i=0;i<atList.size();i++)
        {
            row[0]=atList.get(i).getAccusedId();
            row[1]=atList.get(i).getCaseNo();
            row[2]=atList.get(i).getAccusedName();
            row[3]=atList.get(i).getAge();
            row[4]=atList.get(i).getFathersName();  
            row[5]=atList.get(i).getVillage();
            row[6]=atList.get(i).getThana();
            row[7]=atList.get(i).getDistrictId();
            row[8]=atList.get(i).getPresentAddress(); 
            row[9]=atList.get(i).getPresentThana();
            row[10]=atList.get(i).getPresentDistrictId();
            Model.addRow(row);
        }
         AccusedTable.setModel(Model);
    }
    private void AccusedComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccusedComboBoxActionPerformed
        // TODO add your handling code here:
        try {
            if(AccusedComboBox.getSelectedItem().toString().equals("AccusedId"))
            {

                String sql1 = "SELECT * FROM Accused ORDER BY AccusedId ASC";
                ShowAccusedTable(sql1);

            }
            if(AccusedComboBox.getSelectedItem().toString().equals("CaseNo"))
            {

                String sql1 = "SELECT * FROM Accused ORDER BY CaseNo ASC";
                ShowAccusedTable(sql1);

            }
            if(AccusedComboBox.getSelectedItem().toString().equals("AccusedName"))
            {

                String sql1 = "SELECT * FROM Accused ORDER BY AccusedName ASC";
                ShowAccusedTable(sql1);

            }

            if(AccusedComboBox.getSelectedItem().toString().equals("Age"))
            {

                String sql1 = "SELECT * FROM Accused ORDER BY Age ASC";
                ShowAccusedTable(sql1);

            } if(AccusedComboBox.getSelectedItem().toString().equals("Father'sName"))
            {

                String sql1 = "SELECT * FROM Accused ORDER BY FathersName ASC";
                ShowAccusedTable(sql1);

            }
            if(AccusedComboBox.getSelectedItem().toString().equals("Village"))
            {

                String sql1 = "SELECT * FROM Accused ORDER BY Village ASC";
                ShowAccusedTable(sql1);

            } if(AccusedComboBox.getSelectedItem().toString().equals("Thana"))
            {

                String sql1 = "SELECT * FROM Accused ORDER BY Thana ASC";
                ShowAccusedTable(sql1);

            }
            if(AccusedComboBox.getSelectedItem().toString().equals("District"))
            {

                String sql1 = "SELECT * FROM Accused ORDER BY DistrictId ASC";
                ShowAccusedTable(sql1);

            }
            if(AccusedComboBox.getSelectedItem().toString().equals("PresentAddress"))
            {

                String sql1 = "SELECT * FROM Accused ORDER BY PresentAddress ASC";
                ShowAccusedTable(sql1);

            }

            if(AccusedComboBox.getSelectedItem().toString().equals("PresentThana"))
            {

                String sql1 = "SELECT * FROM Accused ORDER BY PresentThana ASC";
                ShowAccusedTable(sql1);

            }

            if(AccusedComboBox.getSelectedItem().toString().equals("PresentDistrict"))
            {

                String sql1 = "SELECT * FROM Accused ORDER BY PresentDistrictId ASC";
                ShowAccusedTable(sql1);

            }

        }
        catch (SQLException ex) {
            Logger.getLogger(AccusedTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AccusedComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(AccusedTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccusedTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccusedTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccusedTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccusedTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AccusedComboBox;
    private javax.swing.JTable AccusedTable;
    private javax.swing.JButton AccusedUpdateButton;
    private javax.swing.JComboBox<String> SearchComboBox;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JLabel Sort;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
