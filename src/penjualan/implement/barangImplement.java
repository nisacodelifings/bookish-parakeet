package penjualan.implement;

import penjualan.entity.barangEntity;
import penjualan.interfc.barangInterfc;
import penjualan.koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class barangImplement implements barangInterfc{

    @Override
    public barangEntity insert(barangEntity o) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("INSERT INTO barang values (?,?,?,?)");
        st.setString(1, o.getKd_barang());
        st.setString(2, o.getNama_barang());
        st.setString(3, o.getJumlah());
        st.setString(4, o.getHarga());
        st.executeUpdate();
        return o;
    }

    @Override
    public void update(barangEntity o) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement(
                "UPDATE barang SET nama_barang=?, stok_barang=?, harga_barang=? WHERE kd_barang=?"
        );
        st.setString(1, o.getNama_barang());
        st.setString(2, o.getJumlah());
        st.setString(3, o.getHarga());
        st.setString(4, o.getKd_barang());
        System.out.println(o.getKd_barang());
        st.executeUpdate();
    }

    @Override
    public void delete(String kd_barang) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("DELETE FROM barang WHERE kd_barang=?");
        st.setString(1, kd_barang);
        st.executeUpdate();
    }

    @Override
    public List<barangEntity> getAll() throws SQLException {
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT*FROM barang");
        List<barangEntity> list = new ArrayList<barangEntity>();
        
        while(rs.next()){
            barangEntity brg = new barangEntity();
            brg.setKd_barang(rs.getString("kd_barang"));
            brg.setNama_barang(rs.getString("nama_barang"));
            brg.setJumlah(rs.getString("stok_barang"));
            brg.setHarga(rs.getString("harga_barang"));
            list.add(brg);
        }
        
        return list;
    }
}