package Models;

public class Aparat {;
    int id_aparat;
    String nume;
    double masa_maxima;
    String disponibilitate;
    String grupaMuscularaLucrata;


    public Aparat(String nume, double masa_maxima, String disponibilitate, String grupaMuscularaLucrata) {
        this.nume = nume;
        this.masa_maxima = masa_maxima;
        this.disponibilitate = disponibilitate;
        this.grupaMuscularaLucrata = grupaMuscularaLucrata;
    }

    public int getId_aparat() {
        return id_aparat;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getMasa_maxima() {
        return masa_maxima;
    }

    public void setMasa_maxima(double masa_maxima) {
        this.masa_maxima = masa_maxima;
    }


    public String getGrupaMuscularaLucrata() {
        return grupaMuscularaLucrata;
    }

    public void setGrupaMuscularaLucrata(String grupaMuscularaLucrata) {
        this.grupaMuscularaLucrata = grupaMuscularaLucrata;
    }

    public String getDisponibilitate() {
        return disponibilitate;
    }

    public void setDisponibilitate(String disponibilitate) {
        this.disponibilitate = disponibilitate;
    }
    public void setId_aparat(int id_aparat) {
        this.id_aparat = id_aparat;
    }

}