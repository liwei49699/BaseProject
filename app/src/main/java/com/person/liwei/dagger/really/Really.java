package com.person.liwei.dagger.really;

import android.util.Log;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class Really {
    private String mMsg;

//    @Inject
//    public Really() {
//
//        Log.d("--TAG--", "Really Really()" + "初始化构造器");
//    }

    @Inject
    public Really(String msg) {
        mMsg = msg;
    }

    @Provides
    public String getMsg(){

        return mMsg;
    }

    public void read(){

        Log.d("--TAG--", "Really read()" + mMsg);
    }
}
