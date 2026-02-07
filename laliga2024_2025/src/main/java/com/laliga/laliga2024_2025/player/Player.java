package com.laliga.laliga2024_2025.player; // The package declaration indicates that this class is part of the com.laliga.player folder

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // To mark this class as a JPA entity, meaning it will be mapped to a database table (SEE PlayerRepository.java for more info)
@Table(name = "players") // Specifies the name of the database table to which this entity is mapped (yes my database table is called players)
public class Player {

    @Id // Tells JPA(Java Persistence API) that this field is the primary key
    @Column(name = "id") 
    private int id;
    private String name;
    private String nation;
    private String position;
    private String team;
    private int age;
    private int matches;
    private int min;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;

    public Player(int id, String name, String nation, String position, String team, int age, int matches, int min, int goals, int assists, int yellowCards, int redCards) {
        this.id = id;
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.team = team;
        this.age = age;
        this.matches = matches;
        this.min = min;
        this.goals = goals;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
    }

    public String getName() {
        return name;
    }
    public String getNation() {
        return nation;
    }
    public String getPosition() {
        return position;
    }
    public String getTeam(){
        return team;
    }
    public int getAge() {
        return age;
    }
    public int getMatches() {
        return matches;
    }
    public int getMin() {
        return min;
    }
    public int getGoals() {
        return goals;
    }
    public int getAssists() {
        return assists;
    }
    public int getYellowCards() {
        return yellowCards;
    }
    public int getRedCards() {
        return redCards;
    }

}
