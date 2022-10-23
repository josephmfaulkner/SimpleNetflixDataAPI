package com.josephmfaulkner.simplenetflixapi.actor.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// INSERT INTO PERSON (id,name) VALUES (3748,'Robert De Niro');

@Entity
@Table(name = "person")
public class Actor {
    @Id
    @JsonIgnore
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

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
}
