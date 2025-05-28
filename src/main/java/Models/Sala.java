package Models;

import java.util.List;

public class Sala {
    private int idSala;
    private int nrClienti;
    private double venituri;
    private int nrProduse;
    private String numeManager;
    private String deschis;

    public Sala(int idSala, int nrClienti, double venituri, int nrProduse, String numeManager, String deschis, List<Utilitate> utilitati, List<Produs> produse, List<Abonament> abonamente) {
        this.idSala = idSala;
        this.nrClienti = nrClienti;
        this.venituri = venituri;
        this.nrProduse = nrProduse;
        this.numeManager = numeManager;
        this.deschis = deschis;
    }

    public Sala(int idSala, int nrClientiSala, double venituriSala, int nrProduseSala, String managerSala, String deschisSala) {
        this.idSala = idSala;
        this.nrClienti = nrClientiSala;
        this.venituri = venituriSala;
        this.nrProduse = nrProduseSala;
        this.numeManager = managerSala;
        this.deschis = deschisSala;
    }

    public int getIdSala() {
        return idSala;
    }

    public int getNrClienti() {
        return nrClienti;
    }

    public void setNrClienti(int nrClienti) {
        this.nrClienti = nrClienti;
    }

    public double getVenituri() {
        return venituri;
    }

    public void setVenituri(double venituri) {
        this.venituri = venituri;
    }

    public int getNrProduse() {
        return nrProduse;
    }

    public void setNrProduse(int nrProduse) {
        this.nrProduse = nrProduse;
    }

    public String getNumeManager() {
        return numeManager;
    }

    public void setNumeManager(String numeManager) {
        this.numeManager = numeManager;
    }

    public String getDeschis() {
        return deschis;
    }

    public void setDeschis(String deschis) {
        this.deschis = deschis;
    }

}