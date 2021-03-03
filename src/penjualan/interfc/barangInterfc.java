package penjualan.interfc;

import penjualan.entity.barangEntity;
import java.sql.SQLException;
import java.util.List;

public interface barangInterfc {
    barangEntity insert(barangEntity o) throws SQLException;
    void update(barangEntity o) throws SQLException;
    void delete(String kd_barang) throws SQLException;
    List getAll() throws SQLException;
}