package Models;

import java.util.Date;

public class FacturaProduse extends Factura {
    int idFacturaProduse;
    int idAchizitie;

    public FacturaProduse(int idFactura, double suma, Date data, int idFacturaProduse, int idAchizitie) {
        super(idFactura, suma, data);
        this.idFacturaProduse = idFacturaProduse;
        this.idAchizitie = idAchizitie;
    }

    public int getIdFacturaProduse() {
        return idFacturaProduse;
    }

    public int getIdAchizitie() {
        return idAchizitie;
    }
    public void setIdAchizitie(int idAchizitie) {
        this.idAchizitie = idAchizitie;
    }

}