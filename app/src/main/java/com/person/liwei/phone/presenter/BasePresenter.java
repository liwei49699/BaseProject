package com.person.liwei.phone.presenter;

import com.person.liwei.phone.ui.BaseView;

public class BasePresenter<M,V extends BaseView> {

    protected M mModel;
    protected V mView;

    public BasePresenter(M m, V v) {
        mModel = m;
        mView = v;
    }
}
