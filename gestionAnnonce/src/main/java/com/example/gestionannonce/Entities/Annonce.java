package com.example.gestionannonce.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Annonce  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TypeA typeA;
    private  String Location;
    private  String Description;
    private float Price;
    @Enumerated(EnumType.STRING)
    private Category category;
    private  String Picture;
//    @ManyToOne
//    private User user;


}


