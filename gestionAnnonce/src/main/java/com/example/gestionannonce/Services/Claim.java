package com.example.gestionannonce.Services;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Claim {
    @Enumerated(EnumType.STRING)
    private Subject Subject;
    @Temporal(TemporalType.DATE)
    private java.util.Date Date;
    private  String Description;
}
