package com.laliga.player;

import java.util.List;

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
    public List<Player> findPlayersByTeam(String teamName){
                return playerRepository.findPlayersByTeam(teamName); // - More efficient, now PlayerRepository handles the filer at SQL level rather than java conversion
    }

    public List<Player> findPlayersByName(String searchTxt){
        return playerRepository.findPlayersByName(searchTxt);
    }

    public List<Player> findPlayersbyNation(String nationName){
        return PlayerRepository.findPlayersByNation(nationName);
    }

}
