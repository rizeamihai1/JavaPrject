package Repositories;

import Models.Produs;
import java.sql.SQLException;
import java.util.List;

public interface ProdusRepo {
    void addProdus(Produs produs) throws SQLException;
    Produs getProdusByID(int id) throws SQLException;
    List<Produs> getAllProduse() throws SQLException;
    void updateProdus(Produs produs) throws SQLException;
    void deleteProdus(int id) throws SQLException;
}