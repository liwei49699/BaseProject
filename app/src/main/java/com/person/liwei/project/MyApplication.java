package com.person.liwei.project;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.example.baselibrary.AppApplication;
import com.person.liwei.entity.AppDataBase;
import com.person.liwei.utils.Utils;

public class MyApplication extends AppApplication {

    public static Application mApplication;
    public static AppDataBase mAppDb;

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
        mApplication = this;

        mAppDb = Room.databaseBuilder(this, AppDataBase.class, "message_info")
                .addMigrations()
                .allowMainThreadQueries()
                .build();
    }
}
