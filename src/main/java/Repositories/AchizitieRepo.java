package Repositories;

import Models.Achizitie;
import java.sql.SQLException;
import java.util.List;

public interface AchizitieRepo {
    void addAchizitie(Achizitie achizitie) throws SQLException;
    Achizitie getAchizitieByID(int idAchizitie) throws SQLException;
    List<Achizitie> getAllAchizitii() throws SQLException;
    void updateAchizitie(Achizitie achizitie) throws SQLException;
    void deleteAchizitie(int idAchizitie) throws SQLException;
}