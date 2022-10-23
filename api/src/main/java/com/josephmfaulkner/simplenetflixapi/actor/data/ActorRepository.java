package com.josephmfaulkner.simplenetflixapi.actor.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository  extends JpaRepository<Actor, Integer> {

    List<Actor> findByName(String name);

    @Query(
            value = "SELECT p.id, p.name FROM title t, person p, title_person tp WHERE tp.title_id = t.id and tp.person_id = p.id and t.title = ?1",
            nativeQuery = true
    )
    List<Actor> findByShowTitle(String showName);




}