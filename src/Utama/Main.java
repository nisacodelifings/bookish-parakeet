package Utama;

import java.sql.SQLException;
import java.sql.Connection;
import penjualan.view.barangView;
import penjualan.view.pelangganView;
import penjualan.view.transaksiView;

public class Main {
    public static void main(String[] args) throws SQLException {
//        penjualan pj = new penjualan();
//        barangView pj = new barangView();
        pelangganView pj = new pelangganView();
//        transaksiView pj = new transaksiView();
        pj.setVisible(true);
    }
}