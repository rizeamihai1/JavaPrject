package Repositories;

import Models.FacturaAbonament;
import java.sql.SQLException;
import java.util.List;

public interface FacturaAbonamentRepo {
    void addFacturaAbonament(FacturaAbonament fa) throws SQLException;
    FacturaAbonament getFacturaAbonamentByID(int idFactura, int idFacturaAbonament) throws SQLException;
    List<FacturaAbonament> getAllFacturaAbonament() throws SQLException;
    void updateFacturaAbonament(FacturaAbonament fa) throws SQLException;
    void deleteFacturaAbonament(int idFactura, int idFacturaAbonament) throws SQLException;
}