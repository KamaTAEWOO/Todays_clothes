package com.example.todayclothes.weatherdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;
//데이터베이스를 정의

@Database(entities = {NationWeatherTable.class}, version = 1) // 데이터베이스와 연관되 엔티티 지정

public abstract class AppDatabase extends RoomDatabase {
    public abstract NationWeatherDao nationWeatherDao();
}