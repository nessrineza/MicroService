package com.example.gestionannonce.Controllers;

import com.example.gestionannonce.Entities.Annonce;
import com.example.gestionannonce.Services.FullAnnonceResponse;
import com.example.gestionannonce.Services.IAnnonceService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {

    private final IAnnonceService annonceService;

    @Autowired
    public AnnonceController(IAnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @PostMapping
    public ResponseEntity<Annonce> createAnnonce(@RequestBody Annonce annonce) {
        Annonce createdAnnonce = annonceService.createAnnonce(annonce);
        return new ResponseEntity<>(createdAnnonce, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Annonce> updateAnnonce(@PathVariable Integer id, @RequestBody Annonce annonce) {
        Annonce updatedAnnonce = annonceService.updateAnnonce(id, annonce);
        if (updatedAnnonce != null) {
            return new ResponseEntity<>(updatedAnnonce, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable Integer id) {
        boolean deleted = annonceService.deleteAnnonce(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Annonce> getAnnonceById(@PathVariable Integer id) {
        Annonce annonce = annonceService.getAnnonceById(id);
        if (annonce != null) {
            return new ResponseEntity<>(annonce, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Annonce>> getAllAnnonces() {
        List<Annonce> annonces = annonceService.getAllAnnonces();
        if (annonces.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(annonces, HttpStatus.OK);
        }
    }
    @GetMapping("/with-annonce/{annonce-id}")

    public ResponseEntity<FullAnnonceResponse> findAllAnnonce(@PathVariable("annonce-id") Integer annonceId) {
        try {
            var annonces = annonceService.findAnnoncesWithClaims(annonceId);
            return ResponseEntity.ok(annonces);
        } catch (NoSuchElementException e) {
            // L'annonce avec l'ID spécifié n'a pas été trouvée, vous pouvez retourner une réponse 404 (Not Found).
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // Gérez toutes les autres exceptions inattendues ici, par exemple, en renvoyant une réponse 500 (Internal Server Error).
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/with-forum/{annonce-id}")

    public ResponseEntity<FullAnnonceResponse> findAllAnnonceF(
            @PathVariable("annonce-id") Integer annonceId) {
       try {
           var commantaire = annonceService.findAnnoncesWithCommentaires(annonceId);
           return  ResponseEntity.ok(commantaire);
       }
       catch (NoSuchElementException e){
           return ResponseEntity.notFound().build();
       } catch (Exception e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }


    @GetMapping("/with-appointement/{annonceId}")
    public ResponseEntity<FullAnnonceResponse> findAllAnnoncesA(@PathVariable("annonceId") Integer id) {
        try {
        var appointement = annonceService.findSchoolWithAppointements(id);
        return ResponseEntity.ok(appointement);

        } catch (NoSuchElementException e) {
            // L'annonce avec l'ID spécifié n'a pas été trouvée, vous pouvez retourner une réponse 404 (Not Found).
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // Gérez toutes les autres exceptions inattendues ici, par exemple, en renvoyant une réponse 500 (Internal Server Error).
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

}
