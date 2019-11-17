package com.example.finalexam07600632.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.finalexam07600632.model.login;

@Database(entities = {login.class}, exportSchema = false, version = 1)
public abstract class AppDB extends RoomDatabase {

    private static final String DB_NAME = "login.db";

    public abstract loginDAO loginDAO();

    private static AppDB mInstance;

    public static synchronized AppDB getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room
                    .databaseBuilder(
                            context.getApplicationContext(),
                            AppDB.class,
                            DB_NAME
                    )
                    .build();
        }
        return mInstance;
    }
}

