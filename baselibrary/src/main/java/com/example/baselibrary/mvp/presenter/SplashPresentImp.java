package com.example.baselibrary.mvp.presenter;


import com.example.baselibrary.mvp.contract.ISplashContract;

/**
 *
 */
public class SplashPresentImp extends ISplashContract.SplashPresenter {

    private ISplashContract.ISplashView view;
    private ISplashContract.SplashModel model;

    public SplashPresentImp(ISplashContract.ISplashView view, ISplashContract.SplashModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getLoginStatus() {

        boolean login = model.isLogin();
        if(login) {

            view.goMain();
        } else {

            view.goLogin();
        }
    }
}
