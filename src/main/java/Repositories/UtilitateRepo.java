package Repositories;
import Models.*;

import java.sql.SQLException;
import java.util.*;

public interface UtilitateRepo {
    void addUtilitate(Utilitate utilitate) throws SQLException;
    Utilitate getUtilitateById(int idUtilitate) throws SQLException;
    List<Utilitate> getAllUtilitati() throws SQLException;
    void removeUtilitate(int idUtilitate) throws SQLException;
    void updateUtilitate(Utilitate utilitate) throws SQLException;
}
