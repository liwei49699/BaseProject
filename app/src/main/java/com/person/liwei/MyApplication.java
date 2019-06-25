package com.person.liwei;

import android.app.Application;
import android.content.Context;

import com.person.liwei.utils.Utils;


public class MyApplication extends Application {

    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }
}
