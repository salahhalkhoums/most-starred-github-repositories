package com.example.moststarredgithubrepositories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    NestedScrollView nestedScrollView;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    List<GithubRepo> dataList=new ArrayList<>();
    MainAdapter adapter;
    boolean loaded=false;
    int page=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nestedScrollView=(NestedScrollView)findViewById(R.id.scroll_view);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar);

        adapter=new MainAdapter(MainActivity.this,dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        getData(page);

        //pagination feature
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(loaded &&scrollY==v.getChildAt(0).getMeasuredHeight()-v.getMeasuredHeight()){
                    //if this condition is met, we have reached the bottom of the scrollview, so we need to show the progress bar and load the data of the next page
                    loaded=false;
                    page++;
                    progressBar.setVisibility(View.VISIBLE);
                    getData(page);
                }
            }
        });
    }

    private void getData(int page) {
        Retrofit retrofit= new Retrofit
                .Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GithubServiceInterface githubServiceInterface=retrofit.create(GithubServiceInterface.class);
        Call<GithubItems> callItems=githubServiceInterface.getItems(page,20); // we will get 20 repositories every time we scroll to the bottom of the scrollView
        callItems.enqueue(new Callback<GithubItems>() {
            @Override
            public void onResponse(Call<GithubItems> call, Response<GithubItems> response) {
                //condition that we got the data successfully
                if (response.isSuccessful() && response.body()!=null){

                    progressBar.setVisibility(View.INVISIBLE);
                    dataList.addAll(response.body().getItems());

                    adapter=new MainAdapter(MainActivity.this,dataList);
                    recyclerView.setAdapter(adapter);
                    loaded=true;
                }
            }

            @Override
            public void onFailure(Call<GithubItems> call, Throwable t) {

            }
        });

    }
}
