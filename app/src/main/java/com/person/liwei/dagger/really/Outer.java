package com.person.liwei.dagger.really;

import android.util.Log;

import javax.inject.Inject;

public class Outer {

    private Inner mInner;
    private InnerOther mInnerOther;

    @Inject
    public Outer(Inner inner, InnerOther innerOther) {
        mInner = inner;
        mInnerOther = innerOther;
    }

    public void write(){

        Log.d("--TAG--" + mInner, "Outer write()=" + mInnerOther);
    }
}
