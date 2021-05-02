package com.example.todayclothes.weatherdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

//테이블 쿼리
@Dao
public interface NationWeatherDao {

    @Query("SELECT * FROM NationWeatherTable")
    List<NationWeatherTable> getall(); // 현재 데이터베이스에 데이터가 들어가 있는 상태

    @Insert
    void insert(NationWeatherTable nationWeatherTable);

    @Query("DELETE FROM NationweatherTable")
    void deleteall();

    @Query("SELECT * FROM NationWeatherTable WHERE name1 = :name")
    List<NationWeatherTable> get(String name);
}