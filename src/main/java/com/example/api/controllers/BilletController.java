package com.example.api.controllers;

import com.example.api.repository.BilletRepository;
import com.example.api.model.Billet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billets")
public class BilletController {

    private final BilletRepository billetRepository;

    @Autowired
    public BilletController(BilletRepository billetDAO) {

    this.billetRepository = billetDAO;

    }

    // Endpoint pour récupérer toutes les équipes
    @GetMapping
    public ResponseEntity<List<Billet>> getAllBillets() {
        List<Billet> billets = billetRepository.findAll();
        return new ResponseEntity<>(billets, HttpStatus.OK);
    }

    // Endpoint pour récupérer une équipe par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Billet> getBilletsById(@PathVariable("id") Long id) {
        return billetRepository.findById(id)
                .map(billet -> new ResponseEntity<>(billet, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour ajouter un nouveau billet
    @PostMapping
    public ResponseEntity<Billet> addBillet(@RequestBody Billet billet) {
        try {
            Billet savedBillet = billetRepository.save(billet);
            return new ResponseEntity<>(savedBillet, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // mettre à jour un billet par son ID
    @PutMapping("/{id}")
    public ResponseEntity<Billet> updateBillet(@PathVariable("id") Long id, @RequestBody Billet billetDetails) {
        return billetRepository.findById(id)
                .map(billet -> {
                    billet.setId(billetDetails.getId());
                    billet.setType(billetDetails.getType());
                    billet.setCategorie(billetDetails.getCategorie());
                    billet.setPrix(billetDetails.getPrix());

                    Billet updatedBillet = billetRepository.save(billet);
                    return new ResponseEntity<>(updatedBillet, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // supprimer un nouveau billet
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillet(@PathVariable("id") Long id) {
        if (billetRepository.existsById(id)) {
            billetRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
