package com.person.liwei.dagger.simple;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

public class DaggerPresenter {

    private IDaggerView mDaggerView;

    @Inject
    public DaggerPresenter(IDaggerView daggerView) {
        mDaggerView = daggerView;
    }

    public void showUserInfo(){

        Context context = mDaggerView.getContext();
        Toast.makeText(context, "个人信息", Toast.LENGTH_SHORT).show();
    }
}
