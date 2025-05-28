package Repositories;

import Models.Detine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetineSQL implements DetineRepo {
    private final String url;
    private final String user;
    private final String password;

    public DetineSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Override
    public void addDetine(Detine detine) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO detine (id_sala, id_produse) VALUES (?, ?)"
        );
        ps.setInt(1, detine.getIdSala());
        ps.setInt(2, detine.getIdProdus());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public Detine getDetineByIDs(int idSala, int idProdus) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM detine WHERE id_sala = ? AND id_produse = ?"
        );
        ps.setInt(1, idSala);
        ps.setInt(2, idProdus);
        ResultSet rs = ps.executeQuery();
        Detine d = null;
        if (rs.next()) {
            d = new Detine(
                    rs.getInt("id_sala"),
                    rs.getInt("id_produse")
            );
        }
        rs.close();
        ps.close();
        conn.close();
        return d;
    }

    @Override
    public List<Detine> getAllDetine() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM detine");
        List<Detine> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Detine(
                    rs.getInt("id_sala"),
                    rs.getInt("id_produse")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }

    @Override
    public void updateDetine(Detine detine, int oldIdSala, int oldIdProdus) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE detine SET id_sala = ?, id_produse = ? WHERE id_sala = ? AND id_produse = ?"
        );
        ps.setInt(1, detine.getIdSala());
        ps.setInt(2, detine.getIdProdus());
        ps.setInt(3, oldIdSala);
        ps.setInt(4, oldIdProdus);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public void deleteDetine(int idSala, int idProdus) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM detine WHERE id_sala = ? AND id_produse = ?"
        );
        ps.setInt(1, idSala);
        ps.setInt(2, idProdus);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}