package Models;

import java.util.Date;

public class Achizitie {
    int idAchizitie;
    Date data;
    int idClient;

    public Achizitie(int idAchizitie, Date data, int idClient) {
        this.idAchizitie = idAchizitie;
        this.data = data;
        this.idClient = idClient;
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
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

}