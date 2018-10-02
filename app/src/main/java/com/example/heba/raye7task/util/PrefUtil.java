package com.example.heba.raye7task.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.heba.raye7task.model.Article;
import com.example.heba.raye7task.model.News;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefUtil {
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson;

    public PrefUtil(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(Const.PREF, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
    }

    public void saveFavArticle(Article favArticle, int articleId){
        String newsString = gson.toJson(favArticle);
        editor.putString(Const.FAV + articleId, newsString).apply();
    }

    public List<Article> getFavArticles(){
        List<Article> favoriteArtList;
        String newsString = sharedPreferences.getString(Const.FAV, "");
        Article[] favoriteItems = gson.fromJson(newsString,
                Article[].class);
        favoriteArtList = Arrays.asList(favoriteItems);
        favoriteArtList = new ArrayList<>(favoriteArtList);

        return favoriteArtList;
    }
}
