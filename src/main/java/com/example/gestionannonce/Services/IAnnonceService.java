package com.example.gestionannonce.Services;

import com.example.gestionannonce.Entities.Annonce;

import java.util.List;

public interface IAnnonceService {
    Annonce createAnnonce(Annonce annonce);
    Annonce updateAnnonce(Integer id, Annonce annonce);
    void deleteAnnonce(Integer id);
    Annonce getAnnonceById(Integer id);
    List<Annonce> getAllAnnonces();
}
