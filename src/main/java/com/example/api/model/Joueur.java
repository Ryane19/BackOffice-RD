package com.example.api.model;

import javax.persistence.*;

@Entity
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    // Constructors, getters, and setters
    public Joueur() {}

    public Joueur(String nom, String prenom, Equipe equipe) {
        this.nom = nom;
        this.prenom = prenom;
        this.equipe = equipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
