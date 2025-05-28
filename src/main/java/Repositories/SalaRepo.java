package Repositories;

import Models.Sala;
import java.sql.SQLException;
import java.util.List;

public interface SalaRepo {
    void addSala(Sala sala) throws SQLException;
    Sala getSalaByID(int id) throws SQLException;
    List<Sala> getAllSali() throws SQLException;
    void updateSala(Sala sala) throws SQLException;
    void deleteSala(int id) throws SQLException;
}