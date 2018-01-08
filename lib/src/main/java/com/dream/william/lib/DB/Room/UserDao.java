package com.dream.william.lib.DB.Room;

import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by william on 1/8/18.
 */

public interface UserDao {


    @Query("SELECT * FROM Users")
    List<User> getUsers();


}
