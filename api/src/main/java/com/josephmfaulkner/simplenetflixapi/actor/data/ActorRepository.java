package com.josephmfaulkner.simplenetflixapi.actor.data;

import com.josephmfaulkner.simplenetflixapi.show.data.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository  extends JpaRepository<Actor, Integer> {

    List<Show> findByName(String name);


}