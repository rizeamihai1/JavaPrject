package Models;

public class Detine {
    Sala sala;
    Produs produs;

    public Detine(Sala sala, Produs produs) {
        this.sala = sala;
        this.produs = produs;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }
}