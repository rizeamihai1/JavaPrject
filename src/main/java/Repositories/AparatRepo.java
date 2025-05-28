package Repositories;

import java.sql.SQLException;
import java.util.List;

import Models.Aparat;

public interface AparatRepo {
    void addAparat(Aparat aparat) throws SQLException;
    Aparat getAparatByID(int id) throws SQLException;
    List<Aparat> getAllAparat() throws SQLException;
    void updateAparat(Aparat aparat) throws SQLException;
    void deleteAparat(int id) throws SQLException;
}
