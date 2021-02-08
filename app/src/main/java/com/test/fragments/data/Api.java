package com.test.fragments.data;

import retrofit2.Call;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("users/{user}/repos")
    List<Repo> getRepo(@Path("user") String user);
}
