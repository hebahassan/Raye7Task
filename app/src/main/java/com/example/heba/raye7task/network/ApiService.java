package com.example.heba.raye7task.network;

import com.example.heba.raye7task.model.News;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by heba on 30-Sep-18.
 */

public interface ApiService {
    @GET("everything")
    Call<News> getEveryThing(@QueryMap Map<String, Object> queryMap);
}
