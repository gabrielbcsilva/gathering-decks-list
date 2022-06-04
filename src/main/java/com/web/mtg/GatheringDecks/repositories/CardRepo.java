package com.web.mtg.GatheringDecks.repositories;

import com.web.mtg.GatheringDecks.models.Card;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CardRepo extends CrudRepository<Card,Integer>{

    @Query(value = "select * from tb_mtgcard where deck_id=:id", nativeQuery = true)
    public List<Card> findByDeck(int id);

    @Query(value = "select deck_id from tb_mtgcard where id=:id", nativeQuery = true)
    public int findDeckId(int id);
   
}
