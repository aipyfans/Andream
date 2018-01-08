package com.dream.william.lib.DB.Room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;
import java.util.UUID;

/**
 * Created by william on 1/8/18.
 */
@Entity(tableName = "users")
public class User {

    @PrimaryKey
    @ColumnInfo(name = "userid")
    private String mId;


    @ColumnInfo(name = "username")
    private String mUserName;


    @ColumnInfo(name = "last_update")
    private Date mDate;


    @Ignore
    public User(String userName) {
        mId = UUID.randomUUID().toString();
        mUserName = userName;
        mDate = new Date(System.currentTimeMillis());
    }


    public User(String id, String userName, Date date) {
        this.mId = id;
        this.mUserName = userName;
        this.mDate = date;
    }


    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
