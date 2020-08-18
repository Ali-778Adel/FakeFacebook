package com.example.fakefacebook.UI.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fakefacebook.Data.PostsClient;
import com.example.fakefacebook.Pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsViewModel extends ViewModel {
    MutableLiveData<List<PostsModel>>mutableLiveData=new MutableLiveData<>();
    MutableLiveData<String> posts = new MutableLiveData<>();


    public void getposts(){
        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {
                posts.setValue("errr");
            }
        });

    }

}
