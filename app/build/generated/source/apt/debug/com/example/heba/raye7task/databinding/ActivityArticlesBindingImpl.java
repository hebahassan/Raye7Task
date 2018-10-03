package com.example.heba.raye7task.databinding;
import com.example.heba.raye7task.R;
import com.example.heba.raye7task.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityArticlesBindingImpl extends ActivityArticlesBinding implements com.example.heba.raye7task.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.included_toolbar, 5);
        sViewsWithIds.put(R.id.linearLayout, 6);
        sViewsWithIds.put(R.id.RV_news, 7);
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityArticlesBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ActivityArticlesBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (android.widget.Button) bindings[3]
            , (android.widget.Button) bindings[4]
            , (android.support.v7.widget.RecyclerView) bindings[7]
            , (android.widget.TextView) bindings[2]
            , (android.view.View) bindings[5]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.ProgressBar) bindings[1]
            );
        this.BTAll.setTag(null);
        this.BTFav.setTag(null);
        this.TVArticlesStatus.setTag(null);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.progressBar.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.example.heba.raye7task.generated.callback.OnClickListener(this, 2);
        mCallback1 = new com.example.heba.raye7task.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
        if (BR.newsViewModel == variableId) {
            setNewsViewModel((com.example.heba.raye7task.ui.articles.NewsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setNewsViewModel(@Nullable com.example.heba.raye7task.ui.articles.NewsViewModel NewsViewModel) {
        this.mNewsViewModel = NewsViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.newsViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeNewsViewModelTextVisibility((android.arch.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeNewsViewModelBusy((android.arch.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
            case 2 :
                return onChangeNewsViewModelAllToggleSelection((android.arch.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
            case 3 :
                return onChangeNewsViewModelTextMsg((android.arch.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeNewsViewModelTextVisibility(android.arch.lifecycle.MutableLiveData<java.lang.Integer> NewsViewModelTextVisibility, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeNewsViewModelBusy(android.arch.lifecycle.MutableLiveData<java.lang.Integer> NewsViewModelBusy, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeNewsViewModelAllToggleSelection(android.arch.lifecycle.MutableLiveData<java.lang.Boolean> NewsViewModelAllToggleSelection, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeNewsViewModelTextMsg(android.arch.lifecycle.MutableLiveData<java.lang.String> NewsViewModelTextMsg, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
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
        java.lang.Boolean newsViewModelAllToggleSelectionGetValue = null;
        java.lang.Integer newsViewModelBusyGetValue = null;
        android.graphics.drawable.Drawable newsViewModelAllToggleSelectionBTAllAndroidDrawableAllSelectedBTAllAndroidDrawableAllUnselected = null;
        int androidDatabindingViewDataBindingSafeUnboxNewsViewModelTextVisibilityGetValue = 0;
        android.arch.lifecycle.MutableLiveData<java.lang.Integer> newsViewModelTextVisibility = null;
        boolean newsViewModelAllToggleSelection = false;
        int androidDatabindingViewDataBindingSafeUnboxNewsViewModelBusyGetValue = 0;
        android.arch.lifecycle.MutableLiveData<java.lang.Integer> newsViewModelBusy = null;
        android.arch.lifecycle.MutableLiveData<java.lang.Boolean> NewsViewModelAllToggleSelection1 = null;
        android.graphics.drawable.Drawable newsViewModelAllToggleSelectionBTFavAndroidDrawableFavSelectedBTFavAndroidDrawableFavUnselected = null;
        java.lang.String newsViewModelTextMsgGetValue = null;
        java.lang.Integer newsViewModelTextVisibilityGetValue = null;
        com.example.heba.raye7task.ui.articles.NewsViewModel newsViewModel = mNewsViewModel;
        boolean androidDatabindingViewDataBindingSafeUnboxNewsViewModelAllToggleSelectionGetValue = false;
        android.arch.lifecycle.MutableLiveData<java.lang.String> newsViewModelTextMsg = null;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (newsViewModel != null) {
                        // read newsViewModel.textVisibility
                        newsViewModelTextVisibility = newsViewModel.getTextVisibility();
                    }
                    updateLiveDataRegistration(0, newsViewModelTextVisibility);


                    if (newsViewModelTextVisibility != null) {
                        // read newsViewModel.textVisibility.getValue()
                        newsViewModelTextVisibilityGetValue = newsViewModelTextVisibility.getValue();
                    }


                    // read android.databinding.ViewDataBinding.safeUnbox(newsViewModel.textVisibility.getValue())
                    androidDatabindingViewDataBindingSafeUnboxNewsViewModelTextVisibilityGetValue = android.databinding.ViewDataBinding.safeUnbox(newsViewModelTextVisibilityGetValue);
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (newsViewModel != null) {
                        // read newsViewModel.busy
                        newsViewModelBusy = newsViewModel.getBusy();
                    }
                    updateLiveDataRegistration(1, newsViewModelBusy);


                    if (newsViewModelBusy != null) {
                        // read newsViewModel.busy.getValue()
                        newsViewModelBusyGetValue = newsViewModelBusy.getValue();
                    }


                    // read android.databinding.ViewDataBinding.safeUnbox(newsViewModel.busy.getValue())
                    androidDatabindingViewDataBindingSafeUnboxNewsViewModelBusyGetValue = android.databinding.ViewDataBinding.safeUnbox(newsViewModelBusyGetValue);
            }
            if ((dirtyFlags & 0x34L) != 0) {

                    if (newsViewModel != null) {
                        // read newsViewModel.allToggleSelection
                        NewsViewModelAllToggleSelection1 = newsViewModel.getAllToggleSelection();
                    }
                    updateLiveDataRegistration(2, NewsViewModelAllToggleSelection1);


                    if (NewsViewModelAllToggleSelection1 != null) {
                        // read newsViewModel.allToggleSelection.getValue()
                        newsViewModelAllToggleSelectionGetValue = NewsViewModelAllToggleSelection1.getValue();
                    }


                    // read android.databinding.ViewDataBinding.safeUnbox(newsViewModel.allToggleSelection.getValue())
                    androidDatabindingViewDataBindingSafeUnboxNewsViewModelAllToggleSelectionGetValue = android.databinding.ViewDataBinding.safeUnbox(newsViewModelAllToggleSelectionGetValue);
                if((dirtyFlags & 0x34L) != 0) {
                    if(androidDatabindingViewDataBindingSafeUnboxNewsViewModelAllToggleSelectionGetValue) {
                            dirtyFlags |= 0x80L;
                    }
                    else {
                            dirtyFlags |= 0x40L;
                    }
                }


                    // read android.databinding.ViewDataBinding.safeUnbox(newsViewModel.allToggleSelection.getValue()) ? @android:drawable/all_selected : @android:drawable/all_unselected
                    newsViewModelAllToggleSelectionBTAllAndroidDrawableAllSelectedBTAllAndroidDrawableAllUnselected = ((androidDatabindingViewDataBindingSafeUnboxNewsViewModelAllToggleSelectionGetValue) ? (getDrawableFromResource(BTAll, R.drawable.all_selected)) : (getDrawableFromResource(BTAll, R.drawable.all_unselected)));
                    // read !android.databinding.ViewDataBinding.safeUnbox(newsViewModel.allToggleSelection.getValue())
                    newsViewModelAllToggleSelection = !androidDatabindingViewDataBindingSafeUnboxNewsViewModelAllToggleSelectionGetValue;
                if((dirtyFlags & 0x34L) != 0) {
                    if(newsViewModelAllToggleSelection) {
                            dirtyFlags |= 0x200L;
                    }
                    else {
                            dirtyFlags |= 0x100L;
                    }
                }


                    // read !android.databinding.ViewDataBinding.safeUnbox(newsViewModel.allToggleSelection.getValue()) ? @android:drawable/fav_selected : @android:drawable/fav_unselected
                    newsViewModelAllToggleSelectionBTFavAndroidDrawableFavSelectedBTFavAndroidDrawableFavUnselected = ((newsViewModelAllToggleSelection) ? (getDrawableFromResource(BTFav, R.drawable.fav_selected)) : (getDrawableFromResource(BTFav, R.drawable.fav_unselected)));
            }
            if ((dirtyFlags & 0x38L) != 0) {

                    if (newsViewModel != null) {
                        // read newsViewModel.textMsg
                        newsViewModelTextMsg = newsViewModel.getTextMsg();
                    }
                    updateLiveDataRegistration(3, newsViewModelTextMsg);


                    if (newsViewModelTextMsg != null) {
                        // read newsViewModel.textMsg.getValue()
                        newsViewModelTextMsgGetValue = newsViewModelTextMsg.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x34L) != 0) {
            // api target 1

            android.databinding.adapters.ViewBindingAdapter.setBackground(this.BTAll, newsViewModelAllToggleSelectionBTAllAndroidDrawableAllSelectedBTAllAndroidDrawableAllUnselected);
            android.databinding.adapters.ViewBindingAdapter.setBackground(this.BTFav, newsViewModelAllToggleSelectionBTFavAndroidDrawableFavSelectedBTFavAndroidDrawableFavUnselected);
        }
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            this.BTAll.setOnClickListener(mCallback1);
            this.BTFav.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            this.TVArticlesStatus.setVisibility(androidDatabindingViewDataBindingSafeUnboxNewsViewModelTextVisibilityGetValue);
        }
        if ((dirtyFlags & 0x38L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.TVArticlesStatus, newsViewModelTextMsgGetValue);
        }
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            this.progressBar.setVisibility(androidDatabindingViewDataBindingSafeUnboxNewsViewModelBusyGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // newsViewModel
                com.example.heba.raye7task.ui.articles.NewsViewModel newsViewModel = mNewsViewModel;
                // newsViewModel != null
                boolean newsViewModelJavaLangObjectNull = false;



                newsViewModelJavaLangObjectNull = (newsViewModel) != (null);
                if (newsViewModelJavaLangObjectNull) {


                    newsViewModel.onFavClick();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // newsViewModel
                com.example.heba.raye7task.ui.articles.NewsViewModel newsViewModel = mNewsViewModel;
                // newsViewModel != null
                boolean newsViewModelJavaLangObjectNull = false;



                newsViewModelJavaLangObjectNull = (newsViewModel) != (null);
                if (newsViewModelJavaLangObjectNull) {


                    newsViewModel.onAllClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): newsViewModel.textVisibility
        flag 1 (0x2L): newsViewModel.busy
        flag 2 (0x3L): newsViewModel.allToggleSelection
        flag 3 (0x4L): newsViewModel.textMsg
        flag 4 (0x5L): newsViewModel
        flag 5 (0x6L): null
        flag 6 (0x7L): android.databinding.ViewDataBinding.safeUnbox(newsViewModel.allToggleSelection.getValue()) ? @android:drawable/all_selected : @android:drawable/all_unselected
        flag 7 (0x8L): android.databinding.ViewDataBinding.safeUnbox(newsViewModel.allToggleSelection.getValue()) ? @android:drawable/all_selected : @android:drawable/all_unselected
        flag 8 (0x9L): !android.databinding.ViewDataBinding.safeUnbox(newsViewModel.allToggleSelection.getValue()) ? @android:drawable/fav_selected : @android:drawable/fav_unselected
        flag 9 (0xaL): !android.databinding.ViewDataBinding.safeUnbox(newsViewModel.allToggleSelection.getValue()) ? @android:drawable/fav_selected : @android:drawable/fav_unselected
    flag mapping end*/
    //end
}