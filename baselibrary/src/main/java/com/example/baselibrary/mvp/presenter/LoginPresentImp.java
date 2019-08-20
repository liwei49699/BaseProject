package com.example.baselibrary.mvp.presenter;

import android.util.Log;


import com.example.baselibrary.mvp.contract.ILoginContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: GitCode
 * @Package: android.cunniao.cn.mvp.presenter
 * @ClassName: SplashPresentImp
 * @Description:
 * @Author: liwei
 * @CreateDate: 2018/10/23 0023 10:19
 * @Version: 1.0
 * @weChat 18571658038
 */
public class LoginPresentImp extends ILoginContract.LoginPresenter {

    private ILoginContract.ILoginView view;
    private ILoginContract.LoginModel model;

    public LoginPresentImp(ILoginContract.ILoginView view, ILoginContract.LoginModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void requestLogin(String phoneStr, String passwordStr) {

        model.loginResponse(phoneStr,passwordStr, new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

                view.showDialog();
            }

            @Override
            public void onNext(String loginResponse) {

                // TODO: 2018/10/24 0024 根据返回码判断
                view.loginStatusShow(200,"登陆成功");

                Log.d("--TAG--", "onNext: " + loginResponse);
            }

            @Override
            public void onError(Throwable e) {

                e.printStackTrace();
                Log.d("--TAG--", "onNext: " + e.getMessage());

                view.hideDialog();
                view.loginStatusShow(0,"访问服务器异常");
            }

            @Override
            public void onComplete() {

                view.hideDialog();
            }
        });
    }

    @Override
    public void interruptRequest() {

        model.interruptRequest();
    }
}
