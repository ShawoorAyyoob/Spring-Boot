package com.shawooracademy.springboot.firstapp.model;

public class Course {
    private String title;
    private String id;
    private String category;
    private int duration;

    public Course(String title, String id, String category, int duration) {
        this.title = title;
        this.id = id;
        this.category = category;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}


