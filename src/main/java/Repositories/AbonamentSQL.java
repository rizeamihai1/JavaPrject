package Repositories;
import Models.Abonament;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbonamentSQL implements AbonamentRepo {
    private final String url;
    private final String user;
    private final String password;

    public AbonamentSQL(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Override
    public void addAbonament(Abonament abonament) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO abonament (pret, tip_abonament, data_valabilitate, id_sala) VALUES (?, ?, ?, ?)"
        );
        ps.setDouble(1, abonament.getPret());
        ps.setString(2, abonament.getTipAbonament());
        ps.setDate(3, new java.sql.Date(abonament.getDataValabilitate().getTime()));
        ps.setInt(4, abonament.getIdSala());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public Abonament getAbonamentByID(int idAbonament) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM abonament WHERE id_abonament = ?"
        );
        ps.setInt(1, idAbonament);
        ResultSet rs = ps.executeQuery();
        Abonament a = null;
        if (rs.next()) {
            a = new Abonament(
                    rs.getInt("id_abonament"),
                    rs.getDouble("pret"),
                    rs.getString("tip_abonament"),
                    rs.getDate("data_valabilitate"),
                    rs.getInt("id_sala")
            );
        }
        rs.close();
        ps.close();
        conn.close();
        return a;
    }

    @Override
    public List<Abonament> getAllAbonamente() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM abonament");
        List<Abonament> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Abonament(
                    rs.getInt("id_abonament"),
                    rs.getDouble("pret"),
                    rs.getString("tip_abonament"),
                    rs.getDate("data_valabilitate"),
                    rs.getInt("id_sala")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }

    @Override
    public void updateAbonament(Abonament abonament) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE abonament SET pret = ?, tip_abonament = ?, data_valabilitate = ?, id_sala = ?, id_client = ? " +
                        "WHERE id_abonament = ?"
        );
        ps.setDouble(1, abonament.getPret());
        ps.setString(2, abonament.getTipAbonament());
        ps.setDate(3, new java.sql.Date(abonament.getDataValabilitate().getTime()));
        ps.setInt(4, abonament.getIdSala());
        ps.setInt(6, abonament.getIdAbonament());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public void deleteAbonament(int idAbonament) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM abonament WHERE id_abonament = ?"
        );
        ps.setInt(1, idAbonament);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
