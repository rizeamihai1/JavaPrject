package Repositories;

import Models.Abonament;
import java.sql.SQLException;
import java.util.List;

public interface AbonamentRepo {
    void addAbonament(Abonament abonament) throws SQLException;
    Abonament getAbonamentByID(int idAbonament) throws SQLException;
    List<Abonament> getAllAbonamente() throws SQLException;
    void updateAbonament(Abonament abonament) throws SQLException;
    void deleteAbonament(int idAbonament) throws SQLException;
}