package Repositories;

import Models.Factura;

import java.sql.*;

public class FacturiSQL implements FacturiRepo {
    private String url = "jdbc:mysql://localhost:3306/sala_fitness";
    private String user = "root";
    private String password = "parola";

    public FacturiSQL(String url, String user, String password) {
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
    public void adaugaFactura(Factura factura) {
        String sql = "INSERT INTO facturi (id_client, id_abonament, data_facturii, suma) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, factura.getIdClient());
            stmt.setInt(2, factura.getIdAbonament());
            stmt.setDate(3, Date.valueOf(factura.getDataFacturii()));
            stmt.setDouble(4, factura.getSuma());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Factura gasesteFacturaDupaId(int id) {
        String sql = "SELECT * FROM facturi WHERE id_factura = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Factura(
                        rs.getInt("id_factura"),
                        rs.getInt("id_client"),
                        rs.getInt("id_abonament"),
                        rs.getDate("data_facturii").toLocalDate(),
                        rs.getDouble("suma")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Factura> toateFacturile() {
        // Implementare pentru obtinerea tuturor facturilor din baza de date SQL
        return null;
    }

    @Override
    public void actualizeazaFactura(Factura factura) {
        // Implementare pentru actualizarea unei facturi in baza de date SQL
    }

    @Override
    public void stergeFactura(int id) {
        // Implementare pentru stergerea unei facturi din baza de date SQL
    }
}
