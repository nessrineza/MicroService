package com.example.forumo.services;

import com.example.forumo.entites.Commentaire;

import java.util.List;

public interface CommentaireService {

    List<Commentaire> getAllCommentaires();

    Commentaire getCommentaireById(Long id);

    void saveCommentaire(Commentaire commentaire);

    void deleteCommentaire(Long id);
}

