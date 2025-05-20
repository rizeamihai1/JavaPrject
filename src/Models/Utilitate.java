package Models;

public class Utilitate {
    int idUtilitate;
    String nume;
    int cantitate;
    double pret;
    Sala sala;

    public Utilitate(int idUtilitate, String nume, int cantitate, double pret, Sala sala) {
        this.idUtilitate = idUtilitate;
        this.nume = nume;
        this.cantitate = cantitate;
        this.pret = pret;
        this.sala = sala;
    }

    public int getIdUtilitate() {
        return idUtilitate;
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

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}