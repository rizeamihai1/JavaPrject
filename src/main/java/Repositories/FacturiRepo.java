package Repositories;
import Models.*;

import java.sql.SQLException;
import java.util.List;
public interface FacturiRepo {
    void addFactura(Factura factura) throws SQLException;
    Factura getFacturaByID(int id) throws SQLException;
    List<Factura> getAllFactura() throws SQLException;
    void updateFactura(Factura factura) throws SQLException;
    void deleteFactura(int id) throws SQLException;

}
