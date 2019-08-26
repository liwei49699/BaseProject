package com.person.liwei.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created on 2019-08-24 13:49
 * Description:
 *
 * @author LiGuangwei
 */
@Entity
public class MiniMessage {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo
    private long messageId;
    @ColumnInfo
    private String hint;
    @ColumnInfo
    private long userId = 0;
    @ColumnInfo
    private long times = 0;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MiniMessage{" +
                "id=" + id +
                ", messageId=" + messageId +
                ", hint='" + hint + '\'' +
                ", userId=" + userId +
                ", times=" + times +
                '}';
    }
}
