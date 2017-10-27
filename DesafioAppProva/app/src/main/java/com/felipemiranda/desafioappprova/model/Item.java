package com.felipemiranda.desafioappprova.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by felipemiranda on 26/10/17.
 */

public class Item implements Serializable {

    private String name;
    @SerializedName("full_name")
    private String full_name;
    private Owner owner;
    private String description;
    @SerializedName("stargazers_count")
    private Integer stargazers_count;
    @SerializedName("forks_count")
    private Integer forks_count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(Integer stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public Integer getForks_count() {
        return forks_count;
    }

    public void setForks_count(Integer forks_count) {
        this.forks_count = forks_count;
    }
}