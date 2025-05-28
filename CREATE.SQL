
DROP TABLE IF EXISTS Utilitati_platite_prin;
DROP TABLE IF EXISTS Facturi_Utilitati;
DROP TABLE IF EXISTS Facturi_Abonament;
DROP TABLE IF EXISTS Facturi_Produse;
DROP TABLE IF EXISTS Detine;
DROP TABLE IF EXISTS Detalii_Achizitie;
DROP TABLE IF EXISTS Achizitie;
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS Abonament;
DROP TABLE IF EXISTS Aparate;
DROP TABLE IF EXISTS Utilitati;
DROP TABLE IF EXISTS Facturi;
DROP TABLE IF EXISTS Produse;
DROP TABLE IF EXISTS Sala;


CREATE TABLE Sala (
                      id_sala INT AUTO_INCREMENT PRIMARY KEY,
                      nr_clienti INT,
                      venituri DECIMAL(10,2),
                      nr_produse INT,
                      nume_manager VARCHAR(255),
                      deschis VARCHAR(5)
) ENGINE=InnoDB;

CREATE TABLE Produse (
                         id_produse INT AUTO_INCREMENT PRIMARY KEY,
                         nume VARCHAR(100),
                         cantitate INT,
                         pret DECIMAL(10,2)
) ENGINE=InnoDB;

CREATE TABLE Aparate (
                         id_aparat INT AUTO_INCREMENT PRIMARY KEY,
                         id_sala INT,
                         nume VARCHAR(100),
                         masa_maxima INT,
                         disponibilitate VARCHAR(5),
                         grupa_musculara_lucrata VARCHAR(255),
                         FOREIGN KEY (id_sala) REFERENCES Sala(id_sala)
) ENGINE=InnoDB;

CREATE TABLE Abonament (
                           id_abonament INT AUTO_INCREMENT PRIMARY KEY,
                           id_sala INT,
                           pret DECIMAL(10,2),
                           tip_abonament VARCHAR(100),
                           data_valabilitate DATE,
                           FOREIGN KEY (id_sala) REFERENCES Sala(id_sala)
) ENGINE=InnoDB;

CREATE TABLE Client (
                        id_client INT AUTO_INCREMENT PRIMARY KEY,
                        id_abonament INT,
                        nume VARCHAR(255),
                        prenume VARCHAR(255),
                        email VARCHAR(255),
                        nr_telefon VARCHAR(15),
                        FOREIGN KEY (id_abonament) REFERENCES Abonament(id_abonament)
) ENGINE=InnoDB;

CREATE TABLE Achizitie (
                           id_achizitie INT AUTO_INCREMENT PRIMARY KEY,
                           id_client INT,
                           data DATE,
                           FOREIGN KEY (id_client) REFERENCES Client(id_client)
) ENGINE=InnoDB;

CREATE TABLE Detalii_Achizitie (
                                   id_detalii_achizitie INT AUTO_INCREMENT PRIMARY KEY,
                                   id_produse INT,
                                   id_achizitie INT,
                                   cantitate INT,
                                   FOREIGN KEY (id_produse) REFERENCES Produse(id_produse),
                                   FOREIGN KEY (id_achizitie) REFERENCES Achizitie(id_achizitie)
) ENGINE=InnoDB;

CREATE TABLE Detine (
                        id_sala INT,
                        id_produse INT,
                        PRIMARY KEY (id_sala, id_produse),
                        FOREIGN KEY (id_sala) REFERENCES Sala(id_sala),
                        FOREIGN KEY (id_produse) REFERENCES Produse(id_produse)
) ENGINE=InnoDB;

CREATE TABLE Utilitati (
                           id_utilitati INT AUTO_INCREMENT PRIMARY KEY,
                           nume VARCHAR(100),
                           cantitate INT,
                           pret DECIMAL(10,2),
                           id_sala INT,
                           FOREIGN KEY (id_sala) REFERENCES Sala(id_sala)
) ENGINE=InnoDB;

CREATE TABLE Facturi (
                         id_facturi INT AUTO_INCREMENT PRIMARY KEY,
                         suma DECIMAL(10,2),
                         data DATE
) ENGINE=InnoDB;

CREATE TABLE Facturi_Utilitati (
                                   id_facturi INT,
                                   id_facturi_utilitati INT,
                                   PRIMARY KEY (id_facturi, id_facturi_utilitati),
                                   FOREIGN KEY (id_facturi) REFERENCES Facturi(id_facturi)
) ENGINE=InnoDB;

CREATE TABLE Utilitati_platite_prin (
                                        id_utilitati INT,
                                        id_facturi INT,
                                        id_facturi_utilitati INT,
                                        PRIMARY KEY (id_utilitati, id_facturi, id_facturi_utilitati),
                                        FOREIGN KEY (id_utilitati) REFERENCES Utilitati(id_utilitati),
                                        FOREIGN KEY (id_facturi, id_facturi_utilitati) REFERENCES Facturi_Utilitati(id_facturi, id_facturi_utilitati)
) ENGINE=InnoDB;

CREATE TABLE Facturi_Abonament (
                                   id_facturi INT,
                                   id_facturi_abonament INT,
                                   id_client INT,
                                   PRIMARY KEY (id_facturi, id_facturi_abonament),
                                   FOREIGN KEY (id_client) REFERENCES Client(id_client),
                                   FOREIGN KEY (id_facturi) REFERENCES Facturi(id_facturi)
) ENGINE=InnoDB;

CREATE TABLE Facturi_Produse (
                                 id_facturi INT,
                                 id_facturi_produse INT,
                                 id_achizitie INT,
                                 PRIMARY KEY (id_facturi, id_facturi_produse),
                                 FOREIGN KEY (id_achizitie) REFERENCES Achizitie(id_achizitie),
                                 FOREIGN KEY (id_facturi) REFERENCES Facturi(id_facturi)
) ENGINE=InnoDB;


