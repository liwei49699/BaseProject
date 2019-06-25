package com.person.liwei.wraper;

import android.view.View;

public class ViewWraper {

    private View mView;

    public ViewWraper(View view) {
        mView = view;
    }

    public int getHeight(){

        int height = mView.getLayoutParams().height;
        return height;
    }

    public void setHeight(int height){

        mView.getLayoutParams().height = height;
        mView.requestLayout();
    }
}
