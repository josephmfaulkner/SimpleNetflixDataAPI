package com.josephmfaulkner.simplenetflixapi.show.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, String> {

    List<Show> findByTitle(String title);


}
