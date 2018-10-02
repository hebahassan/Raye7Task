package com.example.heba.raye7task.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.heba.raye7task.R;
import com.example.heba.raye7task.databinding.ActivityArticlesBinding;
import com.example.heba.raye7task.model.News;
import com.example.heba.raye7task.view.adapter.ArticlesAdapter;
import com.example.heba.raye7task.viewmodel.NewsViewModel;

public class ArticlesActivity extends AppCompatActivity {
    ActivityArticlesBinding binding;
    ArticlesAdapter articlesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_articles);
        final NewsViewModel newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        binding.setNewsViewModel(newsViewModel);
        binding.setLifecycleOwner(this);

        newsViewModel.getNewsData().observe(this, new Observer<News>() {
            @Override
            public void onChanged(@Nullable News news) {
                if(news != null){
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ArticlesActivity.this);
                    articlesAdapter = new ArticlesAdapter(news.getArticles(), ArticlesActivity.this);
                    binding.RVNews.setLayoutManager(layoutManager);
                    binding.RVNews.setAdapter(articlesAdapter);
                }

                newsViewModel.getBusy();
                newsViewModel.getTextVisibility();
                newsViewModel.getTextMsg();
            }
        });
    }
}
