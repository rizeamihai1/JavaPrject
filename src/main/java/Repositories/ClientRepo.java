package Repositories;
import Models.*;

import java.sql.SQLException;
import java.util.*;

public interface ClientRepo {
    void addClient(Client client) throws SQLException;
    List<Client> getAllClients() throws SQLException;
    Client getClientById(int idClient) throws SQLException;
    void removeClient(int idClient) throws SQLException;
    void updateClient(Client client) throws SQLException;
}
