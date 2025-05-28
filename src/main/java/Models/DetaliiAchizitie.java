package Models;

public class DetaliiAchizitie {
    int idDetalii;
    int cantitate;
    int idAchizitie;
    int idProdus;

    public DetaliiAchizitie(int idDetalii, int cantitate, int idAchizitie, int idProdus) {
        this.idDetalii = idDetalii;
        this.cantitate = cantitate;
        this.idAchizitie = idAchizitie;
        this.idProdus = idProdus;
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

    public int getIdAchizitie() {
        return idAchizitie;
    }
    public void setIdAchizitie(int idAchizitie) {
        this.idAchizitie = idAchizitie;
    }
    public int getIdProdus() {
        return idProdus;
    }
    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }
}