package com.example.baselibrary.mvp.contract;


import com.example.baselibrary.mvp.model.BaseModel;
import com.example.baselibrary.mvp.presenter.BasePresenter;
import com.example.baselibrary.mvp.view.IBaseView;

/**
 * 闪屏页面契约建立连接
 */
public interface ISplashContract {

    interface ISplashView extends IBaseView {

        void goMain();
        void goLogin();
    }

    abstract class SplashModel extends BaseModel {

        public abstract boolean isLogin();
    }

    abstract class SplashPresenter extends BasePresenter<ISplashView,SplashModel> {

        public abstract void getLoginStatus();
    }
}
