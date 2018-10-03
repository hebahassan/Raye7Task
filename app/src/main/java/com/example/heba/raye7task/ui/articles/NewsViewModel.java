package com.example.heba.raye7task.ui.articles;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;

import com.example.heba.raye7task.R;
import com.example.heba.raye7task.app.GlideApp;
import com.example.heba.raye7task.model.Article;
import com.example.heba.raye7task.model.News;
import com.example.heba.raye7task.network.ApiClient;
import com.example.heba.raye7task.network.ApiService;
import com.example.heba.raye7task.util.Const;
import com.example.heba.raye7task.util.PrefUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by heba on 30-Sep-18.
 */

public class NewsViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> busy; //0 -> visible, 8 -> gone
    private MutableLiveData<Integer> textVisibility = new MutableLiveData<>();
    private MutableLiveData<String> textMsg = new MutableLiveData<>();

    private MutableLiveData<Boolean> allToggleSelection; //true -> api, false -> fav

    private PrefUtil prefUtil;

    private MutableLiveData<List<Article>> articlesData;

    ApiService apiService;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        prefUtil = new PrefUtil(getApplication());
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    public void getNewsLiveData(){
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
                    getArticlesData().setValue(response.body().getArticles());
                }
                else {
                    getArticlesData().setValue(null);
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                getArticlesData().setValue(null);
            }
        });

    }

    public MutableLiveData<Integer> getBusy(){
        if(busy == null){
            busy = new MutableLiveData<>();
            busy.setValue(0);
        }
        else {
            busy.setValue(8);
        }

        return busy;
    }

    public MutableLiveData<Integer> getTextVisibility() {
        if(busy != null && busy.getValue() == 8){
            if(articlesData.getValue() == null || articlesData.getValue().size() == 0){
                textVisibility.setValue(0);
            }else {
                textVisibility.setValue(8);
            }
        }
        else
            textVisibility.setValue(8);

        return textVisibility;
    }

    public MutableLiveData<String> getTextMsg(){
//        if(newsData.getValue() == null)
        if(articlesData.getValue() == null)
            textMsg.setValue("Connection Error");
        else if(articlesData.getValue().size() == 0) //newsData.getValue().getArticles().size() == 0
            textMsg.setValue("No Articles Found");

        return textMsg;
    }

    public MutableLiveData<List<Article>> getArticlesData() {
        if (articlesData == null) {
            articlesData = new MutableLiveData<>();
        }

        return articlesData;
    }

    public MutableLiveData<Boolean> getAllToggleSelection() {
        if(allToggleSelection == null){
            allToggleSelection = new MutableLiveData<>();
            allToggleSelection.setValue(true);
        }
        return allToggleSelection;
    }

    public void onAllClicked(){
        getNewsLiveData();
        allToggleSelection.setValue(true);
    }

    public void onFavClick(){
        articlesData.setValue(prefUtil.getFavoritesList());
        allToggleSelection.setValue(false);
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url){
        Context context = imageView.getContext();
        GlideApp.with(context)
                .load(url)
                .placeholder(ContextCompat.getDrawable(context, R.drawable.article))
                .into(imageView);
    }
}
