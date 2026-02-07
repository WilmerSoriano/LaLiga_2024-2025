package com.laliga.laliga2024_2025.player; // The package declaration indicates that this class is part of the com.laliga.player folder

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//!!!!!!!!!!!!!!!!!
//NOTE ON NAMING CONVENTION: in java using @Column to map database column name to java variable names
//!!!!!!!!!!!!!!!!!

@Entity // To mark this class as a JPA entity, meaning it will be mapped to a database table (SEE PlayerRepository.java for more info)
@Table(name = "players") // Specifies the name of the database table to which this entity is mapped (yes my database table is called players)
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Player")
    private String name;

    @Column(name = "Nation")
    private String nation;

    @Column(name = "Position")
    private String position;

    @Column(name = "Team")
    private String team;

    @Column(name = "Age")
    private int age;

    @Column(name = "`Match`") // THIS IS THE CULPRIT, since match is a reserved keyword in SQL, we need to use another name convention
    private int matchCount; // using matchCount instead of Matches or match

    @Column(name = "Minutes")
    private int minutes;

    @Column(name = "Goals")
    private int goals;

    @Column(name = "Assists")
    private int assists;

    @Column(name = "Yellow_Cards")
    private int yellowCards;

    @Column(name = "Red_Cards")
    private int redCards;

    protected Player() {
    }
    
    public Player(int id, String name, String nation, String position, String team, int age, int matchCount, int minutes, int goals, int assists, int yellowCards, int redCards) {
        this.id = id;
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.team = team;
        this.age = age;
        this.matchCount = matchCount;
        this.minutes = minutes;
        this.goals = goals;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
    }

    public String getPlayerName() {
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
    public int getMatchCount() {
        return matchCount;
    }
    public int getMin() {
        return minutes;
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
