import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

/**
 *
 * @author saddad nabbil
 */
public class Entrydata extends javax.swing.JInternalFrame {

    private Connection connection;

    /**
     * Creates new form Entrydata
     */
    public Entrydata() {
        initComponents();
        connectToDatabase();
        if (this.connection != null) { // Check for successful connection
          loadDataFromDatabase();
        }
    }
    
    private void connectToDatabase() {
      try {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans_pertemuan13", "root", "root");
        JOptionPane.showMessageDialog(this, "Connected to the database successfully!");
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Failed to connect to the database!", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
      }
    }

    public class DatabaseConnection {
    public static Connection getConnection() {
            Connection connection = null;
            try {
                String url = "jdbc:mysql://localhost:3306/netbeans_pertemuan13";
                String user = "root";
                String password = "root";
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
    
    private void loadDataFromDatabase() {
        try {
          String query = "SELECT * FROM tabel_bunga";
          PreparedStatement preparedStatement = this.connection.prepareStatement(query); // Use this.connection
          ResultSet resultSet = preparedStatement.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) table_data.getModel();
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(0);
            
            while (resultSet.next()) {
                String bunga = resultSet.getString("bunga");
                double jumlah = resultSet.getDouble("jumlah");
                double ongkir = resultSet.getDouble("ongkir");
                double total = resultSet.getDouble("total");
                
                model.addRow(new Object[]{
                    bunga,
                    df.format(jumlah),
                    df.format(ongkir),
                    df.format(total)
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        bGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nama_bunga = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        harga_bingkai = new javax.swing.JTextField();
        jumlah_beli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        diskon_bunga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        kirim_checkbox = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        biaya_ongkir = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        radio_km_5 = new javax.swing.JRadioButton();
        radio_15_km = new javax.swing.JRadioButton();
        radio_lebih_dari_15 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        total_bayar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        total_bunga_terjual = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        total_pendapatan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        simpan_button = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_data = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA PENJUALAN TOKO BUNGA 'SEGAR'");

        jLabel2.setText("Nama Bunga");

        nama_bunga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "==Pilih Bunga==", "Anggrek", "Mawar", "Sedap Malam", " " }));

        jLabel3.setText("Harga/Bingkai");

        harga_bingkai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harga_bingkaiActionPerformed(evt);
            }
        });

        jumlah_beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlah_beliActionPerformed(evt);
            }
        });

        jLabel4.setText("Jumlah Beli");

        diskon_bunga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diskon_bungaActionPerformed(evt);
            }
        });

        jLabel5.setText("Diskon");

        kirim_checkbox.setText("Kirim");

        jLabel6.setText("Biaya Kirim");

        biaya_ongkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biaya_ongkirActionPerformed(evt);
            }
        });

        jLabel7.setText("Jarak");

        bGroup.add(radio_km_5);
        radio_km_5.setText("< 5 Km");

        bGroup.add(radio_15_km);
        radio_15_km.setText("5 - 15 Km");

        bGroup.add(radio_lebih_dari_15);
        radio_lebih_dari_15.setText("> 15 Km");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Total Bayar");

        total_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_bayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(31, 31, 31)
                        .addComponent(total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(31, 31, 31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nama_bunga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(harga_bingkai, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jumlah_beli, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(diskon_bunga, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(kirim_checkbox)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6)
                            .addGap(55, 55, 55)
                            .addComponent(biaya_ongkir, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel7)
                            .addGap(31, 31, 31)
                            .addComponent(radio_km_5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(radio_15_km)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(radio_lebih_dari_15))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nama_bunga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(harga_bingkai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jumlah_beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(diskon_bunga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kirim_checkbox)
                    .addComponent(jLabel6)
                    .addComponent(biaya_ongkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(radio_km_5)
                    .addComponent(radio_15_km)
                    .addComponent(radio_lebih_dari_15))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Tampil Hasil");

        jLabel10.setText("Total Bunga Terjual");

        total_bunga_terjual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_bunga_terjualActionPerformed(evt);
            }
        });

        jLabel11.setText("TOTAL PENDAPATAN");

        total_pendapatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_pendapatanActionPerformed(evt);
            }
        });

        jLabel12.setText("Tangkai");

        simpan_button.setText("SIMPAN");
        simpan_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan_buttonActionPerformed(evt);
            }
        });

        clear_button.setText("CLEAR");
        clear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_buttonActionPerformed(evt);
            }
        });

        table_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bunga", "Jumlah", "Biaya Kirim", "Total"
            }
        ));
        jScrollPane2.setViewportView(table_data);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(simpan_button)
                        .addGap(29, 29, 29)
                        .addComponent(clear_button))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(31, 31, 31)
                                .addComponent(total_bunga_terjual, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(total_pendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(total_bunga_terjual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(total_pendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan_button)
                    .addComponent(clear_button))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void harga_bingkaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harga_bingkaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harga_bingkaiActionPerformed

    private void jumlah_beliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlah_beliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlah_beliActionPerformed

    private void diskon_bungaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diskon_bungaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diskon_bungaActionPerformed

    private void biaya_ongkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biaya_ongkirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_biaya_ongkirActionPerformed

    private void total_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_bayarActionPerformed

    private void total_bunga_terjualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_bunga_terjualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_bunga_terjualActionPerformed

    private void total_pendapatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_pendapatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_pendapatanActionPerformed

    private void simpan_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan_buttonActionPerformed
        // TODO add your handling code here:
        String bunga;
        double harga, jumlah, diskon, ongkir, total, totaljumlah, totalpenjualan;
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(0);
        
        bunga = nama_bunga.getSelectedItem().toString();
        
        if ("Anggrek".equals(bunga)){
            harga = 10000;
            harga_bingkai.setText(df.format(harga));
        } else if ("Mawar".equals(bunga)){
            harga = 8000;
            harga_bingkai.setText(df.format(harga));
        } else if ("Sedap Malam".equals(bunga)){
            harga = 5000;
            harga_bingkai.setText(df.format(harga));
        } else {
            harga = 0;
            harga_bingkai.setText(df.format(harga));
        }
        
        jumlah = Float.parseFloat(jumlah_beli.getText());
        
        if (harga*jumlah>=300000){
            diskon = 0.05*harga*jumlah;
            diskon_bunga.setText(df.format(diskon));
        } else {
            diskon = 0;
            diskon_bunga.setText(df.format(diskon));
        }
        
        if (kirim_checkbox.isSelected()==true){
            if (radio_lebih_dari_15.isSelected()==true){
                ongkir=50000;
            }else if (radio_15_km.isSelected()==true){
                ongkir=20000;
            } else {
                ongkir=0;
            }
            biaya_ongkir.setText(df.format(ongkir));
        } else {
            ongkir=0;
            biaya_ongkir.setText(df.format(ongkir));
        }
        
        total=(harga*jumlah)-diskon+ongkir;
        total_bayar.setText(df.format(total));
        
        DefaultTableModel model = (DefaultTableModel) table_data.getModel();
        model.addRow(new Object[]{bunga,
            df.format(jumlah),
            df.format(ongkir),
            df.format(total)
        });
        
        totaljumlah=0;
        totalpenjualan=0;
        
        for(int i = 0; i < table_data.getRowCount(); i++){
            totaljumlah= totaljumlah + Float.parseFloat(table_data.getValueAt(i, 1).toString());
            totalpenjualan= totalpenjualan + Float.parseFloat(table_data.getValueAt(i, 3).toString());
        }
        
        total_bunga_terjual.setText(df.format(totaljumlah));
        total_pendapatan.setText(df.format(totalpenjualan));
        
        // Menyimpan data ke dalam database
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans_pertemuan13", "root", "root");
            String query = "INSERT INTO tabel_bunga (bunga, harga, jumlah, diskon, ongkir, total) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bunga);
            preparedStatement.setDouble(2, harga);
            preparedStatement.setDouble(3, jumlah);
            preparedStatement.setDouble(4, diskon);
            preparedStatement.setDouble(5, ongkir);
            preparedStatement.setDouble(6, total);

            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_simpan_buttonActionPerformed

    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        // TODO add your handling code here:
        harga_bingkai.setText("");
        jumlah_beli.setText("");
        diskon_bunga.setText("");
        biaya_ongkir.setText("");
        total_bayar.setText("");
        total_bunga_terjual.setText("");
        total_pendapatan.setText("");
        
        int i = table_data.getRowCount();
        
        DefaultTableModel dfm = (DefaultTableModel) table_data.getModel();
        for(int j = 0; j < i; j++){
            dfm.removeRow(0);
        }
    }//GEN-LAST:event_clear_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGroup;
    private javax.swing.JTextField biaya_ongkir;
    private javax.swing.JButton clear_button;
    private javax.swing.JTextField diskon_bunga;
    private javax.swing.JTextField harga_bingkai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jumlah_beli;
    private javax.swing.JCheckBox kirim_checkbox;
    private javax.swing.JComboBox<String> nama_bunga;
    private javax.swing.JRadioButton radio_15_km;
    private javax.swing.JRadioButton radio_km_5;
    private javax.swing.JRadioButton radio_lebih_dari_15;
    private javax.swing.JButton simpan_button;
    private javax.swing.JTable table_data;
    private javax.swing.JTextField total_bayar;
    private javax.swing.JTextField total_bunga_terjual;
    private javax.swing.JTextField total_pendapatan;
    // End of variables declaration//GEN-END:variables
}
