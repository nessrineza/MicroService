package com.example.stockmsa.Controller;

import com.example.stockmsa.Entites.Claim;
import com.example.stockmsa.Services.IClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final IClaimService claimService;

    @Autowired
    public ClaimController(IClaimService claimService) {
        this.claimService = claimService;
    }

    @GetMapping
    public ResponseEntity<List<Claim>> getAllClaims() {
        List<Claim> claims = claimService.retrieveAllClaims();
        return new ResponseEntity<>(claims, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Integer id) {
        Claim claim = claimService.retrieveClaim(id);
        if (claim != null) {
            return new ResponseEntity<>(claim, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Claim> addOrUpdateClaim(@RequestBody Claim claim) {
        Claim addedClaim = claimService.addOrUpdateClaim(claim);
        return new ResponseEntity<>(addedClaim, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Integer id) {
      boolean deleted = claimService.removeClaim(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/with-annonce/{annonce-id}")
    public ResponseEntity<List<Claim>> findAllClaims(
            @PathVariable("annonce-id") Integer id) {
         return  ResponseEntity.ok(claimService.findAllClaimsByAnnonce(id));
    }

}
