package com.example.demo.model;


import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contract_number", nullable = false)
    private Long contractNumber;

    @PastOrPresent
    private LocalDate signatureDate;

    @Future
    private LocalDate expirationDate;

    @Min(value=0,message = "Le salaire du joueur ne peut pas être négatif")
    private Integer value;

    @Min(value = 0, message = "Le numéro du joueur ne peut pas être négatif")
    @Max(value = 99,message = "Le numéro du joueur ne peut pas être supérieur à 99")
    private Integer playersNumber;

    @OneToOne
    private Player player;

    @ManyToOne
    private Club club;

    public Contract() {
    }

    public Contract(Long contractNumber, LocalDate signatureDate, LocalDate expirationDate, Integer value, Integer playersNumber, Player player, Club club) {
        this.contractNumber = contractNumber;
        this.signatureDate = signatureDate;
        this.expirationDate = expirationDate;
        this.value = value;
        this.playersNumber = playersNumber;
        this.player = player;
        this.club = club;
    }

    public Long getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Long contractNumber) {
        this.contractNumber = contractNumber;
    }

    public LocalDate getSignatureDate() {
        return signatureDate;
    }

    public void setSignatureDate(LocalDate signatureDate) {
        this.signatureDate = signatureDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getPlayersNumber() {
        return playersNumber;
    }

    public void setPlayersNumber(Integer playersNumber) {
        this.playersNumber = playersNumber;
    }
}
