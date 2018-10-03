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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.heba.raye7task.ui.articles.ArticlesActivity.currentPage;

/**
 * Created by heba on 30-Sep-18.
 */

public class NewsViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> busy; //0 -> visible, 8 -> gone

    private MutableLiveData<Boolean> allToggleSelection; //true -> api list, false -> favorites list
    private MutableLiveData<Boolean> favClickable = new MutableLiveData<>();

    private PrefUtil prefUtil;

    private MutableLiveData<List<Article>> articlesData;
    private List<Article> articleList = new ArrayList<>();

    private ApiService apiService;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        prefUtil = new PrefUtil(getApplication());
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    /**
     * Return all articles
     * @param page number of current page that used in api call in order to load more data
     */
    public void getNewsLiveData(int page){
        getBusy().setValue(0);
        getFavClickable().setValue(false);

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("apiKey", Const.API_KEY);
        queryMap.put("sources", Const.SOURCE);
        queryMap.put("language", Const.LANGUAGE);
        queryMap.put("sortBy", Const.DAY);
        queryMap.put("page", page);

        apiService.getEveryThing(queryMap).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(response.isSuccessful()){
                    articleList.addAll(response.body().getArticles());
                    getArticlesData().setValue(articleList);
                }

                getBusy().setValue(8);
                getFavClickable().setValue(true);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                getBusy().setValue(8);
                getFavClickable().setValue(true);
            }
        });
    }

    public MutableLiveData<List<Article>> getArticlesData() {
        if (articlesData == null) {
            articlesData = new MutableLiveData<>();
        }

        return articlesData;
    }

    public MutableLiveData<Integer> getBusy(){
        if(busy == null){
            busy = new MutableLiveData<>();
        }

        return busy;
    }

    public MutableLiveData<Boolean> getAllToggleSelection() {
        if(allToggleSelection == null){
            allToggleSelection = new MutableLiveData<>();
            allToggleSelection.setValue(true);
        }
        return allToggleSelection;
    }

    public MutableLiveData<Boolean> getFavClickable() {
        return favClickable;
    }

    /**
     * clicks on All Articles button in articles activity
     */
    public void onAllClicked(){
        articleList.clear();
        articlesData.setValue(articleList);
        currentPage = 1;
        getNewsLiveData(currentPage);
        allToggleSelection.setValue(true);
    }

    /**
     * Clicks on Favorites button in articles activity
     */
    public void onFavClick(){
        articlesData.setValue(prefUtil.getFavoritesList());
        allToggleSelection.setValue(false);
    }

    /**
     * imageUrl property used in XML file to set image for imageView content
     * @param imageView view takes the image
     * @param url article image url
     */
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url){
        Context context = imageView.getContext();
        GlideApp.with(context)
                .load(url)
                .placeholder(ContextCompat.getDrawable(context, R.drawable.article))
                .into(imageView);
    }
}
