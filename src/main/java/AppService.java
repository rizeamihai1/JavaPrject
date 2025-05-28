import Models.*;
import Repositories.*;

import java.sql.SQLException;
import java.util.List;

public class AppService {
    private static AppService instance;
    private AparatRepo aparatRepo;
    private ClientRepo clientRepo;
    private FacturiRepo facturiRepo;
    private UtilitateRepo utilitateRepo;
    private UtilitatiPlatitePrinRepo uppRepo;
    private AbonamentRepo abonamentRepo;
    private AchizitieRepo achizitieRepo;
    private DetaliiAchizitieRepo detaliiRepo;
    private DetineRepo detineRepo;
    private FacturaAbonamentRepo facturaAbonamentRepo;
    private SalaRepo salaRepo;
    private ProdusRepo produsRepo;
    private FacturaProduseRepo facturaProduseRepo;
    private FacturaUtilitatiRepo facturaUtilitatiRepo;

    private AppService(String url, String user, String password) {
        try {
            aparatRepo = new AparatSQL(url, user, password);
            clientRepo = new ClientSQL(url, user, password);
            facturiRepo = new FacturiSQL(url, user, password);
            utilitateRepo = new UtilitateSQL(url, user, password);
            uppRepo = new UtilitatiPlatitePrinSQL(url, user, password);
            abonamentRepo = new AbonamentSQL(url, user, password);
            achizitieRepo = new AchizitieSQL(url, user, password);
            detaliiRepo = new DetaliiAchizitieSQL(url, user, password);
            detineRepo = new DetineSQL(url, user, password);
            facturaAbonamentRepo = new FacturaAbonamentSQL(url, user, password);
            salaRepo = new SalaSQL(url, user, password);
            produsRepo = new ProdusSQL(url, user, password);
            facturaProduseRepo = new FacturaProduseSQL(url, user, password);
            facturaUtilitatiRepo = new FacturaUtilitatiSQL(url, user, password);
        } catch (ClassNotFoundException e) {
            System.err.println("Error initializing AppService: " + e.getMessage());
        }
    }

    public static AppService getInstance(String url, String user, String password) throws ClassNotFoundException {
        if (instance == null) {
            instance = new AppService(url, user, password);
        }
        return instance;
    }

    // Aparat service methods
    public void addAparat(Aparat aparat)  {
        try {
            aparatRepo.addAparat(aparat);
        } catch (SQLException e) {
            System.err.println("Error adding Aparat: " + e.getMessage());
        }
    }

    public Aparat getAparatById(int id) {
        try {
            return aparatRepo.getAparatByID(id);
        } catch (SQLException e) {
            System.err.println("Error getting Aparat by ID: " + e.getMessage());
            return null;
        }
    }

    public List<Aparat> getAllAparate() {
        try {
            return aparatRepo.getAllAparat();
        } catch (SQLException e) {
            System.err.println("Error getting all Aparate: " + e.getMessage());
            return null;
        }
    }

    public void updateAparat(Aparat aparat) {
        try {
            aparatRepo.updateAparat(aparat);
        } catch (SQLException e) {
            System.err.println("Error updating Aparat: " + e.getMessage());
        }
    }

    public void deleteAparat(int id) {
        try {
            aparatRepo.deleteAparat(id);
        } catch (SQLException e) {
            System.err.println("Error deleting Aparat: " + e.getMessage());
        }
    }

    // Client service methods
    public void addClient(Client client) {
        try {
            clientRepo.addClient(client);
        } catch (SQLException e) {
            System.err.println("Error adding Client: " + e.getMessage());
        }
    }

    public Client getClientById(int id) {
        try {
            return clientRepo.getClientById(id);
        } catch (SQLException e) {
            System.err.println("Error getting Client by ID: " + e.getMessage());
            return null;
        }
    }

    public List<Client> getAllClients() {
        try {
            return clientRepo.getAllClients();
        } catch (SQLException e) {
            System.err.println("Error getting all Clients: " + e.getMessage());
            return null;
        }
    }

    public void updateClient(Client client) {
        try {
            clientRepo.updateClient(client);
        } catch (SQLException e) {
            System.err.println("Error updating Client: " + e.getMessage());
        }
    }

    public void deleteClient(int id) {
        try {
            clientRepo.removeClient(id);
        } catch (SQLException e) {
            System.err.println("Error deleting Client: " + e.getMessage());
        }
    }

    // Facturi service methods

    public void addFactura(Factura factura) {
        try {
            facturiRepo.addFactura(factura);
        } catch (SQLException e) {
            System.err.println("Error adding Factura: " + e.getMessage());
        }
    }

    public Factura getFacturaById(int id) {
        try {
            return facturiRepo.getFacturaByID(id);
        } catch (SQLException e) {
            System.err.println("Error getting Factura by ID: " + e.getMessage());
            return null;
        }
    }

    public List<Factura> getAllFacturi() {
        try {
            return facturiRepo.getAllFactura();
        } catch (SQLException e) {
            System.err.println("Error getting all Facturi: " + e.getMessage());
            return null;
        }
    }

    public void updateFactura(Factura factura) {
        try {
            facturiRepo.updateFactura(factura);
        } catch (SQLException e) {
            System.err.println("Error updating Factura: " + e.getMessage());
        }
    }

    public void deleteFactura(int id) {
        try {
            facturiRepo.deleteFactura(id);
        } catch (SQLException e) {
            System.err.println("Error deleting Factura: " + e.getMessage());
        }
    }

    // Utilitate service methods
    public void addUtilitate(Utilitate utilitate) {
        try {
            utilitateRepo.addUtilitate(utilitate);
        } catch (SQLException e) {
            System.err.println("Error adding Utilitate: " + e.getMessage());
        }
    }

    public Utilitate getUtilitateById(int id) {
        try {
            return utilitateRepo.getUtilitateById(id);
        } catch (SQLException e) {
            System.err.println("Error getting Utilitate by ID: " + e.getMessage());
            return null;
        }
    }

    public List<Utilitate> getAllUtilitati() {
        try {
            return utilitateRepo.getAllUtilitati();
        } catch (SQLException e) {
            System.err.println("Error getting all Utilitati: " + e.getMessage());
            return null;
        }
    }

    public void updateUtilitate(Utilitate utilitate) {
        try {
            utilitateRepo.updateUtilitate(utilitate);
        } catch (SQLException e) {
            System.err.println("Error updating Utilitate: " + e.getMessage());
        }
    }

    public void deleteUtilitate(int id) {
        try {
            utilitateRepo.removeUtilitate(id);
        } catch (SQLException e) {
            System.err.println("Error deleting Utilitate: " + e.getMessage());
        }
    }
    public void addUtilitatePlatitaPrin(UtilitatiPlatitePrin upp) {
        try {
            uppRepo.addUtilitatePlatitaPrin(upp);
        } catch (SQLException e) {
            System.err.println("Error adding UtilitatiPlatitePrin: " + e.getMessage());
        }
    }

    public UtilitatiPlatitePrin getUtilitatePlatitaPrinByID(int idUtilitate, int idFactura, int idFacturaUtilitati) {
        try {
            return uppRepo.getUtilitatePlatitaPrinByID(idUtilitate, idFactura, idFacturaUtilitati);
        } catch (SQLException e) {
            System.err.println("Error getting UtilitatiPlatitePrin by ID: " + e.getMessage());
            return null;
        }
    }

    public List<UtilitatiPlatitePrin> getAllUtilitatiPlatitePrin() {
        try {
            return uppRepo.getAllUtilitatiPlatitePrin();
        } catch (SQLException e) {
            System.err.println("Error getting all UtilitatiPlatitePrin: " + e.getMessage());
            return null;
        }
    }

    public void updateUtilitatePlatitaPrin(UtilitatiPlatitePrin upp) {
        try {
            uppRepo.updateUtilitatePlatitaPrin(upp);
        } catch (SQLException e) {
            System.err.println("Error updating UtilitatiPlatitePrin: " + e.getMessage());
        }
    }

    public void deleteUtilitatePlatitaPrin(int idUtilitate, int idFactura, int idFacturaUtilitati) {
        try {
            uppRepo.deleteUtilitatePlatitaPrin(idUtilitate, idFactura, idFacturaUtilitati);
        } catch (SQLException e) {
            System.err.println("Error deleting UtilitatiPlatitePrin: " + e.getMessage());
        }
    }

    public void addAbonament(Abonament a) {
        try {
            abonamentRepo.addAbonament(a);
        } catch (SQLException e) {
            System.err.println("Error adding Abonament: " + e.getMessage());
        }
    }

    public Abonament getAbonamentById(int id) {
        try {
            return abonamentRepo.getAbonamentByID(id);
        } catch (SQLException e) {
            System.err.println("Error getting Abonament by ID: " + e.getMessage());
            return null;
        }
    }

    public List<Abonament> getAllAbonamente() {
        try {
            return abonamentRepo.getAllAbonamente();
        } catch (SQLException e) {
            System.err.println("Error getting all Abonamente: " + e.getMessage());
            return null;
        }
    }

    public void updateAbonament(Abonament a) {
        try {
            abonamentRepo.updateAbonament(a);
        } catch (SQLException e) {
            System.err.println("Error updating Abonament: " + e.getMessage());
        }
    }

    public void deleteAbonament(int id) {
        try {
            abonamentRepo.deleteAbonament(id);
        } catch (SQLException e) {
            System.err.println("Error deleting Abonament: " + e.getMessage());
        }
    }

    public void addAchizitie(Achizitie a) {
        try {
            achizitieRepo.addAchizitie(a);
        } catch (SQLException e) {
            System.err.println("Error adding Achizitie: " + e.getMessage());
        }
    }

    public Achizitie getAchizitieById(int id) {
        try {
            return achizitieRepo.getAchizitieByID(id);
        } catch (SQLException e) {
            System.err.println("Error getting Achizitie by ID: " + e.getMessage());
            return null;
        }
    }

    public List<Achizitie> getAllAchizitii() {
        try {
            return achizitieRepo.getAllAchizitii();
        } catch (SQLException e) {
            System.err.println("Error getting all Achizitii: " + e.getMessage());
            return null;
        }
    }

    public void updateAchizitie(Achizitie a) {
        try {
            achizitieRepo.updateAchizitie(a);
        } catch (SQLException e) {
            System.err.println("Error updating Achizitie: " + e.getMessage());
        }
    }

    public void deleteAchizitie(int id) {
        try {
            achizitieRepo.deleteAchizitie(id);
        } catch (SQLException e) {
            System.err.println("Error deleting Achizitie: " + e.getMessage());
        }
    }

    public void addDetaliiAchizitie(DetaliiAchizitie d) {
        try {
            detaliiRepo.addDetaliiAchizitie(d);
        } catch (SQLException e) {
            System.err.println("Error adding DetaliiAchizitie: " + e.getMessage());
        }
    }

    public DetaliiAchizitie getDetaliiAchizitieById(int id) {
        try {
            return detaliiRepo.getDetaliiAchizitieByID(id);
        } catch (SQLException e) {
            System.err.println("Error getting DetaliiAchizitie by ID: " + e.getMessage());
            return null;
        }
    }

    public List<DetaliiAchizitie> getAllDetaliiAchizitie() {
        try {
            return detaliiRepo.getAllDetaliiAchizitie();
        } catch (SQLException e) {
            System.err.println("Error getting all DetaliiAchizitie: " + e.getMessage());
            return null;
        }
    }

    public void updateDetaliiAchizitie(DetaliiAchizitie d) {
        try {
            detaliiRepo.updateDetaliiAchizitie(d);
        } catch (SQLException e) {
            System.err.println("Error updating DetaliiAchizitie: " + e.getMessage());
        }
    }

    public void deleteDetaliiAchizitie(int id) {
        try {
            detaliiRepo.deleteDetaliiAchizitie(id);
        } catch (SQLException e) {
            System.err.println("Error deleting DetaliiAchizitie: " + e.getMessage());
        }
    }

    public void addDetine(Detine d) {
        try {
            detineRepo.addDetine(d);
        } catch (SQLException e) {
            System.err.println("Error adding Detine: " + e.getMessage());
        }
    }

    public Detine getDetine(int idSala, int idProdus) {
        try {
            return detineRepo.getDetineByIDs(idSala, idProdus);
        } catch (SQLException e) {
            System.err.println("Error getting Detine by IDs: " + e.getMessage());
            return null;
        }
    }

    public List<Detine> getAllDetine() {
        try {
            return detineRepo.getAllDetine();
        } catch (SQLException e) {
            System.err.println("Error getting all Detine: " + e.getMessage());
            return null;
        }
    }

    public void updateDetine(Detine newD, int oldIdSala, int oldIdProdus) {
        try {
            detineRepo.updateDetine(newD, oldIdSala, oldIdProdus);
        } catch (SQLException e) {
            System.err.println("Error updating Detine: " + e.getMessage());
        }
    }

    public void deleteDetine(int idSala, int idProdus) {
        try {
            detineRepo.deleteDetine(idSala, idProdus);
        } catch (SQLException e) {
            System.err.println("Error deleting Detine: " + e.getMessage());
        }
    }

    public void addFacturaAbonament(FacturaAbonament fa) {
        try {
            facturaAbonamentRepo.addFacturaAbonament(fa);
        } catch (SQLException e) {
            System.err.println("Error adding FacturaAbonament: " + e.getMessage());
        }
    }

    public FacturaAbonament getFacturaAbonamentById(int idFactura, int idFacturaAbonament) {
        try {
            return facturaAbonamentRepo.getFacturaAbonamentByID(idFactura, idFacturaAbonament);
        } catch (SQLException e) {
            System.err.println("Error getting FacturaAbonament by ID: " + e.getMessage());
            return null;
        }
    }

    public List<FacturaAbonament> getAllFacturaAbonament() {
        try {
            return facturaAbonamentRepo.getAllFacturaAbonament();
        } catch (SQLException e) {
            System.err.println("Error getting all FacturaAbonament: " + e.getMessage());
            return null;
        }
    }

    public void updateFacturaAbonament(FacturaAbonament fa) {
        try {
            facturaAbonamentRepo.updateFacturaAbonament(fa);
        } catch (SQLException e) {
            System.err.println("Error updating FacturaAbonament: " + e.getMessage());
        }
    }

    public void deleteFacturaAbonament(int idFactura, int idFacturaAbonament) {
        try {
            facturaAbonamentRepo.deleteFacturaAbonament(idFactura, idFacturaAbonament);
        } catch (SQLException e) {
            System.err.println("Error deleting FacturaAbonament: " + e.getMessage());
        }
    }

    public void addSala(Sala sala) {
        try {
            salaRepo.addSala(sala);
        } catch (SQLException e) {
            System.err.println("Error adding Sala: " + e.getMessage());
        }
    }

    public Sala getSalaById(int id) {
        try {
            return salaRepo.getSalaByID(id);
        } catch (SQLException e) {
            System.err.println("Error getting Sala by ID: " + e.getMessage());
            return null;
        }
    }

    public List<Sala> getAllSali() {
        try {
            return salaRepo.getAllSali();
        } catch (SQLException e) {
            System.err.println("Error getting all Sali: " + e.getMessage());
            return null;
        }
    }

    public void updateSala(Sala sala) {
        try {
            salaRepo.updateSala(sala);
        } catch (SQLException e) {
            System.err.println("Error updating Sala: " + e.getMessage());
        }
    }

    public void deleteSala(int id) {
        try {
            salaRepo.deleteSala(id);
        } catch (SQLException e) {
            System.err.println("Error deleting Sala: " + e.getMessage());
        }
    }

    public void addProdus(Produs produs) {
        try {
            produsRepo.addProdus(produs);
        } catch (SQLException e) {
            System.err.println("Error adding produs: " + e.getMessage());
        }
    }

    public Produs getProdusById(int id) {
        try {
            return produsRepo.getProdusByID(id);
        } catch (SQLException e) {
            System.err.println("Error retrieving produs: " + e.getMessage());
            return null;
        }
    }

    public List<Produs> getAllProduse() {
        try {
            return produsRepo.getAllProduse();
        } catch (SQLException e) {
            System.err.println("Error retrieving all produse: " + e.getMessage());
            return null;
        }
    }

    public void updateProdus(Produs produs) {
        try {
            produsRepo.updateProdus(produs);
        } catch (SQLException e) {
            System.err.println("Error updating produs: " + e.getMessage());
        }
    }

    public void deleteProdus(int id) {
        try {
            produsRepo.deleteProdus(id);
        } catch (SQLException e) {
            System.err.println("Error deleting produs: " + e.getMessage());
        }
    }
    public void addFacturaProduse(FacturaProduse factura) {
        try {
            facturaProduseRepo.addFacturaProduse(factura);
        } catch (SQLException e) {
            System.err.println("Error adding factura produse: " + e.getMessage());
        }
    }

    public FacturaProduse getFacturaProduseById(int id) {
        try {
            return facturaProduseRepo.getFacturaProduseByID(id);
        } catch (SQLException e) {
            System.err.println("Error retrieving factura produse: " + e.getMessage());
            return null;
        }
    }

    public List<FacturaProduse> getAllFacturiProduse() {
        try {
            return facturaProduseRepo.getAllFacturiProduse();
        } catch (SQLException e) {
            System.err.println("Error retrieving all facturi produse: " + e.getMessage());
            return null;
        }
    }

    public void updateFacturaProduse(FacturaProduse factura) {
        try {
            facturaProduseRepo.updateFacturaProduse(factura);
        } catch (SQLException e) {
            System.err.println("Error updating factura produse: " + e.getMessage());
        }
    }

    public void deleteFacturaProduse(int id) {
        try {
            facturaProduseRepo.deleteFacturaProduse(id);
        } catch (SQLException e) {
            System.err.println("Error deleting factura produse: " + e.getMessage());
        }
    }

    public void addFacturaUtilitati(FacturaUtilitati factura) {
        try {
            facturaUtilitatiRepo.addFacturaUtilitati(factura);
        } catch (SQLException e) {
            System.err.println("Error adding factura utilitati: " + e.getMessage());
        }
    }

    public FacturaUtilitati getFacturaUtilitatiById(int id) {
        try {
            return facturaUtilitatiRepo.getFacturaUtilitatiByID(id);
        } catch (SQLException e) {
            System.err.println("Error retrieving factura utilitati: " + e.getMessage());
            return null;
        }
    }

    public List<FacturaUtilitati> getAllFacturiUtilitati() {
        try {
            return facturaUtilitatiRepo.getAllFacturiUtilitati();
        } catch (SQLException e) {
            System.err.println("Error retrieving all facturi utilitati: " + e.getMessage());
            return null;
        }
    }

    public void updateFacturaUtilitati(FacturaUtilitati factura) {
        try {
            facturaUtilitatiRepo.updateFacturaUtilitati(factura);
        } catch (SQLException e) {
            System.err.println("Error updating factura utilitati: " + e.getMessage());
        }
    }

    public void deleteFacturaUtilitati(int id) {
        try {
            facturaUtilitatiRepo.deleteFacturaUtilitati(id);
        } catch (SQLException e) {
            System.err.println("Error deleting factura utilitati: " + e.getMessage());
        }
    }
}