package Repositories;
import Models.*;
import java.util.*;

public interface ClientRepo {
    void addClient(Client client);
    void removeClient(int idClient);
    Client getClientById(int idClient);
    List<Client> getAllClients();
    void updateClient(Client client);
}
