package com.example.heba.raye7task.ui.articles;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.heba.raye7task.R;
import com.example.heba.raye7task.databinding.RowArticleBinding;
import com.example.heba.raye7task.model.Article;
import com.example.heba.raye7task.util.PrefUtil;

import java.util.ArrayList;
import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticleItemView> {
    private List<Article> articlesList;
    private Context context;
    private PrefUtil prefUtil;
    private List<Article> favArticlesList = new ArrayList<>();

    public ArticlesAdapter(List<Article> articlesList, Context context){
        this.articlesList = articlesList;
        this.context = context;
        prefUtil = new PrefUtil(context);
    }

    @NonNull
    @Override
    public ArticleItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowArticleBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_article, parent, false);

        return new ArticleItemView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticleItemView holder, final int position) {
        final Article article = articlesList.get(position);
        holder.binding.setArticle(article);

        holder.binding.IBFav.setImageDrawable(article.getFav() ? ContextCompat.getDrawable(context, R.drawable.fav_h_icon) :
                ContextCompat.getDrawable(context, R.drawable.fav_icon));

        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return articlesList != null && articlesList.size() > 0 ? articlesList.size() : 0;
    }

    class ArticleItemView extends RecyclerView.ViewHolder implements View.OnClickListener {
        RowArticleBinding binding;

        ArticleItemView(final RowArticleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(this);

            binding.IBFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Article article = articlesList.get(getAdapterPosition());
                    article.setFav(!article.getFav());

                    if (article.getFav()) {
                        binding.IBFav.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.fav_h_icon));

                        favArticlesList = prefUtil.getFavoritesList();
                        favArticlesList.add(article);
                        prefUtil.saveFavoritesList(favArticlesList);
                    }
                    else {
                        binding.IBFav.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.fav_icon));

                        articlesList.remove(article);
                        notifyDataSetChanged();

                        favArticlesList = prefUtil.getFavoritesList();
                        for (int i = 0 ; i < favArticlesList.size() ; i++) {
                            if (favArticlesList.get(i).getTitle().equals(article.getTitle())) {
                                favArticlesList.remove(i);
                            }
                        }
                        prefUtil.saveFavoritesList(favArticlesList);
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            Article article = articlesList.get(getAdapterPosition());
            String articleUrl = article.getUrl();

            Log.d("article_url", articleUrl);

            if (!articleUrl.startsWith("http://") && !articleUrl.startsWith("https://"))
                articleUrl = "http://" + articleUrl;

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(articleUrl));
            browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(browserIntent);
        }
    }
}
