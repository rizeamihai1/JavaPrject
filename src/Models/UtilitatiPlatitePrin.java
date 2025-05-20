package Models;

public class UtilitatiPlatitePrin {
    Utilitate utilitate;
    Factura factura;
    FacturaUtilitati facturaUtilitati;

    public UtilitatiPlatitePrin(Utilitate utilitate, Factura factura, FacturaUtilitati facturaUtilitati) {
        this.utilitate = utilitate;
        this.factura = factura;
        this.facturaUtilitati = facturaUtilitati;
    }

    public Utilitate getUtilitate() {
        return utilitate;
    }

    public void setUtilitate(Utilitate utilitate) {
        this.utilitate = utilitate;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public FacturaUtilitati getFacturaUtilitati() {
        return facturaUtilitati;
    }

    public void setFacturaUtilitati(FacturaUtilitati facturaUtilitati) {
        this.facturaUtilitati = facturaUtilitati;
    }
}