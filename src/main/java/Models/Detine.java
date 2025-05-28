package Models;

public class Detine {
    int idSala;
    int idProdus;

    public Detine(int idSala, int idProdus) {
        this.idSala = idSala;
        this.idProdus = idProdus;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }
}