package com.example.forum.controller;

import com.example.forum.entites.SujetDeDiscussion;
import com.example.forum.services.SujetDeDiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sujets")
public class SujetDeDiscussionController {

    @Autowired
    private SujetDeDiscussionService sujetDeDiscussionService;

    @GetMapping("/")
    public ResponseEntity<List<SujetDeDiscussion>> getAllSujets() {
        List<SujetDeDiscussion> sujets = sujetDeDiscussionService.getAllSujets();

        if (!sujets.isEmpty()) {
            // Si la liste de sujets n'est pas vide, renvoyez un ResponseEntity avec les sujets et le code 200 (OK).
            return new ResponseEntity<>(sujets, HttpStatus.OK);
        } else {
            // Si la liste de sujets est vide, renvoyez un ResponseEntity avec le code 204 (No Content) pour indiquer qu'il n'y a aucun sujet.
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }




@GetMapping("/get/{id}")
public ResponseEntity<SujetDeDiscussion> getSujet(@PathVariable Long id) {
    SujetDeDiscussion sujet = sujetDeDiscussionService.getSujetById(id);

    if (sujet != null) {
        // Si le sujet a été trouvé, renvoyez un ResponseEntity avec le sujet et le code 200 (OK).
        return new ResponseEntity<>(sujet, HttpStatus.OK);
    } else {
        // Si le sujet n'a pas été trouvé, renvoyez un ResponseEntity avec le code 404 (Not Found).
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


    @PostMapping("/add")
    public ResponseEntity<Void> addSujet(@RequestBody SujetDeDiscussion sujet, UriComponentsBuilder builder) {
        sujetDeDiscussionService.saveSujet(sujet);

        // Assumez que votre service retourne l'ID du sujet nouvellement créé.
        // Si l'ID est généré automatiquement, récupérez-le après l'ajout.

        long newSujetId = 123; // Utilisez le vrai ID du nouveau sujet.

        // Créez l'URI de la nouvelle ressource en utilisant le modèle d'URI.
        // Exemple : /get/{id}
        String uri = builder.path("/get/{id}").buildAndExpand(newSujetId).toUriString();

        // Utilisez ResponseEntity.created() pour créer une réponse avec l'URI de la nouvelle ressource.
        return ResponseEntity.created(URI.create(uri)).build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSujet(@PathVariable Long id) {
        boolean deleted = sujetDeDiscussionService.deleteSujet(id);

        if (deleted) {
            // Si la suppression a réussi, renvoyez un ResponseEntity avec le code 204 (No Content).
            return ResponseEntity.noContent().build();
        } else {
            // Si la suppression a échoué (par exemple, si l'ID n'a pas été trouvé), renvoyez un ResponseEntity avec le code 404 (Not Found).
            return ResponseEntity.notFound().build();
        }
    }
}


