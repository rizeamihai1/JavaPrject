package Repositories;

import Models.DetaliiAchizitie;
import java.sql.SQLException;
import java.util.List;

public interface DetaliiAchizitieRepo {
    void addDetaliiAchizitie(DetaliiAchizitie detalii) throws SQLException;
    DetaliiAchizitie getDetaliiAchizitieByID(int idDetalii) throws SQLException;
    List<DetaliiAchizitie> getAllDetaliiAchizitie() throws SQLException;
    void updateDetaliiAchizitie(DetaliiAchizitie detalii) throws SQLException;
    void deleteDetaliiAchizitie(int idDetalii) throws SQLException;
}