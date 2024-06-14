package com.example.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String ville;
    private String logo; // Logo de l'équipe

    public Equipe() {
    }

    // Constructeur
    public Equipe(String nom, String ville, String logo) {
        this.nom = nom;
        this.ville = ville;
        this.logo = logo;
    }


    // Getters et Setters

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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    // Méthode pour afficher les détails de l'équipe
    public void afficherDetails() {
        System.out.println("Nom de l'équipe : " + nom);
        System.out.println("Ville de l'équipe : " + ville);
        // Affichage du logo ici (à implémenter selon les besoins)
    }
}

