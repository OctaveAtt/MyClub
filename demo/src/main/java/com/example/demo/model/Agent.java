package com.example.demo.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Agent {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    private String name;

    private Integer salary;

    private String agency;

    @OneToMany(mappedBy = "agent")
    private List<Player> clients= new ArrayList<>();



    public Agent() {
    }


    public Agent(Long id, String name, Integer salary, String agency, List<Player> clients) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.agency = agency;
        this.clients = clients;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public List<Player> getClients() {
        return clients;
    }

    public void setClients(List<Player> clients) {
        this.clients = clients;
    }

    public void addClients(Player player){
        this.clients.add(player);
    }
}
