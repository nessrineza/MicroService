package com.example.gestionannonce.Services;

import com.example.gestionannonce.Entities.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gestionannonce.Controllers.Repositories.AnnonceRepository;
import java.util.List;

@Service
public class AnnonceServiceImpl implements IAnnonceService {

    private final AnnonceRepository annonceRepository;

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
    public void deleteAnnonce(Integer id) {
        // Logique pour supprimer une annonce par ID
        annonceRepository.deleteById(id);
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
}

