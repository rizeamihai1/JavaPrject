package Repositories;

import Models.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientSQL implements ClientRepo {
    private String url = "jdbc:mysql://localhost:3306/sala_fitness";
    private String user = "root";
    private String password = "parola";

    public ClientSQL(String url, String user, String password) {
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
    public void addClient(Client client) {
        String sql = "INSERT INTO clienti (nume, prenume, email, nr_telefon) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, client.getNume());
            stmt.setString(2, client.getPrenume());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getNrTelefon());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void removeClient(int idClient) {
        String sql = "DELETE FROM clienti WHERE id_client = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idClient);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Client getClientById(int idClient) {
        String sql = "SELECT * FROM clienti WHERE id_client = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idClient);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Client(
                        rs.getInt("id_client"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("email"),
                        rs.getString("nr_telefon")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Client> getAllClients() {
        List<Client> lista = new ArrayList<>();
        String sql = "SELECT * FROM clienti";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Client client = new Client(
                        rs.getInt("id_client"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("email"),
                        rs.getString("nr_telefon")
                );
                lista.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    @Override
    public void updateClient(Client client) {
        String sql = "UPDATE clienti SET nume = ?, prenume = ?, email = ?, nr_telefon = ? WHERE id_client = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, client.getNume());
            stmt.setString(2, client.getPrenume());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getNrTelefon());
            stmt.setInt(5, client.getIdClient());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
