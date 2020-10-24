package com.example.moststarredgithubrepositories;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    //initializing list and activity variables
    private List<GithubRepo> dataList;
    private Activity activity;
    //initializing constructor
    public MainAdapter(Activity activity,List<GithubRepo> dataList){
        this.activity=activity;
        this.dataList=dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GithubRepo data=dataList.get(position);
        holder.repoName.setText(data.getName());
        holder.repoDescription.setText(data.getDescription());
        holder.ownerLogin.setText(data.getOwner().getLogin());
        Picasso.get().load(data.getOwner().getAvatar_url()).into(holder.ownerAvatar);
        holder.repoStars.setText(data.getStarsCount());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initializing variables of the itemviewlist
        TextView repoName;
        TextView repoDescription;
        ImageView ownerAvatar;
        TextView ownerLogin;
        TextView repoStars;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            repoName=itemView.findViewById(R.id.repoName);
            repoDescription=itemView.findViewById(R.id.repoDescription);
            ownerAvatar=itemView.findViewById(R.id.ownerAvatar);
            ownerLogin=itemView.findViewById(R.id.ownerLogin);
            repoStars=itemView.findViewById(R.id.repoStars);

        }
    }
}
