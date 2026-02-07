package com.laliga.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController // Does 3 things at once: 1. this class handles HTTP request, 2. mehtods reutnr data not HTML pages, 3. return object are auto converted to JSON
@RequestMapping(path = "/players") // Base URL path for all endpoints in this controller, e.g., /players, /players/{id}
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("path") //hanldes all GET requets to players/path such as ex: /players/path?[param]=[value we want to search] 
    public List<Player> getPlayers(
        // if required = false, it means the query parameter is optional
        @RequestParam(required = false) String team, // All Optional query parameter for filtering by any of these
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String nation,
        @RequestParam(required = false) String position,
        @RequestParam(required = false) Integer age,
        @RequestParam(required = false) Integer match,
        @RequestParam(required = false) Integer goal,
        @RequestParam(required = false) Integer assist,
        @RequestParam(required = false) Integer yellowCard,
        @RequestParam(required = false) Integer redCard
    )
    {
        if (team != null && !team.isEmpty()) {
            return playerService.findPlayersByTeam(team);
        }
        if (name != null && !name.isEmpty()) {
            return playerService.findPlayersByName(name);
        }
        if (nation != null && !nation.isEmpty()) {
            return playerService.findPlayersByNation(nation);
        }
        if (position != null && !position.isEmpty()) {
            return playerService.findPlayersByPosition(position);
        }
        if (age != null) {
            return playerService.findPlayerByAge(age);
        }
        if (match != null) {
            return playerService.findPlayerByMatch(match);
        }
        if (goal != null) {
            return playerService.findPlayerByGoal(goal);
        }
        if (assist != null) {
            return playerService.findPlayerByAssist(assist);
        }
        if (yellowCard != null) {
            return playerService.findPlayerByYellowCard(yellowCard);
        }
        if (redCard != null) {
            return playerService.findPlayerByRedCard(redCard);
        }
        return playerService.getPlayers(); // If no query parameter is provided, return all players
    }

    // Maybe for later project but: @PostMapping("path") to add new player to our database
    // PutMapping handles HTTP request to update, DeleteMapping, handles delete player
}
