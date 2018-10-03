package com.example.heba.raye7task.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.heba.raye7task.ui.articles.NewsViewModel;

public abstract class ActivityArticlesBinding extends ViewDataBinding {
  @NonNull
  public final Button BTAll;

  @NonNull
  public final Button BTFav;

  @NonNull
  public final RecyclerView RVNews;

  @NonNull
  public final TextView TVArticlesStatus;

  @NonNull
  public final View includedToolbar;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final ProgressBar progressBar;

  @Bindable
  protected NewsViewModel mNewsViewModel;

  protected ActivityArticlesBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button BTAll, Button BTFav, RecyclerView RVNews,
      TextView TVArticlesStatus, View includedToolbar, LinearLayout linearLayout,
      ProgressBar progressBar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.BTAll = BTAll;
    this.BTFav = BTFav;
    this.RVNews = RVNews;
    this.TVArticlesStatus = TVArticlesStatus;
    this.includedToolbar = includedToolbar;
    this.linearLayout = linearLayout;
    this.progressBar = progressBar;
  }

  public abstract void setNewsViewModel(@Nullable NewsViewModel newsViewModel);

  @Nullable
  public NewsViewModel getNewsViewModel() {
    return mNewsViewModel;
  }

  @NonNull
  public static ActivityArticlesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityArticlesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityArticlesBinding>inflate(inflater, com.example.heba.raye7task.R.layout.activity_articles, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityArticlesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityArticlesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityArticlesBinding>inflate(inflater, com.example.heba.raye7task.R.layout.activity_articles, null, false, component);
  }

  public static ActivityArticlesBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityArticlesBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityArticlesBinding)bind(component, view, com.example.heba.raye7task.R.layout.activity_articles);
  }
}
