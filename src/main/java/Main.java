import Models.*;
import com.mysql.cj.xdevapi.AbstractDataResult;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            AppService appService = AppService.getInstance(Settings.url, Settings.user, Settings.password);
            boolean running = true;

            while (running) {
                System.out.println("\n=== MENIU ===");
                System.out.println("1. Adauga aparat");
                System.out.println("2. Afiseaza toate aparatele");
                System.out.println("3. Adauga client");
                System.out.println("4. Afiseaza toti clientii");
                System.out.println("5. Adauga abonament");
                System.out.println("6. Afiseaza toate abonamentele");
                System.out.println("7. Adauga achizitie");
                System.out.println("8. Afiseaza toate achizitiile");
                System.out.println("9. Adauga sala");
                System.out.println("10. Afiseaza toate salile");
                System.out.println("11. Adauga produs");
                System.out.println("12. Afiseaza toate produsele");
                System.out.println("13. Adauga utilitate");
                System.out.println("14. Afiseaza toate utilitatile");
                System.out.println("15. Adauga factura");
                System.out.println("16. Afiseaza toate facturile");
                System.out.println("17. Afiseaza toate produsele sortate descrescator dupa pret");
                System.out.println("18. Grupare facturi in functie de suma intr-un HashMap");
                System.out.println("19. Sterge un aparat");
                System.out.println("20. Actualizeaza un client");
                System.out.println("21. Iesire");
                System.out.print("Alege optiunea: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // curata linia

                switch (option) {
                    case 1: // Adauga aparat
                        System.out.print("Nume aparat: ");
                        String numeAparat = scanner.nextLine();
                        System.out.print("Greutate: ");
                        double masa_maxima = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Este disponibil (true/false): ");
                        String disponibilitate = scanner.nextLine();
                        scanner.nextLine();
                        System.out.print("Grupa musculara lucrata: ");
                        String grupaMuscularaLucrata = scanner.nextLine();
                        Aparat aparat = new Aparat(numeAparat, masa_maxima, disponibilitate, grupaMuscularaLucrata);
                        appService.addAparat(aparat);
                        AuditLog.log("Adaugare aparat");
                        break;

                    case 2: // Afiseaza aparate
                        List<Aparat> aparate = appService.getAllAparate();
                        for (Aparat a : aparate) {
                            System.out.println(a.getId_aparat() + " - " + a.getNume() + " - " + a.getMasa_maxima() + " kg - " + a.getDisponibilitate() + " - " + a.getGrupaMuscularaLucrata());
                        }
                        AuditLog.log("Afisare aparate");
                        break;

                    case 3: // Adauga client
                        System.out.print("Nume client: ");
                        String numeClient = scanner.nextLine();
                        System.out.print("Prenume client: ");
                        String prenumeClient = scanner.nextLine();
                        System.out.print("Email: ");
                        String emailClient = scanner.nextLine();
                        System.out.print("Nr telefon: ");
                        String telefonClient = scanner.nextLine();
                        Client client = new Client(0, numeClient, prenumeClient, emailClient, telefonClient);
                        appService.addClient(client);
                        AuditLog.log("Adaugare client");
                        break;

                    case 4: // Afiseaza clienti
                        List<Client> clienti = appService.getAllClients();
                        for (Client c : clienti) {
                            System.out.println(c.getIdClient() + " - " + c.getNume() + " " + c.getPrenume() + " - " + c.getEmail() + " - " + c.getNrTelefon());
                        }
                        AuditLog.log("Afisare clienti");
                        break;

                    case 5: // Adauga abonament
                        System.out.print("Pret abonament: ");
                        double pretAbonament = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Tip abonament: ");
                        String tipAbonament = scanner.nextLine();
                        System.out.print("Data valabilitate (yyyy-MM-dd): ");
                        String dataVal = scanner.nextLine();
                        System.out.print("ID sala: ");
                        int idSalaAb = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("ID client: ");
                        int idClientAb = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            Date dataValabilitate = java.sql.Date.valueOf(dataVal);
                            Abonament abonament = new Abonament(0, pretAbonament, tipAbonament, dataValabilitate, idSalaAb);
                            appService.addAbonament(abonament);
                        } catch (Exception e) {
                            System.out.println("Format data invalid.");
                        }
                        AuditLog.log("Adaugare abonament");
                        break;

                    case 6: // Afiseaza abonamente
                        List<Abonament> abonamente = appService.getAllAbonamente();
                        for (Abonament ab : abonamente) {
                            System.out.println(ab.getIdAbonament() + " - " + ab.getTipAbonament());
                        }
                        AuditLog.log("Afisare abonamente");
                        break;

                    case 7: // Adauga achizitie
                        System.out.print("ID client: ");
                        int idClientAch = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Data achizitie (yyyy-MM-dd): ");
                        String dataAch = scanner.nextLine();
                        try {
                            Date dataAchiz = java.sql.Date.valueOf(dataAch);
                            Achizitie achizitie = new Achizitie(0, dataAchiz, idClientAch);
                            appService.addAchizitie(achizitie);
                        } catch (Exception e) {
                            System.out.println("Format data invalid.");
                        }
                        AuditLog.log("Adaugare achizitie");
                        break;

                    case 8: // Afiseaza achizitii
                        List<Achizitie> achizitii = appService.getAllAchizitii();
                        for (Achizitie ach : achizitii) {
                            System.out.println(ach.getIdAchizitie() + " - " + ach.getIdClient());
                        }
                        AuditLog.log("Afisare achizitii");
                        break;

                    case 9: // Adauga sala
                        System.out.print("Numar clienti sala: ");
                        int nrClientiSala = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Venituri sala: ");
                        double venituriSala = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Numar produse sala: ");
                        int nrProduseSala = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nume manager sala: ");
                        String managerSala = scanner.nextLine();
                        System.out.print("Este deschisa (true/false): ");
                        String deschisSala = scanner.nextLine();
                        scanner.nextLine();
                        Sala sala = new Sala(0, nrClientiSala, venituriSala, nrProduseSala, managerSala, deschisSala);
                        appService.addSala(sala);
                        AuditLog.log("Adaugare sala");
                        break;

                    case 10: // Afiseaza sali
                        List<Sala> sali = appService.getAllSali();
                        for (Sala s : sali) {
                            System.out.println(s.getIdSala() + " - " + s.getNumeManager());
                        }
                        AuditLog.log("Afisare sali");
                        break;

                    case 11: // Adauga produs
                        System.out.print("Nume produs: ");
                        String numeProdus = scanner.nextLine();
                        System.out.print("Cantitate produs: ");
                        int cantitateProdus = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Pret produs: ");
                        double pretProdus = scanner.nextDouble();
                        scanner.nextLine();
                        Produs produs = new Produs(0, numeProdus, cantitateProdus, pretProdus);
                        appService.addProdus(produs);
                        AuditLog.log("Adaugare produs");
                        break;

                    case 12: // Afiseaza produse
                        List<Produs> produse = appService.getAllProduse();
                        for (Produs prod : produse) {
                            System.out.println(prod.getIdProdus() + " - " + prod.getNume() + " - " + prod.getPret() + " lei");
                        }
                        AuditLog.log("Afisare produse");
                        break;

                    case 13: // Adauga utilitate
                        System.out.print("Nume utilitate: ");
                        String numeUtilitate = scanner.nextLine();
                        System.out.print("Cantitate utilitate: ");
                        int cantitateUtilitate = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Pret utilitate: ");
                        double pretUtilitate = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("ID sala: ");
                        int idSalaUtil = scanner.nextInt();
                        scanner.nextLine();
                        Utilitate utilitate = new Utilitate(0, numeUtilitate, cantitateUtilitate, pretUtilitate, idSalaUtil);
                        appService.addUtilitate(utilitate);
                        AuditLog.log("Adaugare utilitate");
                        break;

                    case 14: // Afiseaza utilitati
                        List<Utilitate> utilitati = appService.getAllUtilitati();
                        for (Utilitate u : utilitati) {
                            System.out.println(u.getIdUtilitate() + " - " + u.getNume());
                        }
                        AuditLog.log("Afisare utilitati");
                        break;

                    case 15: // Adauga factura
                        System.out.print("Suma factura: ");
                        double sumaFactura = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Data factura (yyyy-MM-dd): ");
                        String dataFact = scanner.nextLine();
                        try {
                            Date dataFactura = java.sql.Date.valueOf(dataFact);
                            Factura factura = new Factura(0, sumaFactura, dataFactura);
                            appService.addFactura(factura);

                        } catch (Exception e) {
                            System.out.println("Format data invalid.");
                        }
                        AuditLog.log("Adaugare factura");
                        break;

                    case 16: // Afiseaza facturi
                        List<Factura> facturi = appService.getAllFacturi();
                        for (Factura fac : facturi) {
                            System.out.println(fac.getIdFactura() + " - " + fac.getSuma());
                        }
                        AuditLog.log("Afisare facturi");
                        break;
                    case 17: // afisez produsele descrescator dupa pret
                        List<Produs> produseSortate = appService.getAllProduse();
                        produseSortate.sort((p1, p2) -> Double.compare(p2.getPret(), p1.getPret())); // sortare desc dupa pret

                        System.out.println("Produse sortate descrescator dupa pret:");
                        for (Produs prod : produseSortate) {
                            System.out.println(prod.getIdProdus() + " - " + prod.getNume() + " - " + prod.getPret() + " lei");
                        }
                        AuditLog.log("Afisare produse sortate descrescator dupa pret");
                        break;

                    case 18: // HashMap pentru facturi: suma -> set de ID-uri
                        List<Factura> lista_facturi = appService.getAllFacturi();
                        Map<Double, Set<Integer>> facturiMap = new HashMap<>();

                        for (Factura factura : lista_facturi) {
                            double suma = factura.getSuma();
                            int id = factura.getIdFactura();

                            facturiMap.computeIfAbsent(suma, k -> new HashSet<>()).add(id);
                        }
                        System.out.println("HashMap: suma -> set de id_facturi");
                        for (Map.Entry<Double, Set<Integer>> entry : facturiMap.entrySet()) {
                            System.out.println(entry.getKey() + " lei -> " + entry.getValue());
                        }
                        AuditLog.log("Grupare facturi in functie de suma intr-un HashMap");
                        break;

                    case 19: // Sterge aparat
                        System.out.print("ID aparat de sters: ");
                        int idAparat = scanner.nextInt();
                        scanner.nextLine();
                        appService.deleteAparat(idAparat);
                        System.out.println("Aparatul a fost sters cu succes.");
                        AuditLog.log("Stergere aparat cu ID: " + idAparat);

                        break;
                    case 20: // Update client
                        System.out.print("ID client de actualizat: ");
                        int idClientUpdate = scanner.nextInt();
                        scanner.nextLine();
                        Client clientUpdate = appService.getClientById(idClientUpdate);
                        if (clientUpdate != null) {
                            System.out.print("Nume nou: ");
                            String numeNou = scanner.nextLine();
                            System.out.print("Prenume nou: ");
                            String prenumeNou = scanner.nextLine();
                            System.out.print("Email nou: ");
                            String emailNou = scanner.nextLine();
                            System.out.print("Nr telefon nou: ");
                            String telefonNou = scanner.nextLine();

                            clientUpdate.setNume(numeNou);
                            clientUpdate.setPrenume(prenumeNou);
                            clientUpdate.setEmail(emailNou);
                            clientUpdate.setNrTelefon(telefonNou);

                            appService.updateClient(clientUpdate);
                            System.out.println("Clientul a fost actualizat cu succes.");
                        } else {
                            System.out.println("Clientul cu ID-ul specificat nu exista.");
                        }
                        AuditLog.log("Actualizare client cu ID: " + idClientUpdate);
                        break;

                    case 21: // Iesire
                        running = false;
                        AuditLog.log("Iesire din aplicatie");
                        break;

                    default:
                        System.out.println("Optiune invalida.");
                }
            }
        } catch (Exception e) {
            System.out.println("Eroare la initializarea aplicatiei: " + e.getMessage());
        }
    }

}
