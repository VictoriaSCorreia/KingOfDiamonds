package com.kingofdiamonds.project.com.kingofdiamonds.project.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kingofdiamonds.project.com.kingofdiamonds.project.models.PlayerModel;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, UUID> {
    boolean existsByPlayername(String playername);

}