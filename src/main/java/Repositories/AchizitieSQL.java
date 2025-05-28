package Repositories;

import Models.Achizitie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AchizitieSQL implements AchizitieRepo {
    private final String url;
    private final String user;
    private final String password;

    public AchizitieSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Override
    public void addAchizitie(Achizitie achizitie) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO achizitie (data, id_client) VALUES (?, ?)"
        );
        ps.setDate(1, new java.sql.Date(achizitie.getData().getTime()));
        ps.setInt(2, achizitie.getIdClient());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public Achizitie getAchizitieByID(int idAchizitie) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM achizitie WHERE id_achizitie = ?"
        );
        ps.setInt(1, idAchizitie);
        ResultSet rs = ps.executeQuery();
        Achizitie ach = null;
        if (rs.next()) {
            ach = new Achizitie(
                    rs.getInt("id_achizitie"),
                    rs.getDate("data"),
                    rs.getInt("id_client")
            );
        }
        rs.close();
        ps.close();
        conn.close();
        return ach;
    }

    @Override
    public List<Achizitie> getAllAchizitii() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM achizitie");
        List<Achizitie> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Achizitie(
                    rs.getInt("id_achizitie"),
                    rs.getDate("data"),
                    rs.getInt("id_client")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }

    @Override
    public void updateAchizitie(Achizitie achizitie) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE achizitie SET data = ?, id_client = ? WHERE id_achizitie = ?"
        );
        ps.setDate(1, new java.sql.Date(achizitie.getData().getTime()));
        ps.setInt(2, achizitie.getIdClient());
        ps.setInt(3, achizitie.getIdAchizitie());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public void deleteAchizitie(int idAchizitie) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM achizitie WHERE id_achizitie = ?"
        );
        ps.setInt(1, idAchizitie);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}