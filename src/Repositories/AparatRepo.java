package Repositories;

import java.util.List;

import Models.Aparat;

public interface AparatRepo {
    void adaugaAparat(Aparat aparat);
    Aparat gasesteAparatDupaId(int id);
    List<Aparat> toateAparatele();
    void actualizeazaAparat(Aparat aparat);
    void stergeAparat(int id);
}
