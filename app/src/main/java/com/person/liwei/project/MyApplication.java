package com.person.liwei.project;

import com.example.baselibrary.AppApplication;
import com.person.liwei.utils.Utils;

public class MyApplication extends AppApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }
}
