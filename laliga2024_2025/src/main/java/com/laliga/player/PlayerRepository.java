package com.laliga.player;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; // JpaRepository provides JPA  with related methods e.g CRUD operations
import org.springframework.stereotype.Repository;            // Which allowes me to talk with mySQL database    

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> { // Creates a database access layer for the Player table/entity.
    Optional<Player> findByName(String name); // The optional type is used to represent a value that may or may not be present in the database

    List<Player> findPlayersByTeam(String teamName);
    List<Player> findPlayersByName(String searchTxt);
    List<Player> findPlayersByNation(String nationName);
    List<Player> findPlayersByPosition(String position);
    List<Player> findPlayerByAge(int age);
    List<Player> findPlayerByMatch(int match);
    List<Player> findPlayerByGoal(int goal);
    List<Player> findPlayerByAssist(int assist);
    List<Player> findPlayerByYellowCard(int yellowCard);
    List<Player> findPlayerByRedCard(int redCard);
}


/*
Your code
 ||
 \/
JpaRepository
 ||
 \/
Hibernate (converts Java to SQL)
 ||
 \/
MySQL

* I don't need to write any SQL queries myself because JpaRepo provides methods like findAll(), save(), deleteById(), etc.
*/