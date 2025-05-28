package Models;

import java.util.Date;

public class FacturaAbonament extends Factura{
    int idFacturaAbonament;
    int idClient;

    public FacturaAbonament(int idFactura, double suma, Date data, int idFacturaAbonament, int idClient) {
        super(idFactura, suma, data);
        this.idFacturaAbonament = idFacturaAbonament;
        this.idClient = idClient;
    }

    public int getIdFacturaAbonament() {
        return idFacturaAbonament;
    }
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}