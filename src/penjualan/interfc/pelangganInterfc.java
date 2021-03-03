package penjualan.interfc;

import penjualan.entity.pelangganEntity;
import java.sql.SQLException;
import java.util.List;

public interface pelangganInterfc {
    pelangganEntity insert(pelangganEntity o) throws SQLException;
    void update(pelangganEntity o) throws SQLException;
    void delete(String id_pelanggan) throws SQLException;
    List getAll() throws SQLException;
}