package com.example.finalexam07600632.DB;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.finalexam07600632.model.login;

import java.util.List;
import androidx.room.*;

@Dao
public interface loginDAO {
    @Query("SELECT  * FROM login")
    List<login> getAll();

    @Insert
    void insert(login login);

}
