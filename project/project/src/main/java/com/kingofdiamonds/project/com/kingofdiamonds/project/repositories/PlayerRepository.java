package com.kingofdiamonds.project.com.kingofdiamonds.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kingofdiamonds.project.com.kingofdiamonds.project.models.PlayerModel;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {
    boolean existsByPlayername(String playername);
    
}
