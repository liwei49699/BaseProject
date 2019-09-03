package com.person.liwei.phone.data.http;

import com.person.liwei.phone.bean.AppInfo;
import com.person.liwei.phone.bean.PageBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";

    @GET("featured")
    Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);
}
