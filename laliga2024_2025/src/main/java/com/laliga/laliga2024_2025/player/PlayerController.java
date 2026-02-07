package com.laliga.laliga2024_2025.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController // Does 3 things at once: 1. this class handles HTTP request, 2. mehtods reutnr data not HTML pages, 3. return object are auto converted to JSON
@RequestMapping(path ="/players") // Base URL path for all endpoints in this controller, e.g., /players, /players/{id}
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping //hanldes all GET requets to players/path such as ex: /players/path?[param]=[value we want to search] 
    public List<Player> getPlayers(
        // if required = false, it means the query parameter is optional
        @RequestParam(required = false) String team, // All Optional query parameter for filtering by any of these
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String nation,
        @RequestParam(required = false) String position,
        @RequestParam(required = false) Integer age,
        @RequestParam(required = false) Integer matchCount,
        @RequestParam(required = false) Integer goal,
        @RequestParam(required = false) Integer assist,
        @RequestParam(required = false) Integer yellowCard,
        @RequestParam(required = false) Integer redCard
    )
    {
        if (name != null && !name.isEmpty()) {
            return playerService
                .findByName(name)
                .map(List::of)      // Optional<Player> → List<Player>
                .orElse(List.of()); // empty list if not found
        }
        if (team != null && !team.isEmpty()) {
            return playerService.findByTeam(team);
        }
        if (nation != null && !nation.isEmpty()) {
            return playerService.findByNation(nation);
        }
        if (position != null && !position.isEmpty()) {
            return playerService.findByPosition(position);
        }
        if (age != null) {
            return playerService.findByAge(age);
        }
        if (matchCount != null) {
            return playerService.findByMatchCount(matchCount);
        }
        if (goal != null) {
            return playerService.findByGoal(goal);
        }
        if (assist != null) {
            return playerService.findByAssist(assist);
        }
        if (yellowCard != null) {
            return playerService.findByYellowCard(yellowCard);
        }
        if (redCard != null) {
            return playerService.findByRedCard(redCard);
        }
        return playerService.getPlayers(); // If no query parameter is provided, return all players
    }

    // Maybe for later project but: @PostMapping("path") to add new player to our database
    // PutMapping handles HTTP request to update, DeleteMapping, handles delete player
}
