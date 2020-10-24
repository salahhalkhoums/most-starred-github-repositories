package com.example.moststarredgithubrepositories;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GithubServiceInterface {
    // starting date: 2020-09-24 so that we get the repositories of only the last 30days for today :D
    @GET("search/repositories?q=created:>2020-09-24&sort=stars&order=desc")
    Call<GithubItems> getItems(@Query("page") int page, @Query("per_page") int per_page);
}
