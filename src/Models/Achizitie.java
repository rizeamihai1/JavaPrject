package Models;

import java.util.Date;

public class Achizitie {
    int idAchizitie;
    Date data;
    Client client;

    public Achizitie(int idAchizitie, Date data, Client client) {
        this.idAchizitie = idAchizitie;
        this.data = data;
        this.client = client;
    }

    public int getIdAchizitie() {
        return idAchizitie;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}