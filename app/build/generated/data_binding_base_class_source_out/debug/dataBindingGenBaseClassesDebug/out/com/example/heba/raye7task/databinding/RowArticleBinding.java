package com.example.heba.raye7task.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.heba.raye7task.model.Article;
import com.example.heba.raye7task.ui.articles.NewsViewModel;

public abstract class RowArticleBinding extends ViewDataBinding {
  @NonNull
  public final ImageButton IBFav;

  @NonNull
  public final ImageView IVArticleImage;

  @NonNull
  public final TextView TVArticleName;

  @NonNull
  public final TextView TVArticleTime;

  @Bindable
  protected Article mArticle;

  @Bindable
  protected NewsViewModel mVm;

  protected RowArticleBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageButton IBFav, ImageView IVArticleImage, TextView TVArticleName,
      TextView TVArticleTime) {
    super(_bindingComponent, _root, _localFieldCount);
    this.IBFav = IBFav;
    this.IVArticleImage = IVArticleImage;
    this.TVArticleName = TVArticleName;
    this.TVArticleTime = TVArticleTime;
  }

  public abstract void setArticle(@Nullable Article article);

  @Nullable
  public Article getArticle() {
    return mArticle;
  }

  public abstract void setVm(@Nullable NewsViewModel vm);

  @Nullable
  public NewsViewModel getVm() {
    return mVm;
  }

  @NonNull
  public static RowArticleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static RowArticleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<RowArticleBinding>inflate(inflater, com.example.heba.raye7task.R.layout.row_article, root, attachToRoot, component);
  }

  @NonNull
  public static RowArticleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static RowArticleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<RowArticleBinding>inflate(inflater, com.example.heba.raye7task.R.layout.row_article, null, false, component);
  }

  public static RowArticleBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static RowArticleBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (RowArticleBinding)bind(component, view, com.example.heba.raye7task.R.layout.row_article);
  }
}
