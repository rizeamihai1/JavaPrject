package Repositories;

import Models.UtilitatiPlatitePrin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UtilitatiPlatitePrinSQL implements UtilitatiPlatitePrinRepo {
    private final String url;
    private final String user;
    private final String password;

    public UtilitatiPlatitePrinSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Override
    public void addUtilitatePlatitaPrin(UtilitatiPlatitePrin upp) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO utilitati_platite_prin (id_utilitati, id_facturi, id_facturi_utilitati) VALUES (?, ?, ?)"
        );
        ps.setInt(1, upp.getIdUtilitate());
        ps.setInt(2, upp.getIdFactura());
        ps.setInt(3, upp.getIdFacturaUtilitati());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public UtilitatiPlatitePrin getUtilitatePlatitaPrinByID(int idUtilitate, int idFactura, int idFacturaUtilitati) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM utilitati_platite_prin WHERE id_utilitati = ? AND id_facturi = ? AND id_facturi_utilitati = ?"
        );
        ps.setInt(1, idUtilitate);
        ps.setInt(2, idFactura);
        ps.setInt(3, idFacturaUtilitati);
        ResultSet rs = ps.executeQuery();
        UtilitatiPlatitePrin upp = null;
        if (rs.next()) {
            upp = new UtilitatiPlatitePrin(
                    rs.getInt("id_utilitati"),
                    rs.getInt("id_facturi"),
                    rs.getInt("id_facturi_utilitati")
            );
        }
        rs.close();
        ps.close();
        conn.close();
        return upp;
    }

    @Override
    public List<UtilitatiPlatitePrin> getAllUtilitatiPlatitePrin() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM utilitati_platite_prin");
        List<UtilitatiPlatitePrin> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new UtilitatiPlatitePrin(
                    rs.getInt("id_utilitati"),
                    rs.getInt("id_facturi"),
                    rs.getInt("id_facturi_utilitati")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }

    @Override
    public void updateUtilitatePlatitaPrin(UtilitatiPlatitePrin upp) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE utilitati_platite_prin " +
                        "SET id_utilitati = ?, id_facturi = ?, id_facturi_utilitati = ? " +
                        "WHERE id_utilitati = ? AND id_facturi = ? AND id_facturi_utilitati = ?"
        );
        ps.setInt(1, upp.getIdUtilitate());
        ps.setInt(2, upp.getIdFactura());
        ps.setInt(3, upp.getIdFacturaUtilitati());
        // folosim aceleași valori în WHERE (cheia composite nu se schimbă)
        ps.setInt(4, upp.getIdUtilitate());
        ps.setInt(5, upp.getIdFactura());
        ps.setInt(6, upp.getIdFacturaUtilitati());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public void deleteUtilitatePlatitaPrin(int idUtilitate, int idFactura, int idFacturaUtilitati) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM utilitati_platite_prin WHERE id_utilitati = ? AND id_facturi = ? AND id_facturi_utilitati = ?"
        );
        ps.setInt(1, idUtilitate);
        ps.setInt(2, idFactura);
        ps.setInt(3, idFacturaUtilitati);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
