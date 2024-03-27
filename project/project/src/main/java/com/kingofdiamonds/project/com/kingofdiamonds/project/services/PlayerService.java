package com.kingofdiamonds.project.com.kingofdiamonds.project.services;

import com.kingofdiamonds.project.com.kingofdiamonds.project.models.PlayerModel;
import com.kingofdiamonds.project.com.kingofdiamonds.project.repositories.PlayerRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    
    @Transactional
    public PlayerModel save(PlayerModel playerModel) {
        return playerRepository.save(playerModel);
    }

    
    public boolean existsByPlayername(String playername) {
        return playerRepository.existsByPlayername(playername);
    }

    public List<PlayerModel> findAll() {
        return playerRepository.findAll();
    }

    public Optional<PlayerModel> findById(UUID id) {
        return playerRepository.findById(id);
    }

    @Transactional
    public void delete(PlayerModel playerModel) {
        playerRepository.delete(playerModel);
    }

}