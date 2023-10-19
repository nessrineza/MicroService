package com.example.stockmsa.Controller;



import com.example.stockmsa.Entites.Claim;
import com.example.stockmsa.Services.IClaimService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Claim> getAllClaims() {
        return claimService.retrieveAllClaims();
    }

    @GetMapping("/{id}")
    public Claim getClaimById(@PathVariable Integer id) {
        return claimService.retrieveClaim(id);
    }

    @PostMapping
    public Claim addOrUpdateClaim(@RequestBody Claim claim) {
        return claimService.addOrUpdateClaim(claim);
    }

    @DeleteMapping("/{id}")
    public void deleteClaim(@PathVariable Integer id) {
        claimService.removeClaim(id);
    }
}
