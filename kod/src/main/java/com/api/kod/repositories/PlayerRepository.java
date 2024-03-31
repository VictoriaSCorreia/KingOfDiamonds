package com.api.kod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.kod.models.PlayerModel;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {
    boolean existsByPlayerName(String playerName);
}