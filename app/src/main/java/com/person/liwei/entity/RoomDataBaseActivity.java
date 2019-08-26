package com.person.liwei.entity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.person.liwei.R;
import com.person.liwei.project.MyApplication;

import java.util.ArrayList;
import java.util.List;

public class RoomDataBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_data_base);

        MessageDao messageDao = MyApplication.mAppDb.messageDao();

        List<Long> userMessageIds = messageDao.getUserMessageIds(0);

        for (Long userMessageId : userMessageIds) {

            Log.d("--TAG--", "RoomDataBaseActivity onCreate()" + userMessageId);
        }

        Log.d("--TAG--", "RoomDataBaseActivity onCreate()===================");
        List<MiniMessage> messageList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {

            MiniMessage miniMessage = new MiniMessage();
            miniMessage.setUserId(i);
            miniMessage.setHint("提示信息" + i);
            miniMessage.setMessageId(i);
            miniMessage.setTimes(System.currentTimeMillis());
            messageList.add(miniMessage);
        }
        messageDao.insertMultiMessage(messageList);

        List<MiniMessage> userMessages = messageDao.getUserMessages(1);

        for (MiniMessage userMessage : userMessages) {

            Log.d("--TAG--", "RoomDataBaseActivity onCreate()" + userMessage.toString());
        }


        Log.d("--TAG--", "RoomDataBaseActivity onCreate()===================");

        List<MiniMessage> allMessages = messageDao.getAllMessages();
        for (MiniMessage allMessage : allMessages) {

            Log.d("--TAG--", "RoomDataBaseActivity onCreate()" + allMessage.toString()) ;
        }
    }
}
