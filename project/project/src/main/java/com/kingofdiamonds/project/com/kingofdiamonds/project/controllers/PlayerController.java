package com.kingofdiamonds.project.com.kingofdiamonds.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingofdiamonds.project.com.kingofdiamonds.project.dtos.PlayerDto;
import com.kingofdiamonds.project.com.kingofdiamonds.project.models.PlayerModel;
import com.kingofdiamonds.project.com.kingofdiamonds.project.services.PlayerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/player")
public class PlayerController {

    final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Object> savePlayer(@RequestBody @Valid PlayerDto playerDto){
        if(playerService.existsByPlayername(playerDto.getPlayername())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Playername is already in use!");
        }
        var playerModel = new PlayerModel();
        BeanUtils.copyProperties(playerDto, playerModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.save(playerModel));
    }

    @GetMapping
    public ResponseEntity<List<PlayerModel>> getAllPlayers(){
        return ResponseEntity.status(HttpStatus.OK).body(playerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePlayer(@PathVariable(value = "id") Long id){
        Optional<PlayerModel> playerModelOptional = playerService.findById(id);
        if (!playerModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(playerModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePlayer(@PathVariable(value = "id") Long id){
        Optional<PlayerModel> playerModelOptional = playerService.findById(id);
        if (!playerModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found.");
        }
        playerService.delete(playerModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Player deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePlayer(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid PlayerDto playerDto){
        Optional<PlayerModel> playerModelOptional = playerService.findById(id);
        if (!playerModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found.");
        }
        var playerModel = new PlayerModel();
        BeanUtils.copyProperties(playerDto, playerModel);
        playerModel.setId(playerModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(playerService.save(playerModel));
    }
}
