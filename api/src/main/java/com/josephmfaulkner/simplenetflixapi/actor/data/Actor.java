package com.josephmfaulkner.simplenetflixapi.actor.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.josephmfaulkner.simplenetflixapi.show.data.Show;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "person")
public class Actor {
    @Id
    @JsonIgnore
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "featuredActors"
    )
    @JsonIgnore
    private Set<Show> shows = new HashSet<>();

    public Actor()
    {

    }

    public Actor(String name) {
        this.name = name;
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


    public Set<Show> getShows() {
        return shows;
    }

    public void setShows(Set<Show> shows) {
        this.shows = shows;
    }

}
