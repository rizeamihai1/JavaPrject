package Repositories;

import Models.Client;
import Models.Utilitate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UtilitateSQL implements UtilitateRepo {
    private String url = "jdbc:mysql://localhost:3306/sala_fitness";
    private String user = "root";
    private String password = "parola";

    public UtilitateSQL(String url, String user, String password) {
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
    public void addUtilitate(Utilitate utilitate) {
        String sql = "INSERT INTO utilitati (nume_utilitate, cantitate) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, utilitate.getNume());
            stmt.setString(2, String.valueOf(utilitate.getCantitate()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUtilitate(int idUtilitate) {
        String sql = "DELETE FROM utilitati WHERE id_utilitate = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUtilitate);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Utilitate getUtilitateById(int idUtilitate) {
        String sql = "SELECT * FROM utilitati WHERE id_utilitate = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUtilitate);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Utilitate(
                        rs.getInt("id_utilitate"),
                        rs.getString("nume_utilitate"),
                        rs.getInt("cantitate"),
                        rs.getDouble("pret"),
                        null // Aici ar trebui să adăugăm obiectul Sala corespunzător
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Utilitate> getAllUtilitati() {
        String sql = "SELECT * FROM utilitati";
        List<Utilitate> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Utilitate(
                        rs.getInt("id_utilitate"),
                        rs.getString("nume_utilitate"),
                        rs.getInt("cantitate"),
                        rs.getDouble("pret"),
                        null // Aici ar trebui să adăugăm obiectul Sala corespunzător
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUtilitate(Utilitate utilitate) {
        String sql = "UPDATE utilitati SET nume_utilitate = ?, cantitate = ?, pret = ? WHERE id_utilitate = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, utilitate.getNume());
            stmt.setInt(2, utilitate.getCantitate());
            stmt.setDouble(3, utilitate.getPret());
            stmt.setInt(4, utilitate.getIdUtilitate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
