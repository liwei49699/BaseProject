package com.person.liwei.phone.data;


import com.person.liwei.phone.bean.AppInfo;
import com.person.liwei.phone.bean.PageBean;
import com.person.liwei.phone.data.http.ApiService;

import retrofit2.Callback;

public class RecommendModel {

    private  ApiService mApiService;

    public RecommendModel(ApiService apiService){

        this.mApiService  =apiService;
    }

    public  void getApps(Callback<PageBean<AppInfo>> callback){

//        HttpManager manager = new HttpManager();
//        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
        mApiService.getApps("{'page':0}").enqueue(callback);
    }
}
