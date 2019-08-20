package com.example.baselibrary.mvp.contract;


import com.example.baselibrary.mvp.model.BaseModel;
import com.example.baselibrary.mvp.presenter.BasePresenter;
import com.example.baselibrary.mvp.view.IBaseView;

import io.reactivex.Observer;

/**
 *
 */
public interface ILoginContract {

    interface ILoginView extends IBaseView {

        void showDialog();
        void hideDialog();
        void loginStatusShow(int code, String message);
    }

    abstract class LoginModel extends BaseModel {

        public abstract void loginResponse(String phoneStr, String passwordStr, Observer<String> observer);
        public abstract void interruptRequest();
    }

    abstract class LoginPresenter extends BasePresenter<ILoginView, LoginModel> {

        public abstract void requestLogin(String phoneStr, String passwordStr);
        public abstract void interruptRequest();
    }
}
