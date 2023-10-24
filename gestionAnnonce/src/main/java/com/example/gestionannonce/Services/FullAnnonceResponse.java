package com.example.gestionannonce.Services;

import com.example.gestionannonce.Entities.Category;
import com.example.gestionannonce.Entities.TypeA;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FullAnnonceResponse {
    @Enumerated(EnumType.STRING)
    private TypeA typeA;
    private  String Location;
    private  String Description;
    private float Price;
    @Enumerated(EnumType.STRING)
    private Category category;
    private  String Picture;



    List<Claim>claims;

    List<Commentaire>commentaires;

    List<Appointement>appointements;

}
