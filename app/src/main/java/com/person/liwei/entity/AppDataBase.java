package com.person.liwei.entity;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created on 2019-08-24 14:26
 * Description:
 *
 * @author LiGuangwei
 */
@Database(entities = {MiniMessage.class},version =1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract MessageDao messageDao();
}
