package Models;

public class UtilitatiPlatitePrin {
    int idUtilitate;
    int idFactura;
    int idFacturaUtilitati;

    public UtilitatiPlatitePrin(int idUtilitate, int idFactura, int idFacturaUtilitati) {
        this.idUtilitate = idUtilitate;
        this.idFactura = idFactura;
        this.idFacturaUtilitati = idFacturaUtilitati;
    }

    public int getIdUtilitate() {
        return idUtilitate;
    }

    public void setIdUtilitate(int idUtilitate) {
        this.idUtilitate = idUtilitate;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdFacturaUtilitati() {
        return idFacturaUtilitati;
    }

    public void setIdFacturaUtilitati(int idFacturaUtilitati) {
        this.idFacturaUtilitati = idFacturaUtilitati;
    }
}