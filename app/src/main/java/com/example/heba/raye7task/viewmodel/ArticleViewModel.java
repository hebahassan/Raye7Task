package com.example.heba.raye7task.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.heba.raye7task.R;
import com.example.heba.raye7task.app.GlideApp;
import com.example.heba.raye7task.model.Article;

public class ArticleViewModel extends AndroidViewModel {
//    private MutableLiveData<Boolean> isFav = new MutableLiveData<>();

    public ArticleViewModel(@NonNull Application application) {
        super(application);
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url){
        Context context = imageView.getContext();
        GlideApp.with(context)
                .load(url)
                .placeholder(ContextCompat.getDrawable(context, R.drawable.article))
                .into(imageView);
    }

//    public void onFavClicked(Article article){
//        article.setFav(!article.getFav());
//        Log.d("favorite", article.getTitle() + " fav: " + article.getFav());
//    }

    public void onArticleClicked(String articleUrl){
        Log.d("article_url", articleUrl);

        if (!articleUrl.startsWith("http://") && !articleUrl.startsWith("https://"))
            articleUrl = "http://" + articleUrl;

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(articleUrl));
        browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(browserIntent);
    }

//    public MutableLiveData<Boolean> getIsFav() {
//        return isFav;
//    }

//    public static class Factory extends ViewModelProvider.NewInstanceFactory{
//        @NonNull
//        private final Application application;
//        private Article article;
//
//        public Factory(@NonNull Application application, Article article){
//            this.application = application;
//            this.article = article;
//        }
//
//        @SuppressWarnings("unchecked")
//        @NonNull
//        @Override
//        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//            return (T) new ArticleViewModel(application, article);
//        }
//    }
}
