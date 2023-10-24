package com.example.forum.services;

import com.example.forum.entites.Commentaire;

import java.util.List;

public interface CommentaireService {

    List<Commentaire> getAllCommentaires();

    Commentaire getCommentaireById(Integer id);

    void saveCommentaire(Commentaire commentaire);

    boolean deleteCommentaire(Integer id);
     List<Commentaire>findAllCommentairesByAnnonce(Integer id) ;

}

