package com.example.api.controllers;

import com.example.api.model.Match;
import com.example.api.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchController(MatchRepository matchRepository) {

        this.matchRepository = matchRepository;
    }

    // Endpoint to get all matches
    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        List<Match> matches = matchRepository.findAll();
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    // Endpoint to get a match by ID
    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable("id") Long id) {
        return matchRepository.findById(id)
                .map(match -> new ResponseEntity<>(match, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
