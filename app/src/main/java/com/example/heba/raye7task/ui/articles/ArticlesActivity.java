package com.example.heba.raye7task.ui.articles;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.heba.raye7task.R;
import com.example.heba.raye7task.databinding.ActivityArticlesBinding;
import com.example.heba.raye7task.model.Article;

import java.util.List;

public class ArticlesActivity extends AppCompatActivity {
    ActivityArticlesBinding binding;
    ArticlesAdapter articlesAdapter;
    NewsViewModel newsViewModel;

    public static int currentPage = 1;
    private int displayPos = 0;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_articles);
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        binding.setNewsViewModel(newsViewModel);
        binding.setLifecycleOwner(this);

        newsViewModel.getNewsLiveData(currentPage);
        newsViewModel.getArticlesData().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable final List<Article> articles) {
                layoutManager = new LinearLayoutManager(ArticlesActivity.this);
                layoutManager.scrollToPosition(displayPos);
                articlesAdapter = new ArticlesAdapter(articles, ArticlesActivity.this);
                binding.RVNews.setLayoutManager(layoutManager);
                binding.RVNews.setAdapter(articlesAdapter);
            }
        });

        onLoadMore();
    }

    /**
     * Load more articles in recyclerview
     */
    private void onLoadMore(){
        binding.RVNews.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)){
                    if(newsViewModel.getAllToggleSelection().getValue() != null &&
                            newsViewModel.getAllToggleSelection().getValue()) {
                        currentPage++;
                        newsViewModel.getNewsLiveData(currentPage);
                        displayPos = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition() + 1;
                    }
                }
            }
        });
    }
}
