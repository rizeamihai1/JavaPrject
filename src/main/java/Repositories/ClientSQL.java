package Repositories;

import Models.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientSQL implements ClientRepo {
    private String url;
    private String user;
    private String password;

    public ClientSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver"); // sau alt driver în funcție de SGBD
    }

    @Override
    public void addClient(Client client) throws SQLException {
        String sql = "INSERT INTO client (nume, prenume, email, nr_telefon) VALUES (?, ?, ?, ?)";
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, client.getNume());
        statement.setString(2, client.getPrenume());
        statement.setString(3, client.getEmail());
        statement.setString(4, client.getNrTelefon());
        statement.executeUpdate();
        conn.close();
        statement.close();
    }

    @Override
    public void removeClient(int idClient) throws SQLException {
        String sql = "DELETE FROM client WHERE id_client = ?";
        // without try-catch
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idClient);
        stmt.executeUpdate();
        conn.close();
        stmt.close();


    }

    @Override
    public Client getClientById(int idClient) throws SQLException {
        String sql = "SELECT * FROM client WHERE id_client = ?";
        // without try-catch
        Client client = null;
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idClient);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            client = new Client(
                    rs.getInt("id_client"),
                    rs.getString("nume"),
                    rs.getString("prenume"),
                    rs.getString("email"),
                    rs.getString("nr_telefon")
            );
        }
        conn.close();
        stmt.close();
        return client;
    }

    @Override
    public List<Client> getAllClients() throws SQLException {
        List<Client> lista = new ArrayList<>();
        String sql = "SELECT * FROM client";
        // without try-catch
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
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
        conn.close();
        stmt.close();
        return lista;
    }

    @Override
    public void updateClient(Client client) throws SQLException {
        String sql = "UPDATE client SET nume = ?, prenume = ?, email = ?, nr_telefon = ? WHERE id_client = ?";
        // without try-catch
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, client.getNume());
        statement.setString(2, client.getPrenume());
        statement.setString(3, client.getEmail());
        statement.setString(4, client.getNrTelefon());
        statement.setInt(5, client.getIdClient());
        statement.executeUpdate();
        conn.close();
        statement.close();
    }
}
