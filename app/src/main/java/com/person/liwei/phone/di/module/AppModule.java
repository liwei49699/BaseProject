package com.person.liwei.phone.di.module;

import com.google.gson.Gson;
import com.person.liwei.project.MyApplication;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private MyApplication mApplication;

    public AppModule(MyApplication application){

        this.mApplication = application;
    }

    @Provides
    @Singleton
    public MyApplication provideApplication(){

        return  mApplication;
    }

    @Provides
    @Singleton
    public Gson provideGson(){

        return  new Gson();
    }
}
