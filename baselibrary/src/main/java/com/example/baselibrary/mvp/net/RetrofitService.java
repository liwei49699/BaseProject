package com.example.baselibrary.mvp.net;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 接口服务列表
 */
public interface RetrofitService {

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("query")
    Observable<String> getPostInfoRx(@Query("simpleAccountService.login") String login);
}
