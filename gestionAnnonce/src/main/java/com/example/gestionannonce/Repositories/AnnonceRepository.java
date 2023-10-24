package com.example.gestionannonce.Repositories;

import com.example.gestionannonce.Entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {


}
