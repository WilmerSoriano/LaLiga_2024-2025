package com.laliga.player;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; // JpaRepository provides JPA  with related methods e.g CRUD operations
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findByName(String name); // The optional type is used to represent a value that may or may not be present in the database
}
