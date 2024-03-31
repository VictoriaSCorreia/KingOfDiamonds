package com.api.kod.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.kod.models.PlayerModel;
import com.api.kod.repositories.PlayerRepository;

import jakarta.transaction.Transactional;

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

    public boolean existsByPlayerName(String playerName) {
        return playerRepository.existsByPlayerName(playerName);
    }

    public List<PlayerModel> findAll() {
        return playerRepository.findAll();
    }

    public Optional<PlayerModel> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Transactional
    public void delete(PlayerModel playerModel) {
        playerRepository.delete(playerModel);
    }
}
