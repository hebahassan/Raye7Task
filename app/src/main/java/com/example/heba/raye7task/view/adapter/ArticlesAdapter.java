package com.example.heba.raye7task.view.adapter;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.heba.raye7task.R;
import com.example.heba.raye7task.databinding.RowArticleBinding;
import com.example.heba.raye7task.generated.callback.OnClickListener;
import com.example.heba.raye7task.model.Article;
import com.example.heba.raye7task.viewmodel.ArticleViewModel;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticleItemView> {
    private List<Article> articlesList;
    private Context context;
    private ArticleViewModel articleViewModel;
    private int selectedPosition = -1;

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
    public void onBindViewHolder(@NonNull final ArticleItemView holder, final int position) {
        final Article article = articlesList.get(position);
        holder.binding.setArticle(article);

        holder.binding.IBFav.setImageDrawable(article.getFav() ? ContextCompat.getDrawable(context, R.drawable.fav_h_icon) :
                ContextCompat.getDrawable(context, R.drawable.fav_icon));

        holder.binding.IBFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                article.setFav(!article.getFav());
                holder.binding.IBFav.setImageDrawable(article.getFav() ? ContextCompat.getDrawable(context, R.drawable.fav_h_icon) :
                        ContextCompat.getDrawable(context, R.drawable.fav_icon));
            }
        });

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
