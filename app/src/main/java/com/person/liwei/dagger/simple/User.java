package com.person.liwei.dagger.simple;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String account;
    private String pwd;
    private int age;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.account);
        dest.writeString(this.pwd);
        dest.writeInt(this.age);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.account = in.readString();
        this.pwd = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
