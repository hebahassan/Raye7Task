package com.example.heba.raye7task.viewmodel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.heba.raye7task.model.News;
import com.example.heba.raye7task.network.data.NewsApi;

/**
 * Created by heba on 30-Sep-18.
 */

public class NewsViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> busy;
    private MutableLiveData<Integer> textVisibility = new MutableLiveData<>();
    private MutableLiveData<String> textMsg = new MutableLiveData<>();

    private LiveData<News> newsData;

    public NewsViewModel(@NonNull Application application) {
        super(application);

        newsData = new NewsApi().getNewsLiveData();

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
            if(newsData.getValue() == null || newsData.getValue().getArticles().size() == 0)
                textVisibility.setValue(0);
            else
                textVisibility.setValue(8);
        }
        else //progressbar is visible
            textVisibility.setValue(8); //text is invisible

        return textVisibility;
    }

    public MutableLiveData<String> getTextMsg(){
        if(newsData.getValue() == null)
            textMsg.setValue("Connection Error");
        else if(newsData.getValue().getArticles().size() == 0)
            textMsg.setValue("No Articles Found");

        return textMsg;
    }

    public LiveData<News> getNewsData() {
        return newsData;
    }
}
