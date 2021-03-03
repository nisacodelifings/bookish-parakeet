package penjualan.koneksi;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class koneksi {
    public static Connection conn;
    public static Connection getConnection(){
        if(conn == null){
            try{
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pbo_mvc", "root", "");
            }
            catch(SQLException ex){
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return conn;
    }
}