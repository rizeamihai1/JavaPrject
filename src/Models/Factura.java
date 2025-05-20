package Models;

import java.util.Date;

public class Factura {
    int idFactura;
    double suma;
    Date data;

    public Factura(int idFactura, double suma, Date data) {
        this.idFactura = idFactura;
        this.suma = suma;
        this.data = data;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}