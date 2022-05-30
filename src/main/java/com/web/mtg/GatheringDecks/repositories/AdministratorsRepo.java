package com.web.mtg.GatheringDecks.repositories;

import com.web.mtg.GatheringDecks.models.Administrator;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdministratorsRepo extends CrudRepository<Administrator,Integer>{
    
    @Query(value = "select CASE WHEN COUNT(1)> 0 THEN 'true' ELSE 'false' END from tbadmusu where id=:id", nativeQuery = true)
    public boolean exist(int id);

    @Query(value = "select * from tbadmusu where email=:email and senha=:senha", nativeQuery = true)
    public Administrator login(String email,String senha);
}
