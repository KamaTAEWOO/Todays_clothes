package com.example.todayclothes.weatherdatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

//테이블을 정의
@Entity
public class NationWeatherTable implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public long code;           //행정구역코드
    public String name1;       //ex)서울특별시
    public String name2;       //ex)종로구,용산구,성동구
    public String name3;       //ex)사직동,심청도,부암동
    public int x;              //격자 X
    public int y;              //격자 Y

//    @ColumnInfo(name = "x")
//    public int x;
//
//    @ColumnInfo(name = "y")
//    public int y;


    // 생성자 생성
    public NationWeatherTable(long code, String name1, String name2, String name3, int x, int y) {
        this.code = code;
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.x = x;
        this.y = y;
    }

    //Getter and Setter
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public int getX() {
        if(this.x == 0) return 0;
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        if(this.y == 0) return 0;
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "NationWeatherTable{" +
                "code=" + code +
                ", name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

}

