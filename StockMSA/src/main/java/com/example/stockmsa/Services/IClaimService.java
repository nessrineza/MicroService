package com.example.stockmsa.Services;

import com.example.stockmsa.Entites.Claim;

import java.util.List;
import java.util.Objects;

public interface IClaimService {

    public Claim addOrUpdateClaim(Claim c);
    public Claim addClaimtoUser(Claim c , long idUser);
    public Claim addClaim(Claim c );
    public Claim retrieveClaim(Integer idClaim);
    public List<Claim> retrieveAllClaims();
    public boolean removeClaim(Integer idClaim);

    public List<Claim> findAllClaimsByAnnonce(Integer id );
}


