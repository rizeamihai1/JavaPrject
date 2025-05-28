package Models;

public class Utilitate {
    int idUtilitate;
    String nume;
    int cantitate;
    double pret;
    int idSala;

    public Utilitate(int idUtilitate, String nume, int cantitate, double pret, int idSala) {
        this.idUtilitate = idUtilitate;
        this.nume = nume;
        this.cantitate = cantitate;
        this.pret = pret;
        this.idSala = idSala;
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
    public int getIdSala() {
        return idSala;
    }
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

}