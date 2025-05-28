package Repositories;

import Models.Aparat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AparatSQL implements AparatRepo {
    private String url;
    private String user;
    private String password;

    public AparatSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;

        Class.forName("com.mysql.cj.jdbc.Driver"); // sau alt driver în funcție de SGBD

    }

    @Override
    public void addAparat(Aparat aparat) throws SQLException {
        String sql = "INSERT INTO aparate (nume, masa_maxima, disponibilitate, grupa_musculara_lucrata) VALUES (?, ?, ?, ?)";
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, aparat.getNume());
        statement.setDouble(2, aparat.getMasa_maxima());
        statement.setString(3, aparat.getDisponibilitate());
        statement.setString(4, aparat.getGrupaMuscularaLucrata());
        statement.executeUpdate();
        conn.close();
        statement.close();
    }

    @Override
    public Aparat getAparatByID(int id) throws SQLException {
        Aparat aparat = null;
        String sql = "SELECT * FROM aparate WHERE id_aparat = ?";
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            aparat = new Aparat(
                    rs.getString("nume"),
                    rs.getDouble("masa_maxima"),
                    rs.getString("disponibilitate"),
                    rs.getString("grupa_musculara_lucrata")
            );
        }

        conn.close();
        stmt.close();

        return aparat;
    }

    @Override
    public List<Aparat> getAllAparat() throws SQLException {
        List<Aparat> lista = new ArrayList<>();
        String sql = "SELECT * FROM aparate";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Aparat aparat = new Aparat(
                    rs.getString("nume"),
                    rs.getDouble("masa_maxima"),
                    rs.getString("disponibilitate"),
                    rs.getString("grupa_musculara_lucrata")
            );
            lista.add(aparat);
        }
        conn.close();
        stmt.close();

        return lista;
    }

    @Override
    public void updateAparat(Aparat aparat) throws SQLException {
        String sql = "UPDATE aparate SET nume = ?, masa_maxima = ?, disponibilitate = ?, grupa_musculara_lucrata = ? WHERE id_aparat = ?";
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, aparat.getNume());
        stmt.setDouble(2, aparat.getMasa_maxima());
        stmt.setString(3, aparat.getDisponibilitate());
        stmt.setString(4, aparat.getGrupaMuscularaLucrata());
        stmt.setInt(5, aparat.getId_aparat());
        stmt.executeUpdate();
    }

    @Override
    public void deleteAparat(int id) throws SQLException {
        String sql = "DELETE FROM aparate WHERE id_aparat = ?";
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();

    }
}
