package com.person.liwei.project;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.baselibrary.AppApplication;
import com.person.liwei.entity.AppDataBase;
import com.person.liwei.phone.di.component.AppComponent;
import com.person.liwei.phone.di.component.DaggerAppComponent;
import com.person.liwei.phone.di.module.AppModule;
import com.person.liwei.phone.di.module.HttpModule;
import com.person.liwei.utils.Utils;

public class MyApplication extends AppApplication {

    public static Application mApplication;
    public static AppDataBase mAppDb;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
        mApplication = this;

        mAppDb = Room.databaseBuilder(this, AppDataBase.class, "message_info")
                .addMigrations()
                .allowMainThreadQueries()
                .build();

        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .httpModule(new HttpModule()).build();
    }

    public static MyApplication get(Context context){
        return (MyApplication)context.getApplicationContext();
    }

    public AppComponent getAppComponent(){

        return mAppComponent;
    }
}
