package Models;

public class Client {
    int idClient;
    String nume;
    String prenume;
    String email;
    String nrTelefon;

    public Client(int idClient, String nume, String prenume, String email, String nrTelefon) {
        this.idClient = idClient;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.nrTelefon = nrTelefon;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }
}