package com.kingofdiamonds.project.com.kingofdiamonds.project.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PlayerDto {

    @NotBlank
    @Size(min = 2, max = 50)
    private String playername;

    @NotBlank
    @Size(min = 1, max = 3)
    private Integer move;


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

}
