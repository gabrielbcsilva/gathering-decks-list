// package com.web.mtg.GatheringDecks.models;

// import javax.persistence.*;

// @Entity
// @Table(name = "tb_mtgdeck")
// public class Deck {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id")
//     private int id;
    
//     @Id
//     @Column(name = "cardid", nullable = false)
//     private int cardid;

//     @Id
//     @Column(name = "userid", nullable = false)
//     private int userid;

   
//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public int getCardid() {
//         return cardid;
//     }

//     public void setCardid(int cardid) {
//         this.cardid = cardid;
//     }

//     public int getUserid() {
//         return userid;
//     }

//     public void setUserid(int userid) {
//         this.userid = userid;
//     }

//     // public Card getCard() {
//     //     return card;
//     // }

//     // public void setCard(Card card) {
//     //     this.card = card;
//     // }

//     // public User getUser() {
//     //     return user;
//     // }

//     // public void setUser(User user) {
//     //     this.user = user;
//     // }

//     // @OneToOne
//     // @MapsId
//     // @JoinColumn(name = "card_id")
//     // private Card card;
 
//     // @OneToOne
//     // @MapsId
//     // @JoinColumn(name = "user_id")
//     // private User user;
 
// }
