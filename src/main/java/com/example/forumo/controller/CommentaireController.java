package com.example.forumo.controller;

import com.example.forumo.entites.Commentaire;
import com.example.forumo.services.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @GetMapping("/")
    public List<Commentaire> getAllCommentaires() {
        return commentaireService.getAllCommentaires();
    }

    @GetMapping("/{id}")
    public Commentaire getCommentaire(@PathVariable Long id) {
        return commentaireService.getCommentaireById(id);
    }

    @PostMapping("/")
    public void addCommentaire(@RequestBody Commentaire commentaire) {
        commentaireService.saveCommentaire(commentaire);
    }

    @DeleteMapping("/{id}")
    public void deleteCommentaire(@PathVariable Long id) {
        commentaireService.deleteCommentaire(id);
    }
}

