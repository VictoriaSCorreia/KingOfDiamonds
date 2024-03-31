package com.api.kod.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PlayerDto {
    @NotBlank
    @Size(min = 2, max = 50)
    private String playerName;

    @Min(value = 0)
    @Max(value = 100)
    private Integer move;

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getMove() {
        return this.move;
    }

    public void setMove(Integer move) {
        this.move = move;
    }

}
