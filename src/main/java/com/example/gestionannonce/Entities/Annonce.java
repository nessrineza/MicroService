package com.example.gestionannonce.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Annonce  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Enumerated(EnumType.STRING)
    private com.example.gestionannonce.Entities.TypeA TypeA;
    private  String Location;
    private  String Description;
    private float Price;
    @Enumerated(EnumType.STRING)
    private com.example.gestionannonce.Entities.Category Category;
    private  String Picture;
//    @ManyToOne
//    private User user;
//    @ManyToMany()
//    private List<Sponsoring> sponsorings;


}


