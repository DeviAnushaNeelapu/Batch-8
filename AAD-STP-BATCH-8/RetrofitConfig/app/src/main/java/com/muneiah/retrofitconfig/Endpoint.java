package com.muneiah.retrofitconfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoint {
    @GET("/photos")
    Call<List<Repo>> getAll();
}
