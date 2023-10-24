package com.example.gestionannonce.Services.client;

import com.example.gestionannonce.Services.Appointement;
import com.example.gestionannonce.Services.Claim;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "appointement-service" ,url ="http://localhost:8082/api/rdv/Appointement")
public interface AppointementClient {
    @GetMapping("/with-annonce/{annonce-id}")
   List<Appointement> findAllAppointementsByAnnonce(@PathVariable("annonce-id") Integer id);
}





