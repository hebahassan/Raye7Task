package com.example.heba.raye7task.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;

import com.example.heba.raye7task.R;
import com.example.heba.raye7task.app.GlideApp;

public class ArticleViewModel extends AndroidViewModel {
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

    public void onArticleClicked(String articleUrl){
        Log.d("article_url", articleUrl);

        if (!articleUrl.startsWith("http://") && !articleUrl.startsWith("https://"))
            articleUrl = "http://" + articleUrl;

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(articleUrl));
        browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(browserIntent);
    }
}
