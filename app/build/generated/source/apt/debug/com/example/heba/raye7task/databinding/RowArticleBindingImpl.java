package com.example.heba.raye7task.databinding;
import com.example.heba.raye7task.R;
import com.example.heba.raye7task.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RowArticleBindingImpl extends RowArticleBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.IB_fav, 4);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RowArticleBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private RowArticleBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageButton) bindings[4]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.IVArticleImage.setTag(null);
        this.TVArticleName.setTag(null);
        this.TVArticleTime.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.vm == variableId) {
            setVm((com.example.heba.raye7task.ui.articles.NewsViewModel) variable);
        }
        else if (BR.article == variableId) {
            setArticle((com.example.heba.raye7task.model.Article) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable com.example.heba.raye7task.ui.articles.NewsViewModel Vm) {
        this.mVm = Vm;
    }
    public void setArticle(@Nullable com.example.heba.raye7task.model.Article Article) {
        this.mArticle = Article;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.article);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String articlePublishedAt = null;
        java.lang.String articleTitle = null;
        java.lang.String articleUrlToImage = null;
        com.example.heba.raye7task.model.Article article = mArticle;

        if ((dirtyFlags & 0x6L) != 0) {



                if (article != null) {
                    // read article.publishedAt
                    articlePublishedAt = article.getPublishedAt();
                    // read article.title
                    articleTitle = article.getTitle();
                    // read article.urlToImage
                    articleUrlToImage = article.getUrlToImage();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.example.heba.raye7task.ui.articles.NewsViewModel.loadImage(this.IVArticleImage, articleUrlToImage);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.TVArticleName, articleTitle);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.TVArticleTime, articlePublishedAt);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): article
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}