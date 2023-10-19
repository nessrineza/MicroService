package com.example.stockmsa.Services;

import com.example.stockmsa.Entites.Claim;

import java.util.List;

public interface IClaimService {

    public Claim addOrUpdateClaim(Claim c);
    public Claim addClaimtoUser(Claim c , long idUser);
    public Claim addClaim(Claim c );
    public Claim retrieveClaim(Integer idClaim);
    public List<Claim> retrieveAllClaims();
    public void removeClaim(Integer idClaim);
}


