package com.web.mtg.GatheringDecks.repositories;

import com.web.mtg.GatheringDecks.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<User,Integer>{
    
    @Query(value = "select CASE WHEN COUNT(1)> 0 THEN 'true' ELSE 'false' END from tb_mtgusu where id=:id", nativeQuery = true)
    public boolean exist(int id);

    @Query(value = "select * from tb_mtgusu where email=:email and password=:password", nativeQuery = true)
    public User login(String email,String password);
}
