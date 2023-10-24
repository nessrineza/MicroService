package com.example.forum.services;

import com.example.forum.entites.Commentaire;
import com.example.forum.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Override
    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    @Override
    public Commentaire getCommentaireById(Integer id) {
        return commentaireRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCommentaire(Commentaire commentaire) {
        commentaireRepository.save(commentaire);
    }

    @Override
    public boolean deleteCommentaire(Integer id) {
        commentaireRepository.deleteById(id);
        return false;
    }

    @Override
    public List<Commentaire> findAllCommentairesByAnnonce(Integer id) {
        return commentaireRepository.findAllByAnnonceId(id);
    }


}

