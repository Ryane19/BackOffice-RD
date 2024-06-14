package com.example.api.controllers;

import com.example.api.model.Joueur;
import com.example.api.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

    private final JoueurRepository joueurRepository;

    @Autowired
    public JoueurController(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }


    // Endpoint to create a new player
    @PostMapping
    public ResponseEntity<Joueur> createJoueur(@RequestBody Joueur joueur) {
        Joueur newJoueur = joueurRepository.save(joueur);
        return new ResponseEntity<>(newJoueur, HttpStatus.CREATED);
    }

    // Endpoint to update an existing player
    @PutMapping("/{id}")
    public ResponseEntity<Joueur> updateJoueur(@PathVariable("id") Long id, @RequestBody Joueur joueur) {
        return joueurRepository.findById(id)
                .map(existingJoueur -> {
                    existingJoueur.setNom(joueur.getNom());
                    existingJoueur.setPrenom(joueur.getPrenom());
                    existingJoueur.setEquipe(joueur.getEquipe());
                    return new ResponseEntity<>(existingJoueur, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint to delete an existing player
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoueur(@PathVariable("id") Long id) {
        if (joueurRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
