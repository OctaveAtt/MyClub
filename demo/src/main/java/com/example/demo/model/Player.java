package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;


@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    private String firstname;


    private String lastname;

    @Positive
    private Integer age;

    @Positive
    private Integer goals;

    @Positive
    private Integer assists;

    @Min(value=0)
    private Integer matchs;


    private boolean isInjured;


    @ManyToOne(fetch = FetchType.LAZY)
    Club club;

    @OneToOne(mappedBy = "player")
    Contract contract;

    @ManyToOne
    Agent agent;

    public Player(){
    }


    public Player(Long id, String firstname, String lastname, Integer age, Integer goals, Integer assists, Integer matchs, boolean isInjured,Agent agent, Contract contract,Club club) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.goals = goals;
        this.assists = assists;
        this.matchs = matchs;
        this.isInjured = isInjured;
        this.club = club;
        this.agent = agent;
        this.contract = contract;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getMatchs() {
        return matchs;
    }

    public void setMatchs(Integer matchs) {
        this.matchs = matchs;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
