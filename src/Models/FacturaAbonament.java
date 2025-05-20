package Models;

import java.util.Date;

public class FacturaAbonament extends Factura{
    int idFacturaAbonament;
    Client client;


    public FacturaAbonament(int idFactura, double suma, Date data, int idFacturaAbonament, Client client) {
        super(idFactura, suma, data);
        this.idFacturaAbonament = idFacturaAbonament;
        this.client = client;
    }

    public int getIdFacturaAbonament() {
        return idFacturaAbonament;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}