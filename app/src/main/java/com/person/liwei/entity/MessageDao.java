package com.person.liwei.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created on 2019-08-24 13:47
 * Description:
 *
 * @author LiGuangwei
 */
@Dao
public interface MessageDao {

    @Insert
    void insertMultiMessage(MiniMessage... miniMessages);
    @Insert
    void insertMultiMessage(List<MiniMessage> miniMessages);

    @Query("SELECT messageId FROM  minimessage WHERE userId = :userId")
    List<Long> getUserMessageIds(long userId);

    @Query("SELECT * FROM minimessage WHERE userId = :userId ORDER BY times")
    List<MiniMessage> getUserMessages(long userId);


    @Query("SELECT * FROM minimessage ORDER BY times")
    List<MiniMessage> getAllMessages();

}
