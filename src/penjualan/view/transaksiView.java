package penjualan.view;

import java.sql.SQLException;
import java.sql.Connection;
import penjualan.koneksi.koneksi;
import penjualan.implement.transaksiImplement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

public class transaksiView extends javax.swing.JFrame {
    private DefaultTableModel model;
    
    public transaksiView() throws SQLException{
        initComponents();
        this.getContentPane().setBackground(Color.pink);
        
        model = new DefaultTableModel();
        tableTransaksi.setModel(model);
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Jumlah Beli");
        model.addColumn("Subtotal");
        
        dateNow();
        genFak();
        setKodeBarang();
        setIdPelanggan();
    }
    
    private void dateNow() {
        Date tglJual = new Date();
        SimpleDateFormat tglFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dmy = tglFormat.format(tglJual);
        this.txt_tglTransaksi.setText(dmy);
    }

    private void genFak() {
        transaksiImplement getUrutan = new transaksiImplement();
        String kd_awal = "PO";
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        int urutan = getUrutan.urutanDb();
        
        StringBuffer strValues = new StringBuffer();
        strValues.append(kd_awal);
        strValues.append(" - ");
        strValues.append(String.valueOf(year));
        strValues.append(String.valueOf(month));
        strValues.append(String.valueOf(day));
        strValues.append(" - ");
        strValues.append(String.valueOf(urutan));
        String no_faktur = strValues.toString();
        
        this.txt_noFaktur.setText(no_faktur);
    }

    private void setKodeBarang() throws SQLException {
        transaksiImplement getKdBrg = new transaksiImplement();
        ArrayList<String> urutanArr = getKdBrg.viewKdBrg();
        this.cbx_namaBarang.addItem("-- Pilih --");
        
        for(Object o : urutanArr){
            this.cbx_namaBarang.addItem((String) o);
        }
    }
    
    private void setIdPelanggan() throws SQLException {
        transaksiImplement getIdPlg = new transaksiImplement();
        ArrayList<String> urutanArr = getIdPlg.viewIdPlg();
        this.cbx_namaPelanggan.addItem("-- Pilih --");
        
        for(Object o : urutanArr){
            this.cbx_namaPelanggan.addItem((String) o);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_noFaktur = new javax.swing.JTextField();
        txt_tglTransaksi = new javax.swing.JTextField();
        txt_noTelepon = new javax.swing.JTextField();
        txt_stokBarang = new javax.swing.JTextField();
        txt_hargaBarang = new javax.swing.JTextField();
        txt_jumlahBeli = new javax.swing.JTextField();
        txt_totalBayar = new javax.swing.JTextField();
        btn_tambahDataTransaksi = new javax.swing.JButton();
        btn_simpanKeKeranjang = new javax.swing.JButton();
        btn_hapusDariKeranjang = new javax.swing.JButton();
        btn_SimpanTransaksi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTransaksi = new javax.swing.JTable();
        cbx_namaPelanggan = new javax.swing.JComboBox<>();
        cbx_namaBarang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Transaksi Penjualan");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("No. Faktur");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tanggal Transaksi");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Data Pelanggan");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Data Barang");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Nama Pelanggan");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Alamat");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("No. Telepon");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Nama Barang");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Stok Barang");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Harga");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Jumlah Pembelian");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Total Pembayaran");

        txt_noFaktur.setEnabled(false);

        txt_tglTransaksi.setEnabled(false);

        txt_noTelepon.setEditable(false);
        txt_noTelepon.setEnabled(false);

        txt_stokBarang.setEditable(false);
        txt_stokBarang.setEnabled(false);

        txt_hargaBarang.setEditable(false);
        txt_hargaBarang.setEnabled(false);

        txt_jumlahBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahBeliActionPerformed(evt);
            }
        });

        txt_totalBayar.setEditable(false);
        txt_totalBayar.setEnabled(false);

        btn_tambahDataTransaksi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_tambahDataTransaksi.setText("Tambah Data Transaksi");

        btn_simpanKeKeranjang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_simpanKeKeranjang.setText("Simpan Ke Keranjang");
        btn_simpanKeKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanKeKeranjangActionPerformed(evt);
            }
        });

        btn_hapusDariKeranjang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_hapusDariKeranjang.setText("Hapus");
        btn_hapusDariKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusDariKeranjangActionPerformed(evt);
            }
        });

        btn_SimpanTransaksi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_SimpanTransaksi.setText("Simpan");

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        txt_alamat.setEnabled(false);
        jScrollPane1.setViewportView(txt_alamat);

        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Barang", "Harga", "Jumlah Pembelian", "Total Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableTransaksi);

        cbx_namaPelanggan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_namaPelangganItemStateChanged(evt);
            }
        });

        cbx_namaBarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_namaBarangItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(250, 250, 250)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(btn_simpanKeKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(226, 226, 226)
                        .addComponent(btn_hapusDariKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(212, 212, 212)
                                            .addComponent(btn_tambahDataTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(40, 40, 40)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_noTelepon, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                                .addComponent(txt_noFaktur, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                                .addComponent(cbx_namaPelanggan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(40, 40, 40)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                                    .addComponent(txt_tglTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txt_hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txt_jumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(cbx_namaBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txt_stokBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))))))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_SimpanTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(txt_totalBayar)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_noFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tglTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_tambahDataTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbx_namaPelanggan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbx_namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_stokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_noTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_jumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_simpanKeKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapusDariKeranjang))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_totalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_SimpanTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_jumlahBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahBeliActionPerformed

    private void cbx_namaBarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_namaBarangItemStateChanged
        String kode = (String) this.cbx_namaBarang.getSelectedItem();
        String kodeFix = kode.substring(0,4);
        
        try{
            Statement ktB = koneksi.getConnection().createStatement();
            ResultSet rsKbR = ktB.executeQuery(
                    "SELECT stok_barang, harga_barang FROM barang WHERE kd_barang = '"+kodeFix+"'"
            );
            
            while(rsKbR.next()){
                this.txt_stokBarang.setText(rsKbR.getString("stok_barang"));
                this.txt_hargaBarang.setText(rsKbR.getString("harga_barang"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbx_namaBarangItemStateChanged

    private void cbx_namaPelangganItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_namaPelangganItemStateChanged
        String kode = (String) this.cbx_namaPelanggan.getSelectedItem();
        String kodeFix = kode.substring(0,4);
        
        try{
            Statement ktB = koneksi.getConnection().createStatement();
            ResultSet rsKbR = ktB.executeQuery(
                    "SELECT alamat, no_telepon FROM pelanggan WHERE id_pelanggan = '"+kodeFix+"'"
            );
            
            while(rsKbR.next()){
                this.txt_alamat.setText(rsKbR.getString("alamat"));
                this.txt_noTelepon.setText(rsKbR.getString("no_telepon"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbx_namaPelangganItemStateChanged

    private void btn_simpanKeKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanKeKeranjangActionPerformed
        String kode = (String) this.cbx_namaBarang.getSelectedItem();
        String kodeFix = kode.substring(0,4);
        String namaBrg = kode.substring(5,kode.length()-0);
        int hrg = Integer.valueOf(this.txt_hargaBarang.getText());
        int jml = Integer.valueOf(this.txt_jumlahBeli.getText());
        long subTotal = hrg * jml;
        
        Object[] data = new Object[5];
        data[0] = kodeFix;
        data[1] = namaBrg;
        data[2] = this.txt_hargaBarang.getText();
        data[3] = this.txt_jumlahBeli.getText();
        data[4] = subTotal;
        
        model.addRow(data);
        this.hitungTotalBayar();
        this.kosongkanData();
    }//GEN-LAST:event_btn_simpanKeKeranjangActionPerformed

    private void btn_hapusDariKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusDariKeranjangActionPerformed
        int delData = this.tableTransaksi.getSelectedRow();
        
        if(delData == -1){
            return;
        }
        else{
            model.removeRow(delData);
            this.hitungTotalBayar();
        }
    }//GEN-LAST:event_btn_hapusDariKeranjangActionPerformed

    private void hitungTotalBayar(){
        int jmlRow = this.tableTransaksi.getRowCount();
        int total = 0;
        
        if(jmlRow == 0){
            return;
        }
        else{
            for(int i = 0; i < jmlRow; i++){
                int jmlTotal = Integer.valueOf((String.valueOf(model.getValueAt(i, 4))));
                total += jmlTotal;
            }
        }
        
        this.txt_totalBayar.setText(String.valueOf(total));
    }
    
    private void kosongkanData(){
        this.cbx_namaBarang.setSelectedItem("-- Pilih --");
        this.txt_stokBarang.setText("");
        this.txt_hargaBarang.setText("");
        this.txt_jumlahBeli.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(transaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new transaksiView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(transaksiView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_SimpanTransaksi;
    private javax.swing.JButton btn_hapusDariKeranjang;
    private javax.swing.JButton btn_simpanKeKeranjang;
    private javax.swing.JButton btn_tambahDataTransaksi;
    private javax.swing.JComboBox<String> cbx_namaBarang;
    private javax.swing.JComboBox<String> cbx_namaPelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableTransaksi;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_hargaBarang;
    private javax.swing.JTextField txt_jumlahBeli;
    private javax.swing.JTextField txt_noFaktur;
    private javax.swing.JTextField txt_noTelepon;
    private javax.swing.JTextField txt_stokBarang;
    private javax.swing.JTextField txt_tglTransaksi;
    private javax.swing.JTextField txt_totalBayar;
    // End of variables declaration//GEN-END:variables
}