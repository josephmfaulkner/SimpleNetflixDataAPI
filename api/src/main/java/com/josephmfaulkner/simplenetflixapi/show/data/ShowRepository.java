package com.josephmfaulkner.simplenetflixapi.show.data;

import com.josephmfaulkner.simplenetflixapi.actor.data.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, String> {

    List<Show> findByTitle(String title);

    @Query(
            value = "SELECT t.id,t.title,t.type,t.description,t.release_year,t.runtime FROM title t, person p, title_person tp WHERE tp.title_id = t.id and tp.person_id = p.id and p.name = ?1",
            nativeQuery = true
    )
    List<Show> findByActorName(String actorName);

}
