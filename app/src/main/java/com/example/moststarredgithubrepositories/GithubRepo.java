package com.example.moststarredgithubrepositories;

import com.google.gson.annotations.SerializedName;

public class GithubRepo {
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("owner")
    private GithubOwner owner;
    @SerializedName("stargazers_count")
    private String starsCount;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStarsCount() {
        return starsCount;
    }
    public GithubOwner getOwner() {
        return owner;
    }
}