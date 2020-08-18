package com.example.fakefacebook.Data;

import com.example.fakefacebook.Pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
   private final static String Base_URL="https://jsonplaceholder.typicode.com/";
   private PostsInterface postsInterface;
    private static PostsClient INSTANCE;



    public PostsClient(){
    Retrofit retrofit=new Retrofit.Builder().
            baseUrl(Base_URL).addConverterFactory(GsonConverterFactory.
            create()).build();

    postsInterface=retrofit.create(PostsInterface.class);
}
    public static PostsClient getINSTANCE() {
        INSTANCE = new PostsClient();
        return INSTANCE;
    }

    public Call<List<PostsModel>> getPosts(){
        return postsInterface.getposts();
    }
}
