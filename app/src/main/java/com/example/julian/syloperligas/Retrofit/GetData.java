package com.example.julian.syloperligas.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {
    @GET("/users")
    Call<List<RetroUsers>> getAllUsers();
}