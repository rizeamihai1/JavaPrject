package Models;

import java.util.Date;

public class FacturaProduse extends Factura {
    int idFacturaProduse;
    Achizitie achiztie;

    public FacturaProduse(int idFactura, double suma, Date data, int idFacturaProduse, Achizitie achiztie) {
        super(idFactura, suma, data);
        this.idFacturaProduse = idFacturaProduse;
        this.achiztie = achiztie;
    }

    public Achizitie getAchiztie() {
        return achiztie;
    }

    public void setAchiztie(Achizitie achiztie) {
        this.achiztie = achiztie;
    }

    public int getIdFacturaProduse() {
        return idFacturaProduse;
    }

}