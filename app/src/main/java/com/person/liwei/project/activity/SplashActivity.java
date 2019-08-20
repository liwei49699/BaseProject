package com.person.liwei.project.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;

import com.example.baselibrary.AppApplication;
import com.example.baselibrary.Constant.SpKey;
import com.example.baselibrary.mvp.contract.ISplashContract;
import com.example.baselibrary.mvp.model.SplashModelImp;
import com.example.baselibrary.mvp.presenter.SplashPresentImp;
import com.example.baselibrary.mvp.view.BaseMvpActivity;
import com.gyf.barlibrary.ImmersionBar;
import com.person.liwei.R;

import net.grandcentrix.tray.AppPreferences;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class SplashActivity extends BaseMvpActivity<ISplashContract.SplashPresenter,ISplashContract.SplashModel> implements ISplashContract.ISplashView{

    private ImmersionBar mImmersionBar;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected boolean hasTitleBar() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mImmersionBar != null){

            mImmersionBar.destroy();
        }
    }

    @Override
    protected void init() {

        //延时跳转
        delayedJump();
    }

    private void delayedJump() {


        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception{

                SystemClock.sleep(2000);
                //测试更改需求后期添加判断token的改动
                AppPreferences appPreferences = new AppPreferences(AppApplication.sContext);
                String token = appPreferences.getString(SpKey.TOKEN, "");
                if(!TextUtils.isEmpty(token)) {

                }

                emitter.onNext("加载完成");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<String>bindToLifecycle())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {

                        mPresenter.getLoginStatus();

                    }

                    @Override
                    public void onError(Throwable e) {

                        mPresenter.getLoginStatus();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected ISplashContract.SplashModel createModel() {
        
        return new SplashModelImp();
    }

    @Override
    protected ISplashContract.SplashPresenter createPresenter() {
        return new SplashPresentImp(this,mModel);
    }

    @Override
    public void goMain() {

        finish();
    }

    @Override
    public void goLogin() {

        startActivity(LoginActivity.class);
        finish();
    }
}
