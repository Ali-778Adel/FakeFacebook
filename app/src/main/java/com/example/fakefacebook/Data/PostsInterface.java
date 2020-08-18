package com.example.fakefacebook.Data;

import com.example.fakefacebook.Pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsInterface {
    @GET("posts")
    public Call<List<PostsModel>>getposts();

}
