package Models;

import java.util.Date;

public class Abonament {
    int idAbonament;
    double pret;
    String tipAbonament;
    Date dataValabilitate;
    int idSala;

    public Abonament(int idAbonament, double pret, String tipAbonament, Date dataValabilitate, int idSala) {
        this.idAbonament = idAbonament;
        this.pret = pret;
        this.tipAbonament = tipAbonament;
        this.dataValabilitate = dataValabilitate;
        this.idSala = idSala;
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

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }
}