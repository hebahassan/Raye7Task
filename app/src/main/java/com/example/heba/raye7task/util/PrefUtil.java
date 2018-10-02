package com.example.heba.raye7task.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.heba.raye7task.model.Article;
import com.example.heba.raye7task.model.News;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.validation.Validator;

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

    public void saveFavoritesList(List<Article> articlesList){
        String favString = gson.toJson(articlesList);
        editor.putString(Const.FAV, favString).apply();
    }

    public List<Article> getFavoritesList(){
        List<Article> favArticleList;
        if(sharedPreferences.contains(Const.FAV)){
            String favString = sharedPreferences.getString(Const.FAV, "");
            Article[] favoriteItems = gson.fromJson(favString,
                    Article[].class);
            favArticleList = Arrays.asList(favoriteItems);
            favArticleList = new ArrayList<Article>(favArticleList);
        }
        else {
            favArticleList = new ArrayList<>();
        }

        return favArticleList;
    }

    public Article getFavArticle(int articleId){
        Article article = new Article();
        if(sharedPreferences.contains(Const.FAV + articleId)){
            String favString = sharedPreferences.getString(Const.FAV + articleId, "");
            article = gson.fromJson(favString, Article.class);
        }
        return article;
    }

    public void getAllFavData(){
        Log.d("map_values", "IN..");
        Map<String, ?> allEntries = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()){
            Log.d("map_values", entry.getKey() + ": " + entry.getValue().toString());
        }
    }

    public void removeFavArticle(int articleId){
        if(sharedPreferences.contains(Const.FAV + articleId)){
            editor.remove(Const.FAV + articleId).apply();
        }
    }
}
