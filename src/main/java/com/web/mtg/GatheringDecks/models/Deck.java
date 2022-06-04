package com.web.mtg.GatheringDecks.models;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "tb_mtgdeck")
public class Deck{
    public Deck(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "description")
    @Type(type = "text")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @OneToMany(mappedBy = "deck", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private Set<Card> cards;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public Set<Card> getCards() {
        return cards;
    }


    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

  
}
