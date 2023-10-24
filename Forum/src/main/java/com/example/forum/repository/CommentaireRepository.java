package com.example.forum.repository;

import com.example.forum.entites.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
    List<Commentaire> findAllByAnnonceId(Integer id);
}
