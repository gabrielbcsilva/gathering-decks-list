package com.web.mtg.GatheringDecks.repositories;

import com.web.mtg.GatheringDecks.models.Deck;

import org.springframework.data.repository.CrudRepository;

public interface DeckRepo extends CrudRepository<Deck,Integer>{
    
    
}
