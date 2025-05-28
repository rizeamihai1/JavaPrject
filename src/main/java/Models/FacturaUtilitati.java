package Models;

import java.util.Date;

public class FacturaUtilitati extends Factura {
    private int idFacturaUtilitati;
    int idUtilitate;

    public FacturaUtilitati(int idFactura, double suma, Date data, int idFacturaUtilitati, int idUtilitate) {
        super(idFactura, suma, data);
        this.idFacturaUtilitati = idFacturaUtilitati;
        this.idUtilitate = idUtilitate;
    }

    public int getIdFacturaUtilitati() {
        return idFacturaUtilitati;
    }
    public int getIdUtilitate() {
        return idUtilitate;
    }
    public void setIdUtilitate(int idUtilitate) {
        this.idUtilitate = idUtilitate;
    }
}