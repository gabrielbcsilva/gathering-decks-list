package com.web.mtg.GatheringDecks.models;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "tb_mtgcard")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "edition", length = 100, nullable = false)
    private String edition;

    @Column(name = "language", length = 100, nullable = false)
    private String language;

    @Column(name = "foil", length = 2, nullable = false)
    private String foil;

    @Column(name = "price", length = 100, nullable = false)
    private String price;

    @Column(name = "amounts", length = 100, nullable = false)
    private String amounts;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="deck_id")
     private Deck deck;

       public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

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

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFoil() {
        return foil;
    }

    public void setFoil(String foil) {
        this.foil = foil;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmounts() {
        return amounts;
    }

    public void setAmounts(String amounts) {
        this.amounts = amounts;
    }



}
