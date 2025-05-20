package Models;

public class Produs {
    int idProdus;
    String nume;
    int cantitate;
    double pret;

    public Produs(int idProdus, String nume, int cantitate, double pret) {
        this.idProdus = idProdus;
        this.nume = nume;
        this.cantitate = cantitate;
        this.pret = pret;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }
}