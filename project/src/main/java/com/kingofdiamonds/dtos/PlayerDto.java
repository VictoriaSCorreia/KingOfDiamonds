package com.kingofdiamonds.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PlayerDto {

    @NotBlank
    @Size(min = 2, max = 50)
    private String playername;

    @Min(value = 0)
    @Max(value = 100)
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
