package Repositories;

import Models.Aparat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AparatSQL implements AparatRepo {
    private String url = "jdbc:mysql://localhost:3306/sala_fitness";
    private String user = "root";
    private String password = "parola";

    public AparatSQL(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // sau alt driver în funcție de SGBD
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void adaugaAparat(Aparat aparat) {
        String sql = "INSERT INTO aparate (nume, masa_maxima, disponibilitate, grupa_musculara_lucrata) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aparat.getNume());
            stmt.setDouble(2, aparat.getMasa_maxima());
            stmt.setBoolean(3, aparat.isDisponibilitate());
            stmt.setString(4, aparat.getGrupa_musculara_lucrata());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Aparat gasesteAparatDupaId(int id) {
        String sql = "SELECT * FROM aparate WHERE id_aparat = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Aparat(
                        rs.getString("nume"),
                        rs.getDouble("masa_maxima"),
                        rs.getBoolean("disponibilitate"),
                        rs.getString("grupa_musculara_lucrata")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Aparat> toateAparatele() {
        List<Aparat> lista = new ArrayList<>();
        String sql = "SELECT * FROM aparate";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aparat aparat = new Aparat(
                        rs.getString("nume"),
                        rs.getDouble("masa_maxima"),
                        rs.getBoolean("disponibilitate"),
                        rs.getString("grupa_musculara_lucrata")
                );
                lista.add(aparat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizeazaAparat(Aparat aparat) {
        String sql = "UPDATE aparate SET nume = ?, masa_maxima = ?, disponibilitate = ?, grupa_musculara_lucrata = ? WHERE id_aparat = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aparat.getNume());
            stmt.setDouble(2, aparat.getMasa_maxima());
            stmt.setBoolean(3, aparat.isDisponibilitate());
            stmt.setString(4, aparat.getGrupa_musculara_lucrata());
            stmt.setInt(5, aparat.getId_aparat());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stergeAparat(int id) {
        String sql = "DELETE FROM aparate WHERE id_aparat = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
