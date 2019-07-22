package com.person.liwei.dagger.really;

import android.util.Log;

public class ComeOn {

    private String mMsg;

    public ComeOn(String msg) {
        mMsg = msg;
    }

    public void come(){

        Log.d("--TAG--", "ComeOn come()" + mMsg);
    }
}
