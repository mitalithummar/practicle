package com.example.practical.Model;

public class Task {
    int _id;
    String Title;
    String Description;
    String RemindMe;
    String DueDate;

    public Task() {
    }

    public Task(int _id, String title, String description, String remindMe, String dueDate) {
        this._id = _id;
        Title = title;
        Description = description;
        RemindMe = remindMe;
        DueDate = dueDate;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRemindMe() {
        return RemindMe;
    }

    public void setRemindMe(String remindMe) {
        RemindMe = remindMe;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }
}