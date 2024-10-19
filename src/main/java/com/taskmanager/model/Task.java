package com.taskmanager.model;

import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String description;
    private Date dueDate;
    private boolean completed;

    public Task() {
        // デフォルトコンストラクタ
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // ゲッターとセッターを追加
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }


}
