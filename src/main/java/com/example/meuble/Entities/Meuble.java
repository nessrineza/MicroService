package com.example.meuble.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.io.Serializable;
@Entity
public class Meuble implements Serializable {
    private static final long serialVersionUID = 795450928237931201L;

    @Id
    @GeneratedValue
    private int id;
    private String nom, description;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Meuble() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Meuble(String nom, String description) {
        super();
        this.nom = nom;
        this.description = description;
    }
}