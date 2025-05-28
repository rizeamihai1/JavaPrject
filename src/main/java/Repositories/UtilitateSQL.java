package Repositories;

import Models.Utilitate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UtilitateSQL implements UtilitateRepo {
    private String url;
    private String user;
    private String password;

    public UtilitateSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver"); // sau alt driver în funcție de SGBD
    }


    @Override
    public void addUtilitate(Utilitate utilitate) throws SQLException {
        String sql = "INSERT INTO utilitati (id_utilitati, nume, cantitate, pret, id_sala) VALUES (?, ?, ?, ?, ?)";
        // without try-catch
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, utilitate.getNume());
        statement.setInt(2, utilitate.getCantitate());
        statement.setDouble(3, utilitate.getPret());
        statement.setInt(4, utilitate.getIdSala());
        statement.executeUpdate();
        conn.close();
        statement.close();
    }

    @Override
    public void removeUtilitate(int idUtilitate) throws SQLException {
        String sql = "DELETE FROM utilitati WHERE id_utilitati = ?";
        // without try-catch
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idUtilitate);
        statement.executeUpdate();
        conn.close();
        statement.close();
    }

    @Override
    public Utilitate getUtilitateById(int idUtilitate) throws SQLException {
        String sql = "SELECT * FROM utilitati WHERE id_utilitati = ?";
        // without try-catch
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUtilitate);
        ResultSet rs = stmt.executeQuery();
        Utilitate utilitate = null;
        if (rs.next()) {
            utilitate = new Utilitate(
                    rs.getInt("id_utilitati"),
                    rs.getString("nume"),
                    rs.getInt("cantitate"),
                    rs.getDouble("pret"),
                    rs.getInt("id_sala")
            );
        }
        conn.close();
        stmt.close();
        return utilitate;
    }

    @Override
    public List<Utilitate> getAllUtilitati() throws SQLException {
        String sql = "SELECT * FROM utilitati";
        // without try-catch
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Utilitate> utilitati = new ArrayList<>();
        while (rs.next()) {
            Utilitate utilitate = new Utilitate(
                    rs.getInt("id_utilitati"),
                    rs.getString("nume"),
                    rs.getInt("cantitate"),
                    rs.getDouble("pret"),
                    rs.getInt("id_sala")
            );
            utilitati.add(utilitate);
        }
        conn.close();
        stmt.close();
        return utilitati;
    }

    @Override
    public void updateUtilitate(Utilitate utilitate) throws SQLException {
        String sql = "UPDATE utilitati SET nume = ?, cantitate = ?, pret = ?, id_sala = ? WHERE id_utilitati = ?";
        // without try-catch
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, utilitate.getNume());
        statement.setInt(2, utilitate.getCantitate());
        statement.setDouble(3, utilitate.getPret());
        statement.setInt(4, utilitate.getIdSala());
        statement.setInt(5, utilitate.getIdUtilitate());
        statement.executeUpdate();
        conn.close();
        statement.close();

    }
}
