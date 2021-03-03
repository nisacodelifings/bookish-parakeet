package penjualan.implement;

import penjualan.koneksi.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class transaksiImplement {
    
    public int urutanDb(){
        Connection conn = (Connection) koneksi.getConnection();
        int jml = 0;
        
        try{
            String sql = "SELECT COUNT(*) AS urutan FROM penjualan";
            Statement rs = (Statement) conn.createStatement();
            ResultSet count = rs.executeQuery(sql);
            
            while(count.next()){
                jml = count.getInt("urutan");
            }
            
            rs.close();
            count.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return ++jml;
    }
    
    public ArrayList<String> viewKdBrg() throws SQLException{
        ArrayList<String> viewNamaBrg = new ArrayList();
        
        try{
            Statement kt = koneksi.getConnection().createStatement();
            ResultSet rsKb = kt.executeQuery("SELECT kd_barang, nama_barang FROM barang");
            
            while(rsKb.next()){
                viewNamaBrg.add(rsKb.getString("kd_barang") + " - " + (rsKb.getString("nama_barang")));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return viewNamaBrg;
    }
    
    public ArrayList<String> viewIdPlg() throws SQLException{
        ArrayList<String> viewNamaPlg = new ArrayList();
        
        try{
            Statement kt = koneksi.getConnection().createStatement();
            ResultSet rsKb = kt.executeQuery("SELECT id_pelanggan, nama_pelanggan FROM pelanggan");
            
            while(rsKb.next()){
                viewNamaPlg.add(rsKb.getString("id_pelanggan") + " - " + (rsKb.getString("nama_pelanggan")));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return viewNamaPlg;
    }
}