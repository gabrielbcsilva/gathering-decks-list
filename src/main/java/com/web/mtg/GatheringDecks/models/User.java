package com.web.mtg.GatheringDecks.models;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "tb_mtgusu")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    @Column(name = "obs")
    @Type(type = "text")
    private String obs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    // public Deck getDeck() {
    //     return deck;
    // }

    // public void setDeck(Deck deck) {
    //     this.deck = deck;
    // }

    // @OneToOne(mappedBy = "id", cascade = CascadeType.ALL)
    // @PrimaryKeyJoinColumn
    // private Deck deck;

}
