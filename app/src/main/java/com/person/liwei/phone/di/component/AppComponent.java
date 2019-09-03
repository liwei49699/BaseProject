package com.person.liwei.phone.di.component;

import com.person.liwei.phone.data.http.ApiService;
import com.person.liwei.phone.di.module.AppModule;
import com.person.liwei.phone.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    ApiService getApiService();
}
