package com.laliga.laliga2024_2025.player;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 1. Instead of creating 'new' instances of this class everytime, spring will manage its lifecycle
public class PlayerService {
    private final PlayerRepository playerRepository; // 2. Serive class depends on playerRepository to perform data operations

    @Autowired // 3. Inject (or 'give me') the object of PlayerRepository when creating PlayerService
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    /*
    While this works, it's inefficient because it pulls all players from the database and filters them in java which is slow in memory:
        1. return playerRepository.findAll().stream()
        2.     .filter(player -> teamName.equals(player.getTeam())) 
        3.     .collect(Collectors.toList()); 
        
    The main objective is as follows:
        1. Pull every player from the database, then filter them in java using stream() - Inefficient
        2. Loop through each player and check if they belong to specific team 
        3. collect the filter result and convert them to List type
    */

    public Optional<Player> findByName(String name) {
        return playerRepository.findByName(name);
    }
    public List<Player> findByTeam(String teamName){
                return playerRepository.findByTeam(teamName); // - More efficient, now PlayerRepository handles the filer at SQL level rather than java conversion
    }

    public List<Player> findByNation(String nationName){
        return playerRepository.findByNation(nationName);
    }

    public List<Player> findByPosition(String position){
        return playerRepository.findByPosition(position);
    }

    public List<Player> findByAge(int age){
        return playerRepository.findByAge(age);
    }

    public List<Player> findByMatchCount(int matchCount){
        return playerRepository.findByMatchCount(matchCount);
    }

    public List<Player> findByGoal(int goal){
        return playerRepository.findByGoals(goal);
    }

    public List<Player> findByAssist(int assist){
        return playerRepository.findByAssists(assist);
    }

    public List<Player> findByYellowCard(int yellowCard){
        return playerRepository.findByYellowCards(yellowCard);
    }

    public List<Player> findByRedCard(int redCard){
        return playerRepository.findByRedCards(redCard);
    }
}
