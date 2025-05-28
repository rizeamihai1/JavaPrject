package Repositories;

import Models.UtilitatiPlatitePrin;
import java.sql.SQLException;
import java.util.List;

public interface UtilitatiPlatitePrinRepo {
    void addUtilitatePlatitaPrin(UtilitatiPlatitePrin upp) throws SQLException;
    UtilitatiPlatitePrin getUtilitatePlatitaPrinByID(int idUtilitate, int idFactura, int idFacturaUtilitati) throws SQLException;
    List<UtilitatiPlatitePrin> getAllUtilitatiPlatitePrin() throws SQLException;
    void updateUtilitatePlatitaPrin(UtilitatiPlatitePrin upp) throws SQLException;
    void deleteUtilitatePlatitaPrin(int idUtilitate, int idFactura, int idFacturaUtilitati) throws SQLException;
}
