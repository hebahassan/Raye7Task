package com.example.heba.raye7task.network.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.heba.raye7task.model.Article;
import com.example.heba.raye7task.model.News;
import com.example.heba.raye7task.network.ApiClient;
import com.example.heba.raye7task.network.ApiService;
import com.example.heba.raye7task.util.Const;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by heba on 30-Sep-18.
 */

public class NewsApi {
    private ApiService apiService;

    public NewsApi(){
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    public MutableLiveData<List<Article>> getNewsLiveData(){
        final MutableLiveData<List<Article>> articlesData = new MutableLiveData<>();

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("apiKey", Const.API_KEY);
        queryMap.put("sources", Const.SOURCE);
        queryMap.put("language", Const.LANGUAGE);
        //Todo: add page param

        apiService.getEveryThing(queryMap).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                Log.d("getNewsList", call.request().toString());

                if(response.isSuccessful()){
                    if(response.body().getStatus().equals(Const.SUCCESS)){
                        Log.d("getNewsList", "total results = " + response.body().getTotalResults());
                    }
                    articlesData.setValue(response.body().getArticles());
                }
                else {
                    articlesData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                articlesData.setValue(null);
            }
        });
        return articlesData;
    }
}
