package com.example.PetStore.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PhotoUrls {
    public PhotoUrls() {
    }

    public PhotoUrls(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PhotoUrls(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;
    @JsonValue
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
