package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    private String name;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String city;

    private String stadium;

    @OneToMany(mappedBy = "club")
    private List<Player> players = new ArrayList<>();


    @OneToMany(mappedBy = "club")
    private List<Contract> contracts = new ArrayList<>();

    public Club() {
    }

    public Club(Long id, String name, LocalDate dateOfBirth, String city, String stadium, List<Player> players, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.stadium = stadium;
        this.players = players;
        this.contracts = contracts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayers(Player player){this.players.add(player);}

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public void addContracts(Contract contract){this.contracts.add(contract);}
}
