package Repositories;
import Models.*;
import java.util.List;
public interface FacturiRepo {
    void adaugaFactura(Factura factura);
    Factura gasesteFacturaDupaId(int id);
    List<Factura> toateFacturile();
    void actualizeazaFactura(Factura factura);
    void stergeFactura(int id);

}
