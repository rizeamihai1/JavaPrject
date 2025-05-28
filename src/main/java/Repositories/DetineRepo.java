package Repositories;

import Models.Detine;
import java.sql.SQLException;
import java.util.List;

public interface DetineRepo {
    void addDetine(Detine detine) throws SQLException;
    Detine getDetineByIDs(int idSala, int idProdus) throws SQLException;
    List<Detine> getAllDetine() throws SQLException;
    void updateDetine(Detine detine, int oldIdSala, int oldIdProdus) throws SQLException;
    void deleteDetine(int idSala, int idProdus) throws SQLException;
}