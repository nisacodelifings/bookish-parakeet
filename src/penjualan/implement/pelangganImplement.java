package penjualan.implement;

import penjualan.entity.pelangganEntity;
import penjualan.interfc.pelangganInterfc;
import penjualan.koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class pelangganImplement implements pelangganInterfc{

    @Override
    public pelangganEntity insert(pelangganEntity o) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("INSERT INTO pelanggan values (?,?,?,?,?)");
        st.setString(1, o.getIdpelanggan());
        st.setString(2, o.getNama_pelanggan());
        st.setString(3, o.getJenis_kelamin());
        st.setString(4, o.getAlamat());
        st.setString(5, o.getNo_telepon());
        st.executeUpdate();
        return o;
        
    }

    @Override
    public void update(pelangganEntity o) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement(
                "UPDATE pelanggan SET nama_pelanggan=?, jenis_kelamin=?, alamat=?, no_telepon=? WHERE id_pelanggan=?"
        );
        st.setString(1, o.getNama_pelanggan());
        st.setString(2, o.getJenis_kelamin());
        st.setString(3, o.getAlamat());
        st.setString(4, o.getNo_telepon());
        st.setString(5, o.getIdpelanggan());
        st.executeUpdate();
    }

    @Override
    public void delete(String id_pelanggan) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("DELETE FROM pelanggan WHERE id_pelanggan=?");
        st.setString(1, id_pelanggan);
        st.executeUpdate();
    }

    @Override
    public List<pelangganEntity> getAll() throws SQLException {
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT*FROM pelanggan");
        List<pelangganEntity> list = new ArrayList<pelangganEntity>();
        
        while(rs.next()){
            pelangganEntity plg = new pelangganEntity();
            plg.setIdpelanggan(rs.getString("id_pelanggan"));
            plg.setNama_pelanggan(rs.getString("nama_pelanggan"));
            plg.setJenis_kelamin(rs.getString("jenis_kelamin"));
            plg.setAlamat(rs.getString("alamat"));
            plg.setNo_telepon(rs.getString("no_telepon"));
            list.add(plg);
        }
        
        return list;
    }
}