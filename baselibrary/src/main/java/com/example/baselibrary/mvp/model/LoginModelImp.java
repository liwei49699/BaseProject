package com.example.baselibrary.mvp.model;


import com.example.baselibrary.mvp.contract.ILoginContract;
import com.example.baselibrary.mvp.entity.LoginRequest;
import com.example.baselibrary.mvp.net.RetrofitHelper;
import com.example.baselibrary.mvp.net.RetrofitService;
import com.example.baselibrary.util.JsonUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Description:
 * @Author: liwei
 * @CreateDate: 2018/10/23 0023 10:16
 * @Version: 1.0
 * @weChat 18571658038
 */
public class LoginModelImp extends ILoginContract.LoginModel {


    private Disposable mDisposable;

    @Override
    public void loginResponse(String phoneStr, String passwordStr, Observer<String> observer) {

        RetrofitService service = RetrofitHelper.getDriverApi();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("96e79218965eb72c92a549dd5a330112");
        loginRequest.setLoginMode(1);
        loginRequest.setUserid("18915329001");

        LoginRequest.ClientInfoBean clientInfoBean = new LoginRequest.ClientInfoBean();
        clientInfoBean.setVender("APPLE");
        clientInfoBean.setAppVersion("1.0.0");
        clientInfoBean.setOsVersion("12.0");
        clientInfoBean.setDeviceID("FCBC863E-0955-462A-AA33-76EBB4D25E3E");
        clientInfoBean.setSdkVersion("26");
        clientInfoBean.setDeviceType(2);
        clientInfoBean.setIosToken("70cbadc8102fe020fd179b73c34b6951a50a239e22ffa386d36eb69d813fda87");
        clientInfoBean.setPublishChannel("android market");
        clientInfoBean.setNet("wifi");
        loginRequest.setClientInfo(clientInfoBean);

        loginRequest.setRole(2);
        loginRequest.setAuthCode("");

        service.getPostInfoRx(JsonUtils.objectToString(loginRequest))
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {

                        mDisposable = disposable;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void interruptRequest(){

        if(mDisposable != null && !mDisposable.isDisposed()) {

            mDisposable.dispose();
        }
    }
}
