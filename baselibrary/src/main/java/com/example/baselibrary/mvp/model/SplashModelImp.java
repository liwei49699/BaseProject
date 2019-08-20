package com.example.baselibrary.mvp.model;


import com.example.baselibrary.AppApplication;
import com.example.baselibrary.Constant.SpKey;
import com.example.baselibrary.mvp.contract.ISplashContract;

import net.grandcentrix.tray.AppPreferences;

/**
 *
 */
public class SplashModelImp extends ISplashContract.SplashModel {

    @Override
    public boolean isLogin() {

        AppPreferences appPreferences = new AppPreferences(AppApplication.sContext);
        return appPreferences.getBoolean(SpKey.LOGIN_SUCCESS,false);
    }
}
