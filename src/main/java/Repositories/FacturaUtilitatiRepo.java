package Repositories;

import Models.FacturaUtilitati;
import java.sql.SQLException;
import java.util.List;

public interface FacturaUtilitatiRepo {
    void addFacturaUtilitati(FacturaUtilitati factura) throws SQLException;
    FacturaUtilitati getFacturaUtilitatiByID(int id) throws SQLException;
    List<FacturaUtilitati> getAllFacturiUtilitati() throws SQLException;
    void updateFacturaUtilitati(FacturaUtilitati factura) throws SQLException;
    void deleteFacturaUtilitati(int id) throws SQLException;
}