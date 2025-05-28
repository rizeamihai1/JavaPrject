package Repositories;

import Models.DetaliiAchizitie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetaliiAchizitieSQL implements DetaliiAchizitieRepo {
    private final String url;
    private final String user;
    private final String password;

    public DetaliiAchizitieSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Override
    public void addDetaliiAchizitie(DetaliiAchizitie detalii) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO detalii_achizitie (cantitate, id_achizitie, id_produse) VALUES (?, ?, ?)"
        );
        ps.setInt(1, detalii.getCantitate());
        ps.setInt(2, detalii.getIdAchizitie());
        ps.setInt(3, detalii.getIdProdus());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public DetaliiAchizitie getDetaliiAchizitieByID(int idDetalii) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM detalii_achizitie WHERE id_detalii_achizitie = ?"
        );
        ps.setInt(1, idDetalii);
        ResultSet rs = ps.executeQuery();
        DetaliiAchizitie d = null;
        if (rs.next()) {
            d = new DetaliiAchizitie(
                    rs.getInt("id_detalii_achizitie"),
                    rs.getInt("cantitate"),
                    rs.getInt("id_achizitie"),
                    rs.getInt("id_produse")
            );
        }
        rs.close();
        ps.close();
        conn.close();
        return d;
    }

    @Override
    public List<DetaliiAchizitie> getAllDetaliiAchizitie() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM detalii_achizitie");
        List<DetaliiAchizitie> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new DetaliiAchizitie(
                    rs.getInt("id_detalii_achizitie"),
                    rs.getInt("cantitate"),
                    rs.getInt("id_achizitie"),
                    rs.getInt("id_produse")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }

    @Override
    public void updateDetaliiAchizitie(DetaliiAchizitie detalii) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE detalii_achizitie " +
                        "SET cantitate = ?, id_achizitie = ?, id_produse = ? " +
                        "WHERE id_detalii_achizitie = ?"
        );
        ps.setInt(1, detalii.getCantitate());
        ps.setInt(2, detalii.getIdAchizitie());
        ps.setInt(3, detalii.getIdProdus());
        ps.setInt(4, detalii.getIdDetalii());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public void deleteDetaliiAchizitie(int idDetalii) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM detalii_achizitie WHERE id_detalii_achizitie = ?"
        );
        ps.setInt(1, idDetalii);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}