package Models;

import java.util.List;

public class Sala {
    private int idSala;
    private int nrClienti;
    private double venituri;
    private int nrProduse; private String numeManager; private boolean deschis;
    private List<Aparat> aparate; private List<Utilitate> utilitati;
    private List<Produs> produse; private List<Abonament> abonamente;

    public Sala(int idSala, int nrClienti, double venituri, int nrProduse, String numeManager, boolean deschis, List<Aparat> aparate, List<Utilitate> utilitati, List<Produs> produse, List<Abonament> abonamente) {
        this.idSala = idSala;
        this.nrClienti = nrClienti;
        this.venituri = venituri;
        this.nrProduse = nrProduse;
        this.numeManager = numeManager;
        this.deschis = deschis;
        this.aparate = aparate;
        this.utilitati = utilitati;
        this.produse = produse;
        this.abonamente = abonamente;
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

    public boolean isDeschis() {
        return deschis;
    }

    public void setDeschis(boolean deschis) {
        this.deschis = deschis;
    }

    public List<Aparat> getAparate() {
        return aparate;
    }

    public void setAparate(List<Aparat> aparate) {
        this.aparate = aparate;
    }

    public List<Utilitate> getUtilitati() {
        return utilitati;
    }

    public void setUtilitati(List<Utilitate> utilitati) {
        this.utilitati = utilitati;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    public List<Abonament> getAbonamente() {
        return abonamente;
    }

    public void setAbonamente(List<Abonament> abonamente) {
        this.abonamente = abonamente;
    }
}