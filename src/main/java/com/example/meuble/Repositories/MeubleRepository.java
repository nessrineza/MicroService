package com.example.meuble.Repositories;

import com.example.meuble.Entities.Meuble;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MeubleRepository extends JpaRepository<Meuble, Integer> {
    @Query("select c from Meuble c where c.nom like :name")
    public Page<Meuble> meubleByNom(@Param("name") String n, Pageable pageable);
}
