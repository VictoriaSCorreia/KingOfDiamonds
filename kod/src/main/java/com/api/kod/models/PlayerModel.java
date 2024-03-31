package com.api.kod.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "player")
public class PlayerModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "playername", length = 50, nullable = false, unique = true)
    private String playerName;

    @Column(name = "move", length = 3, nullable = false)
    private Integer move;

    @Column(name = "score", length = 2)
    private Integer score;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getplayerName() {
        return this.playerName;
    }

    public void setplayerName(String playerName) {
        this.playerName = playerName;
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
