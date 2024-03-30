package com.kingofdiamonds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kingofdiamonds.models.PlayerModel;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {
    boolean existsByPlayername(String playername);
    
}
