package com.person.liwei.phone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;

import com.mikepenz.iconics.context.IconicsLayoutInflater;
import com.person.liwei.phone.di.component.AppComponent;
import com.person.liwei.phone.presenter.BasePresenter;
import com.person.liwei.project.MyApplication;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private Unbinder mUnbinder;
    private MyApplication mApplication;

    @Inject
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mUnbinder = ButterKnife.bind(this);
        this.mApplication = (MyApplication) getApplication();
        setupAcitivtyComponent(mApplication.getAppComponent());
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mUnbinder != Unbinder.EMPTY){
            mUnbinder.unbind();
        }
    }

    protected  void  startActivity(Class c){

        this.startActivity(new Intent(this,c));
    }
    public abstract int setLayout();
    public abstract  void setupAcitivtyComponent(AppComponent appComponent);
    public abstract void  init();

}
