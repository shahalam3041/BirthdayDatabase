package com.example.shahalam.birthdaydatabase;

/**
 * Created by ShahAlam on 21-Dec-17.
 */

public class DataTemp {

    private int id;
    private String name;
    private String day;

    public DataTemp(String name, String day) {
        this.name = name;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
