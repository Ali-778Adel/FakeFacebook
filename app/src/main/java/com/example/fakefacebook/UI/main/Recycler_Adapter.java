package com.example.fakefacebook.UI.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakefacebook.Pojo.PostsModel;
import com.example.fakefacebook.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.Post_View_Holder> {
private ArrayList<PostsModel>postsModelArrayList=new ArrayList<>();

    @NonNull
    @Override
    public Post_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return new Post_View_Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_model, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Post_View_Holder holder, int position) {
holder.userId.setText(postsModelArrayList.get(position).getUserId());
holder.tile.setText(postsModelArrayList.get(position).getTitle());
holder.body.setText(postsModelArrayList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postsModelArrayList.size();
    }

    public void setList(List<PostsModel> postsModels) {
        notifyDataSetChanged();
    }

    public class Post_View_Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.tile)
        TextView tile;
        @BindView(R.id.user_id)
        TextView userId;
        @BindView(R.id.body)
        TextView body;
        @BindView(R.id.card_view)
        CardView cardView;

        public Post_View_Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind (this, itemView);

        }
    }
}
