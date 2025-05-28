package Repositories;

import Models.FacturaAbonament;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaAbonamentSQL implements FacturaAbonamentRepo {
    private final String url;
    private final String user;
    private final String password;

    public FacturaAbonamentSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Override
    public void addFacturaAbonament(FacturaAbonament fa) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO facturi_abonament (id_facturi, id_facturi_abonament, id_client) VALUES (?, ?, ?)"
        );
        ps.setInt(1, fa.getIdFactura());
        ps.setInt(2, fa.getIdFacturaAbonament());
        ps.setInt(3, fa.getIdClient());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public FacturaAbonament getFacturaAbonamentByID(int idFactura, int idFacturaAbonament) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "SELECT f.id_facturi, f.suma, f.data, fa.id_facturi_abonament, fa.id_client\n" +
                        "FROM facturi_abonament fa\n" +
                        "JOIN facturi f ON f.id_facturi = fa.id_facturi\n" +
                        "WHERE fa.id_facturi = ? AND fa.id_facturi_abonament = ?"
        );
        ps.setInt(1, idFactura);
        ps.setInt(2, idFacturaAbonament);
        ResultSet rs = ps.executeQuery();
        FacturaAbonament fa = null;
        if (rs.next()) {
            fa = new FacturaAbonament(
                    rs.getInt("id_facturi"),
                    rs.getDouble("suma"),
                    rs.getDate("data"),
                    rs.getInt("id_facturi_abonament"),
                    rs.getInt("id_client")
            );
        }
        rs.close();
        ps.close();
        conn.close();
        return fa;
    }

    @Override
    public List<FacturaAbonament> getAllFacturaAbonament() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql =
                "SELECT f.id_facturi, f.suma, f.data, fa.id_facturi_abonament, fa.id_client\n" +
                        "FROM facturi_abonament fa\n" +
                        "JOIN facturi f ON f.id_facturi = fa.id_facturi";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<FacturaAbonament> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new FacturaAbonament(
                    rs.getInt("id_facturi"),
                    rs.getDouble("suma"),
                    rs.getDate("data"),
                    rs.getInt("id_facturi_abonament"),
                    rs.getInt("id_client")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }

    @Override
    public void updateFacturaAbonament(FacturaAbonament fa) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE facturi_abonament SET id_client = ?\n" +
                        "WHERE id_facturi = ? AND id_facturi_abonament = ?"
        );
        ps.setInt(1, fa.getIdClient());
        ps.setInt(2, fa.getIdFactura());
        ps.setInt(3, fa.getIdFacturaAbonament());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public void deleteFacturaAbonament(int idFactura, int idFacturaAbonament) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM facturi_abonament WHERE id_facturi = ? AND id_facturi_abonament = ?"
        );
        ps.setInt(1, idFactura);
        ps.setInt(2, idFacturaAbonament);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}