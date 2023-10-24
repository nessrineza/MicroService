package com.example.gestionannonce.Services.client;

import com.example.gestionannonce.Services.Claim;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name = "claim-service", path = "/claims")
@FeignClient(name = "claim-service", url ="http://localhost:8083/api/claim/claims")
public interface ClaimClient {

    @GetMapping("/with-annonce/{annonce-id}")
    List<Claim> findAllClaimsByAnnonce(@PathVariable("annonce-id") Integer id);

}
