package Repositories;

import Models.Produs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdusSQL implements ProdusRepo {
    private final String url;
    private final String user;
    private final String password;

    public ProdusSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Override
    public void addProdus(Produs produs) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO produse (id_produse, nume, cantitate, pret) VALUES (?, ?, ?, ?)"
        );
        ps.setInt(1, produs.getIdProdus());
        ps.setString(2, produs.getNume());
        ps.setInt(3, produs.getCantitate());
        ps.setDouble(4, produs.getPret());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public Produs getProdusByID(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM produse WHERE id_produs = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Produs produs = null;
        if (rs.next()) {
            produs = new Produs(
                    rs.getInt("id_produse"),
                    rs.getString("nume"),
                    rs.getInt("cantitate"),
                    rs.getDouble("pret")
            );
        }
        rs.close();
        ps.close();
        conn.close();
        return produs;
    }

    @Override
    public List<Produs> getAllProduse() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM produse");
        List<Produs> produse = new ArrayList<>();
        while (rs.next()) {
            produse.add(new Produs(
                    rs.getInt("id_produse"),
                    rs.getString("nume"),
                    rs.getInt("cantitate"),
                    rs.getDouble("pret")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return produse;
    }

    @Override
    public void updateProdus(Produs produs) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE produse SET nume = ?, cantitate = ?, pret = ? WHERE id_produse = ?"
        );
        ps.setString(1, produs.getNume());
        ps.setInt(2, produs.getCantitate());
        ps.setDouble(3, produs.getPret());
        ps.setInt(4, produs.getIdProdus());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public void deleteProdus(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement("DELETE FROM produse WHERE id_produse = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}