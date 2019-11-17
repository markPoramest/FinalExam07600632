package com.example.finalexam07600632.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "login")
public class login {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "fullName")
    public String fullName;
    @ColumnInfo(name = "username")
    public String username;
    @ColumnInfo(name = "password")
    public String password;

    public login(int id, String fullName, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }
}
