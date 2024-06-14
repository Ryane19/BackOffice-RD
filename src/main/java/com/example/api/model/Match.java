package com.example.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String location;

    @ManyToOne
    @JoinColumn(name = "teamA_id")
    private Equipe teamA;

    @ManyToOne
    @JoinColumn(name = "teamB_id")
    private Equipe teamB;

    private int scoreA;
    private int scoreB;

    // Constructors, getters, and setters
    public Match() {}

    public Match(Date date, String location, Equipe teamA, Equipe teamB, int scoreA, int scoreB) {
        this.date = date;
        this.location = location;
        this.teamA = teamA;
        this.teamB = teamB;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Equipe getTeamA() {
        return teamA;
    }

    public void setTeamA(Equipe teamA) {
        this.teamA = teamA;
    }

    public Equipe getTeamB() {
        return teamB;
    }

    public void setTeamB(Equipe teamB) {
        this.teamB = teamB;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }
}
