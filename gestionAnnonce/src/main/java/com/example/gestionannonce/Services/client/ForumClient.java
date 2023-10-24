package com.example.gestionannonce.Services.client;

import com.example.gestionannonce.Services.Claim;
import com.example.gestionannonce.Services.Commentaire;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "forum-service",url ="http://localhost:8080/api/commentaires/commentaires")
public interface ForumClient {
    @GetMapping("/with-annonce/{annonce-id}")
    List<Commentaire>findAllcommentairesByAnnonce(@PathVariable("annonce-id") Integer id);

}
