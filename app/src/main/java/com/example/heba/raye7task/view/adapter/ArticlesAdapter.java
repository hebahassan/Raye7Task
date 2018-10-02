package com.example.heba.raye7task.view.adapter;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.heba.raye7task.R;
import com.example.heba.raye7task.databinding.RowArticleBinding;
import com.example.heba.raye7task.model.Article;
import com.example.heba.raye7task.viewmodel.ArticleViewModel;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticleItemView> {
    private List<Article> articlesList;
    private Context context;
    private ArticleViewModel articleViewModel;

    public ArticlesAdapter(List<Article> articlesList, Context context){
        this.articlesList = articlesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ArticleItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowArticleBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_article, parent, false);

        articleViewModel = ViewModelProviders.of((AppCompatActivity)context).get(ArticleViewModel.class);
        binding.setArticleVM(articleViewModel);
        binding.setLifecycleOwner((AppCompatActivity)context);

        return new ArticleItemView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleItemView holder, int position) {
        holder.binding.setArticle(articlesList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    class ArticleItemView extends RecyclerView.ViewHolder {
        RowArticleBinding binding;

        ArticleItemView(RowArticleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
