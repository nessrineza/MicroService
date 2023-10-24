package com.example.gestionannonce.Services;

import com.example.gestionannonce.Entities.Annonce;

import java.util.List;

public interface IAnnonceService {
    Annonce createAnnonce(Annonce annonce);
    Annonce updateAnnonce(Integer id, Annonce annonce);
 boolean deleteAnnonce(Integer id);
    Annonce getAnnonceById(Integer id);
    List<Annonce> getAllAnnonces();
   public FullAnnonceResponse findAnnoncesWithClaims(Integer annonceId);

   public FullAnnonceResponse findAnnoncesWithCommentaires(Integer id);
    public FullAnnonceResponse findSchoolWithAppointements(Integer id);
}
