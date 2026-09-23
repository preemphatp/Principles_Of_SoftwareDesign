package com.example.lab7_673380594_9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lab7_673380594_9.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    
}
