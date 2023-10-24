package com.example.gestionannonce.Services;

import com.example.gestionannonce.Entities.Annonce;
import com.example.gestionannonce.Services.client.AppointementClient;
import com.example.gestionannonce.Services.client.ClaimClient;
import com.example.gestionannonce.Services.client.ForumClient;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gestionannonce.Repositories.AnnonceRepository;

import java.util.List;

@Service

public class AnnonceServiceImpl implements IAnnonceService {

    private final AnnonceRepository annonceRepository;

    private ForumClient  forumClient;
    private ClaimClient client;
    private AppointementClient Aclient;
    @Autowired
    public void Annonce(ForumClient forumClient, ClaimClient client, AppointementClient Aclient) {
        this.forumClient = forumClient;
        this.client = client;
        this.Aclient = Aclient;
    }
    
    @Autowired
    public AnnonceServiceImpl(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    @Override
    public Annonce createAnnonce(Annonce annonce) {
        // Logique pour créer une annonce
        return annonceRepository.save(annonce);
    }

    @Override
    public Annonce updateAnnonce(Integer id, Annonce annonce) {
        // Logique pour mettre à jour une annonce
        // Vous pouvez utiliser l'ID pour rechercher l'annonce dans la base de données
        Annonce existingAnnonce = annonceRepository.findById(id).orElse(null);
        if (existingAnnonce != null) {
            // Mettez à jour les propriétés de l'annonce existante
            existingAnnonce.setDescription(annonce.getDescription());
            existingAnnonce.setPrice(annonce.getPrice());
            // Continuez avec d'autres propriétés
            return annonceRepository.save(existingAnnonce);
        } else {
            return null; // L'annonce n'existe pas
        }
    }

    @Override
    public boolean deleteAnnonce(Integer id) {
       annonceRepository.deleteById(id);
       return false;
    }


    @Override
    public Annonce getAnnonceById(Integer id) {
        // Logique pour récupérer une annonce par ID
        return annonceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Annonce> getAllAnnonces() {
        // Logique pour récupérer toutes les annonces
        return annonceRepository.findAll();
    }

    @Override
    public FullAnnonceResponse findAnnoncesWithClaims(Integer annonceId) {
       var annonce = annonceRepository.findById(annonceId)
               .orElse(
                Annonce.builder()

                        .Location("NOT_FOUND")
                        .Description("NOT_FOUND")
                        .build()
               );
        var claims=client.findAllClaimsByAnnonce(annonceId);


        return FullAnnonceResponse.builder()
                .Location(annonce.getLocation())
                .Description(annonce.getDescription())
                .claims(claims)
                .build();
    }

    @Override
    public FullAnnonceResponse findAnnoncesWithCommentaires(Integer annonceId) {
        var annonce = annonceRepository.findById(annonceId)
                .orElse(
                        Annonce.builder()

                                .Location("NOT_FOUND")
                                .Description("NOT_FOUND")
                                .build()
                );

        var commentaires=forumClient.findAllcommentairesByAnnonce(annonceId);


        return FullAnnonceResponse.builder()
                .Location(annonce.getLocation())
                .Description(annonce.getDescription())
                .commentaires(commentaires)
                .build();
    }

  

     @Override
     public FullAnnonceResponse findSchoolWithAppointements(Integer id) {
         var annonce = annonceRepository.findById(id)
                 .orElse(
                         Annonce.builder()
                                 .Location("NOT_FOUND")
                                 .Description("NOT_FOUND")
                                 .build()
                 );

         if (Aclient != null) {
             var appointements = Aclient.findAllAppointementsByAnnonce(id);

             return FullAnnonceResponse.builder()
                     .Description(annonce.getDescription())
                     .Location(annonce.getLocation())
                     .appointements(appointements)
                     .build();
         } else {

             return FullAnnonceResponse.builder()
                     .Description(annonce.getDescription())
                     .Location(annonce.getLocation())
                     .appointements(null)
                     .build();
         }
     }


}


