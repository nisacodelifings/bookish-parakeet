package penjualan.view;

import penjualan.entity.barangEntity;
import penjualan.interfc.barangInterfc;
import penjualan.implement.barangImplement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

public class barangView extends javax.swing.JFrame {
    //Menampung getAll()
    List<barangEntity> record = new ArrayList<barangEntity>();
    //Membuat object barangImplement
    barangInterfc brgServis;
    //Membantu menampilkan data di textfield
    int row;
    JTable tabelBarang = new JTable();
    
    public barangView() {
        initComponents();
        this.getContentPane().setBackground(Color.pink);
        
        brgServis = new barangImplement();
        tabelBarang.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                row = tabelBarang.getSelectedRow();
                System.out.println(row);
                if(row != -1){
                    isiText();
                }
            }
        });
        this.statusAwal();
    }
    
    void statusAwal(){
        kosongkanText();
        loadData();
        isiTabel();
    }
    
    void kosongkanText(){
        this.txt_kdBarang.setText("");
        this.txt_namaBarang.setText("");
        this.txt_jumlahBarang.setText("");
        this.txt_hargaBarang.setText("");
    }
    
    void loadData(){
        try {
            record = brgServis.getAll();
        }
        catch (SQLException ex) {
            Logger.getLogger(barangView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel(){
        Object data[][] = new Object[record.size()][4];
        int x = 0;
        
        for(barangEntity brg:record){
            data[x][0] = brg.getKd_barang();
            data[x][1] = brg.getNama_barang();
            data[x][2] = brg.getJumlah();
            data[x][3] = brg.getHarga();
            x++;
        }
        String judul[] = {"kd_barang", "nama_barang", "stok_barang", "harga_barang"};
        tabelBarang.setModel(new DefaultTableModel(data, judul));
        jScrollPane.setViewportView(tabelBarang);
    }
    
    void isiText(){
        barangEntity brg = record.get(row);
        this.txt_kdBarang.setText(brg.getKd_barang());
        this.txt_namaBarang.setText(brg.getNama_barang());
        this.txt_jumlahBarang.setText(brg.getJumlah()+" ");
        this.txt_hargaBarang.setText(brg.getHarga()+" ");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_kdBarang = new javax.swing.JTextField();
        txt_namaBarang = new javax.swing.JTextField();
        txt_jumlahBarang = new javax.swing.JTextField();
        txt_hargaBarang = new javax.swing.JTextField();
        btn_tambahBarang = new javax.swing.JButton();
        btn_editBarang = new javax.swing.JButton();
        btn_hapusBarang = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tableBarang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Kode Barang");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nama Barang");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Jumlah");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Harga");

        txt_hargaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaBarangActionPerformed(evt);
            }
        });

        btn_tambahBarang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_tambahBarang.setText("Tambah");
        btn_tambahBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahBarangActionPerformed(evt);
            }
        });

        btn_editBarang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_editBarang.setText("Ubah");
        btn_editBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editBarangActionPerformed(evt);
            }
        });

        btn_hapusBarang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_hapusBarang.setText("Hapus");
        btn_hapusBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusBarangActionPerformed(evt);
            }
        });

        tableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Kode Barang", "Nama Barang", "Jumlah", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
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
        jScrollPane.setViewportView(tableBarang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_jumlahBarang)
                            .addComponent(txt_hargaBarang)
                            .addComponent(txt_kdBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                            .addComponent(txt_namaBarang)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btn_tambahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btn_editBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_hapusBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_kdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_jumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_hapusBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_hargaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaBarangActionPerformed

    private void btn_tambahBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahBarangActionPerformed
        try{
            barangEntity brg = new barangEntity();
            brg.setKd_barang(this.txt_kdBarang.getText());
            brg.setNama_barang(this.txt_namaBarang.getText());
            brg.setJumlah(this.txt_jumlahBarang.getText());
            brg.setHarga(this.txt_hargaBarang.getText());
            brgServis.insert(brg);
            
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data Tersimpan");
        }
        catch(SQLException ex){
            Logger.getLogger(barangView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btn_tambahBarangActionPerformed

    private void btn_editBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editBarangActionPerformed
        try{
            barangEntity brg = new barangEntity();
            brg.setKd_barang(this.txt_kdBarang.getText());
            brg.setNama_barang(this.txt_namaBarang.getText());
            brg.setJumlah(this.txt_jumlahBarang.getText());
            brg.setHarga(this.txt_hargaBarang.getText());
            brgServis.update(brg);
            
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
        }
        catch(SQLException ex){
            Logger.getLogger(barangView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btn_editBarangActionPerformed
    
    private void btn_hapusBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusBarangActionPerformed
        barangEntity brg = new barangEntity();
        String kd_barang = this.txt_kdBarang.getText();
        
        try{
            brgServis.delete(kd_barang);
        }
        catch(SQLException ex){
            Logger.getLogger(barangView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }
            
        this.statusAwal();
        JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
    }//GEN-LAST:event_btn_hapusBarangActionPerformed

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
            java.util.logging.Logger.getLogger(barangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editBarang;
    private javax.swing.JButton btn_hapusBarang;
    private javax.swing.JButton btn_tambahBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable tableBarang;
    private javax.swing.JTextField txt_hargaBarang;
    private javax.swing.JTextField txt_jumlahBarang;
    private javax.swing.JTextField txt_kdBarang;
    private javax.swing.JTextField txt_namaBarang;
    // End of variables declaration//GEN-END:variables
}
