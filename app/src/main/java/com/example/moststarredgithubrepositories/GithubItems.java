package com.example.moststarredgithubrepositories;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GithubItems {
    @SerializedName("items")
    private List<GithubRepo> items;

    public List<GithubRepo> getItems() {
        return items;
    }
}
