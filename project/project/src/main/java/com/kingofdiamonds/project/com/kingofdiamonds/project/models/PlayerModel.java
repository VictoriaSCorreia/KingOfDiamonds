package com.kingofdiamonds.project.com.kingofdiamonds.project.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "player")
public class PlayerModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "playername", length = 50, nullable = false, unique = true)
    private String playername;

    @Column(name = "move", length = 3, nullable = false)
    private Integer move;

    @Column(name = "score", length = 2)
    private Integer score;

    /* public PlayerModel() {
    }

    public PlayerModel(UUID id, String playername, Integer move, Integer score) {
        this.id = id;
        this.playername = playername;
        this.move = move;
        this.score = score;
    } */


    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPlayername() {
        return this.playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public Integer getMove() {
        return this.move;
    }

    public void setMove(Integer move) {
        this.move = move;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}