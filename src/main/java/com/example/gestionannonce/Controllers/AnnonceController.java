package com.example.gestionannonce.Controllers;

import com.example.gestionannonce.Entities.Annonce;
import com.example.gestionannonce.Services.IAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {

    private final IAnnonceService annonceService;

    @Autowired
    public AnnonceController(IAnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @PostMapping
    public Annonce createAnnonce(@RequestBody Annonce annonce) {
        return annonceService.createAnnonce(annonce);
    }

    @PutMapping("/{id}")
    public Annonce updateAnnonce(@PathVariable Integer id, @RequestBody Annonce annonce) {
        return annonceService.updateAnnonce(id, annonce);
    }

    @DeleteMapping("/{id}")
    public void deleteAnnonce(@PathVariable Integer id) {
        annonceService.deleteAnnonce(id);
    }

    @GetMapping("/{id}")
    public Annonce getAnnonceById(@PathVariable Integer id) {
        return annonceService.getAnnonceById(id);
    }

    @GetMapping
    public List<Annonce> getAllAnnonces() {
        return annonceService.getAllAnnonces();
    }

    public class ErrorController {

        @RequestMapping("/error")
        public String handleError() {
            // Logique pour gérer l'erreur
            return "error-page"; // Remplacez par le nom de votre page d'erreur
        }
    }

}

