package Repositories;

import Models.FacturaUtilitati;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaUtilitatiSQL implements FacturaUtilitatiRepo {
    private final String url;
    private final String user;
    private final String password;

    public FacturaUtilitatiSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Override
    public void addFacturaUtilitati(FacturaUtilitati factura) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO facturi_utilitati (id_factura, suma, data, id_factura_utilitati, id_utilitate) VALUES (?, ?, ?, ?, ?)"
        );
        ps.setInt(1, factura.getIdFactura());
        ps.setDouble(2, factura.getSuma());
        ps.setDate(3, new java.sql.Date(factura.getData().getTime()));
        ps.setInt(4, factura.getIdFacturaUtilitati());
        ps.setInt(5, factura.getIdUtilitate());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public FacturaUtilitati getFacturaUtilitatiByID(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM facturi_utilitati WHERE id_factura_utilitati = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        FacturaUtilitati factura = null;
        if (rs.next()) {
            factura = new FacturaUtilitati(
                    rs.getInt("id_factura"),
                    rs.getDouble("suma"),
                    rs.getDate("data"),
                    rs.getInt("id_factura_utilitati"),
                    rs.getInt("id_utilitate")
            );
        }
        rs.close();
        ps.close();
        conn.close();
        return factura;
    }

    @Override
    public List<FacturaUtilitati> getAllFacturiUtilitati() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM facturi_utilitati");
        List<FacturaUtilitati> facturi = new ArrayList<>();
        while (rs.next()) {
            facturi.add(new FacturaUtilitati(
                    rs.getInt("id_factura"),
                    rs.getDouble("suma"),
                    rs.getDate("data"),
                    rs.getInt("id_factura_utilitati"),
                    rs.getInt("id_utilitate")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return facturi;
    }

    @Override
    public void updateFacturaUtilitati(FacturaUtilitati factura) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE facturi_utilitati SET suma = ?, data = ?, id_utilitate = ? WHERE id_factura_utilitati = ?"
        );
        ps.setDouble(1, factura.getSuma());
        ps.setDate(2, new java.sql.Date(factura.getData().getTime()));
        ps.setInt(3, factura.getIdUtilitate());
        ps.setInt(4, factura.getIdFacturaUtilitati());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public void deleteFacturaUtilitati(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement("DELETE FROM facturi_utilitati WHERE id_factura_utilitati = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}