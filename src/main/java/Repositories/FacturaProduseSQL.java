package Repositories;

import Models.FacturaProduse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaProduseSQL implements FacturaProduseRepo {
    private final String url;
    private final String user;
    private final String password;

    public FacturaProduseSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Override
    public void addFacturaProduse(FacturaProduse factura) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO facturi_produse (id_factura, suma, data, id_factura_produse, id_achizitie) VALUES (?, ?, ?, ?, ?)"
        );
        ps.setInt(1, factura.getIdFactura());
        ps.setDouble(2, factura.getSuma());
        ps.setDate(3, new java.sql.Date(factura.getData().getTime()));
        ps.setInt(4, factura.getIdFacturaProduse());
        ps.setInt(5, factura.getIdAchizitie());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public FacturaProduse getFacturaProduseByID(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM facturi_produse WHERE id_factura_produse = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        FacturaProduse factura = null;
        if (rs.next()) {
            factura = new FacturaProduse(
                    rs.getInt("id_factura"),
                    rs.getDouble("suma"),
                    rs.getDate("data"),
                    rs.getInt("id_factura_produse"),
                    rs.getInt("id_achizitie")
            );
        }
        rs.close();
        ps.close();
        conn.close();
        return factura;
    }

    @Override
    public List<FacturaProduse> getAllFacturiProduse() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM facturi_produse");
        List<FacturaProduse> facturi = new ArrayList<>();
        while (rs.next()) {
            facturi.add(new FacturaProduse(
                    rs.getInt("id_factura"),
                    rs.getDouble("suma"),
                    rs.getDate("data"),
                    rs.getInt("id_factura_produse"),
                    rs.getInt("id_achizitie")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return facturi;
    }

    @Override
    public void updateFacturaProduse(FacturaProduse factura) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE facturi_produse SET suma = ?, data = ?, id_achizitie = ? WHERE id_factura_produse = ?"
        );
        ps.setDouble(1, factura.getSuma());
        ps.setDate(2, new java.sql.Date(factura.getData().getTime()));
        ps.setInt(3, factura.getIdAchizitie());
        ps.setInt(4, factura.getIdFacturaProduse());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public void deleteFacturaProduse(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement("DELETE FROM facturi_produse WHERE id_factura_produse = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}