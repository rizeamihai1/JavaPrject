package Models;

import java.time.LocalDate;
import java.util.Date;

public class Abonament {
    int idAbonament;
    double pret;
    String tipAbonament;
    Date dataValabilitate;
    Sala sala;
    Client client;

    public Abonament(int idAbonament, double pret, String tipAbonament, Date dataValabilitate, Sala sala, Client client) {
        this.idAbonament = idAbonament;
        this.pret = pret;
        this.tipAbonament = tipAbonament;
        this.dataValabilitate = dataValabilitate;
        this.sala = sala;
        this.client = client;
    }

    public int getIdAbonament() {
        return idAbonament;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getTipAbonament() {
        return tipAbonament;
    }

    public void setTipAbonament(String tipAbonament) {
        this.tipAbonament = tipAbonament;
    }

    public Date getDataValabilitate() {
        return dataValabilitate;
    }

    public void setDataValabilitate(Date dataValabilitate) {
        this.dataValabilitate = dataValabilitate;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}