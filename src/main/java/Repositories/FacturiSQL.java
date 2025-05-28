package Repositories;

import Models.Factura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturiSQL implements FacturiRepo {
    private String url;
    private String user;
    private String password;

    public FacturiSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver"); // sau alt driver în funcție de SGBD
    }

    @Override
    public void addFactura(Factura factura) throws SQLException {
        // without try-catch
        String sql = "INSERT INTO facturi (id_facturi, data, suma) VALUES (?, ?, ?)";
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, factura.getIdFactura());
        statement.setDate(2, (Date) factura.getData());
        statement.setDouble(3, factura.getSuma());
        statement.executeUpdate();
        conn.close();
        statement.close();
    }

    @Override
    public Factura getFacturaByID(int id) throws SQLException {
        String sql = "SELECT * FROM facturi WHERE id_facturi = ?";
        // without try-catch
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Factura factura = null;
        if (rs.next()) {
            factura = new Factura(
                    rs.getInt("id_facturi"),
                    rs.getDouble("suma"),
                    rs.getDate("data")
            );
        }
        conn.close();
        stmt.close();
        return factura;
    }

    @Override
    public List<Factura> getAllFactura() throws SQLException{
        String sql = "SELECT * FROM facturi";
        // without try-catch
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Factura> facturi = new ArrayList<>();
        while (rs.next()) {
            Factura factura = new Factura(
                    rs.getInt("id_facturi"),
                    rs.getDouble("suma"),
                    rs.getDate("data")
            );
            facturi.add(factura);
        }
        conn.close();
        stmt.close();
        return facturi;
    }

    @Override
    public void updateFactura(Factura factura) throws SQLException {
        String sql = "UPDATE facturi SET suma = ?, data = ? WHERE id_facturi = ?";
        // without try-catch
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, factura.getSuma());
        statement.setDate(2, (Date) factura.getData());
        statement.setInt(3, factura.getIdFactura());
        statement.executeUpdate();
        conn.close();
        statement.close();
    }

    @Override
    public void deleteFactura(int id) throws SQLException{
        String sql = "DELETE FROM facturi WHERE id_facturi = ?";
        // without try-catch
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        conn.close();
        statement.close();
    }

}
