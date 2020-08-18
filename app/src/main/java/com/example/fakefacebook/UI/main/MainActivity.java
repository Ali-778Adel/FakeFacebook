package com.example.fakefacebook.UI.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakefacebook.Pojo.PostsModel;
import com.example.fakefacebook.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    PostsViewModel postsViewModel;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        postsViewModel.getposts();
        final Recycler_Adapter recycler_adapter=new Recycler_Adapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recycler_adapter);
  postsViewModel.mutableLiveData.observe(this, new Observer<List<PostsModel>>() {
    @Override
    public void onChanged(List<PostsModel> postsModels) {
recycler_adapter.setList(postsModels)  ;
    }
});
    }
}
