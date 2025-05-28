package Repositories;

import Models.FacturaProduse;
import java.sql.SQLException;
import java.util.List;

public interface FacturaProduseRepo {
    void addFacturaProduse(FacturaProduse factura) throws SQLException;
    FacturaProduse getFacturaProduseByID(int id) throws SQLException;
    List<FacturaProduse> getAllFacturiProduse() throws SQLException;
    void updateFacturaProduse(FacturaProduse factura) throws SQLException;
    void deleteFacturaProduse(int id) throws SQLException;
}