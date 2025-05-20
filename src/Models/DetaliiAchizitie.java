package Models;

public class DetaliiAchizitie {
    int idDetalii;
    int cantitate;
    Achizitie achizitie;
    Produs produs;

    public DetaliiAchizitie(int idDetalii, int cantitate, Achizitie achizitie, Produs produs) {
        this.idDetalii = idDetalii;
        this.cantitate = cantitate;
        this.achizitie = achizitie;
        this.produs = produs;
    }

    public int getIdDetalii() {
        return idDetalii;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public Achizitie getAchizitie() {
        return achizitie;
    }

    public void setAchizitie(Achizitie achizitie) {
        this.achizitie = achizitie;
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }
}