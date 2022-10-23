package com.josephmfaulkner.simplenetflixapi.show.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// INSERT INTO TITLE (id,title,type,description,release_year,runtime)
@Entity
@Table(name = "title")
public class Show {
    @Id
    @JsonIgnore
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "title")
    private String title;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @Column(name = "release_year")
    private int release_year;
    @Column(name = "runtime")
    private int runtime;

    public Show()
    {

    }

    public Show(String title, String type, String description, int release_year, int runtime) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.release_year = release_year;
        this.runtime = runtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
}
