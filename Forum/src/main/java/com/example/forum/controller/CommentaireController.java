package com.example.forum.controller;

import com.example.forum.entites.Commentaire;
import com.example.forum.services.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Commentaire>> getAllCommentaires() {
        List<Commentaire> commentaires = commentaireService.getAllCommentaires();

        if (!commentaires.isEmpty()) {
            // Si la liste de commentaires n'est pas vide, renvoyez un ResponseEntity avec les commentaires et le code 200 (OK).
            return new ResponseEntity<>(commentaires, HttpStatus.OK);
        } else {
            // Si la liste de commentaires est vide, renvoyez un ResponseEntity avec le code 204 (No Content) pour indiquer qu'il n'y a aucun commentaire.
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Commentaire> getCommentaire(@PathVariable Integer id) {
        Commentaire commentaire = commentaireService.getCommentaireById(id);

        if (commentaire != null) {
            // Si le commentaire a été trouvé, renvoyez un ResponseEntity avec le commentaire et le code 200 (OK).
            return new ResponseEntity<>(commentaire, HttpStatus.OK);
        } else {
            // Si le commentaire n'a pas été trouvé, renvoyez un ResponseEntity avec le code 404 (Not Found).
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Void> addCommentaire(@RequestBody Commentaire commentaire, UriComponentsBuilder builder) {
        commentaireService.saveCommentaire(commentaire);

        // Créez l'URI de la nouvelle ressource créée (le commentaire) pour l'inclure dans l'en-tête Location.
        // Vous pouvez utiliser UriComponentsBuilder pour générer l'URI en fonction de l'ID du nouveau commentaire, par exemple.
        // Assurez-vous que votre service retourne l'ID du commentaire nouvellement créé.
        // Si vous utilisez une base de données qui génère automatiquement des identifiants, récupérez l'ID du commentaire après l'ajout.

        // Exemple (utilisez le vrai ID du nouveau commentaire ici) :
        long newCommentId = 123;

        String uri = builder.path("/commentaires/{id}").buildAndExpand(newCommentId).toUriString();
        return ResponseEntity.created(URI.create(uri)).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable Integer id) {
        boolean deleted = commentaireService.deleteCommentaire(id);

        if (deleted) {
            // Si la suppression a réussi, renvoyez un ResponseEntity avec le code 204 (No Content).
            return ResponseEntity.noContent().build();
        } else {
            // Si la suppression a échoué (par exemple, si l'ID n'a pas été trouvé), renvoyez un ResponseEntity avec le code 404 (Not Found).
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/with-annonce/{annonce-id}")
    public ResponseEntity<List<Commentaire>>
    getCommentairesByAnnonce(@PathVariable Integer id) {
        List<Commentaire> commentaires = commentaireService.findAllCommentairesByAnnonce(id);
        return ResponseEntity.ok(commentaires);
    }
}








