package com.example.baselibrary.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.example.baselibrary.R;
import com.example.baselibrary.mvp.model.BaseModel;
import com.example.baselibrary.mvp.presenter.BasePresenter;
import com.example.baselibrary.util.manager.ActivityManager;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMvpActivity<P extends BasePresenter,M extends BaseModel> extends RxAppCompatActivity implements IBaseView{

    protected P mPresenter;
    protected M mModel;
    private Unbinder mUnBinder;
    protected Context mContext;
    protected RelativeLayout mRlTitle;
    protected LinearLayout mLlRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_base_mvp);
        ActivityManager.getInstance().addActivity(this);

        mLlRoot = findViewById(R.id.ll_root);
        mRlTitle = findViewById(R.id.rl_title);
        View vgContent = getLayoutInflater().inflate(getLayoutID(), null);
        mLlRoot.addView(vgContent, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        if(hasTitleBar()) {

            mRlTitle.setVisibility(View.VISIBLE);
        } else {

            mRlTitle.setVisibility(View.GONE);
        }

        mContext = this;
        mModel = createModel();
        mPresenter = createPresenter();
        ActivityManager.getInstance().addActivity(this);
        if (mPresenter == null || mModel == null) {

            throw new NullPointerException("Presenter or Model is null!!!");
        }
        mPresenter.onAttachView(this,mModel);
        mUnBinder = ButterKnife.bind(this);
        init();
    }

    protected abstract int getLayoutID();

    protected abstract boolean hasTitleBar();

    protected abstract void init();

    protected abstract M createModel();

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        
        if(mPresenter != null) {

            mPresenter.onDetachView();
        }

        if (mUnBinder != Unbinder.EMPTY) {

            mUnBinder.unbind();
        }
    }

    protected void startActivity(Class aClass) {

        startActivity(aClass, null);
    }

    protected void startActivity(Class aClass, Bundle bundle) {

        Intent intent = new Intent(this, aClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
