package Models;

import java.util.Date;

public class FacturaUtilitati extends Factura {
    private int idFacturaUtilitati;
    Utilitate utilitate;

    public FacturaUtilitati(int idFactura, double suma, Date data, int idFacturaUtilitati, Utilitate utilitate) {
        super(idFactura, suma, data);
        this.idFacturaUtilitati = idFacturaUtilitati;
        this.utilitate = utilitate;
    }

    public int getIdFacturaUtilitati() {
        return idFacturaUtilitati;
    }

    public Utilitate getUtilitate() {
        return utilitate;
    }

    public void setUtilitate(Utilitate utilitate) {
        this.utilitate = utilitate;
    }
}