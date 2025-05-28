package Repositories;

import Models.Sala;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaSQL implements SalaRepo {
    private final String url;
    private final String user;
    private final String password;

    public SalaSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Override
    public void addSala(Sala sala) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO sala (id_sala, nr_clienti, venituri, nr_produse, nume_manager, deschis) VALUES (?, ?, ?, ?, ?, ?)"
        );
        ps.setInt(1, sala.getIdSala());
        ps.setInt(2, sala.getNrClienti());
        ps.setDouble(3, sala.getVenituri());
        ps.setInt(4, sala.getNrProduse());
        ps.setString(5, sala.getNumeManager());
        ps.setString(6, sala.getDeschis());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public Sala getSalaByID(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM sala WHERE id_sala = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Sala sala = null;
        if (rs.next()) {
            sala = new Sala(
                    rs.getInt("id_sala"),
                    rs.getInt("nr_clienti"),
                    rs.getDouble("venituri"),
                    rs.getInt("nr_produse"),
                    rs.getString("nume_manager"),
                    rs.getString("deschis"),
                    null, null, null // Utilitati, Produse, Abonamente
            );
        }
        rs.close();
        ps.close();
        conn.close();
        return sala;
    }

    @Override
    public List<Sala> getAllSali() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM sala");
        List<Sala> sali = new ArrayList<>();
        while (rs.next()) {
            sali.add(new Sala(
                    rs.getInt("id_sala"),
                    rs.getInt("nr_clienti"),
                    rs.getDouble("venituri"),
                    rs.getInt("nr_produse"),
                    rs.getString("nume_manager"),
                    rs.getString("deschis"),
                    null, null, null
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return sali;
    }

    @Override
    public void updateSala(Sala sala) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE sala SET nr_clienti = ?, venituri = ?, nr_produse = ?, nume_manager = ?, deschis = ? WHERE id_sala = ?"
        );
        ps.setInt(1, sala.getNrClienti());
        ps.setDouble(2, sala.getVenituri());
        ps.setInt(3, sala.getNrProduse());
        ps.setString(4, sala.getNumeManager());
        ps.setString(5, sala.getDeschis());
        ps.setInt(6, sala.getIdSala());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public void deleteSala(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement("DELETE FROM sali WHERE id_sala = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}