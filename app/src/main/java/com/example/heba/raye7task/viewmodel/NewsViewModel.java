package com.example.heba.raye7task.viewmodel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.heba.raye7task.model.Article;
import com.example.heba.raye7task.network.data.NewsApi;
import com.example.heba.raye7task.util.PrefUtil;

import java.util.List;

/**
 * Created by heba on 30-Sep-18.
 */

public class NewsViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> busy; //0 -> visible, 8 -> gone
    private MutableLiveData<Integer> textVisibility = new MutableLiveData<>();
    private MutableLiveData<String> textMsg = new MutableLiveData<>();

    //For toggle buttons
    private MutableLiveData<Integer> toggleSelection;

    private PrefUtil prefUtil;
    private NewsApi newsApi;

    private MutableLiveData<List<Article>> articlesData;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        prefUtil = new PrefUtil(getApplication());
        newsApi = new NewsApi();

        articlesData = new NewsApi().getNewsLiveData();
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

    public LiveData<List<Article>> getArticlesData() {
        return articlesData;
    }

    public void onAllClicked(){
        articlesData = newsApi.getNewsLiveData();

//        for(int i = 0; i < articlesData.getValue().size(); i++){
//            Log.d("all_click", articlesData.getValue().get(i).getTitle());
//        }
    }

    public void onFavClick(){
        articlesData.setValue(prefUtil.getFavoritesList());
        for(int i = 0; i < articlesData.getValue().size(); i++){
            Log.d("fav_click", articlesData.getValue().get(i).getTitle());
        }
    }
}
