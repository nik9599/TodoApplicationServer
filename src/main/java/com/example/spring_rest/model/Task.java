package com.example.spring_rest.model;

import java.util.Date;

public class Task {
  private Integer id;
  private String title;
  private String description;
  private Boolean completed;
  private Date updatedat;
  private String priority;
  private Integer userId;

    public Task() {}
  public Task(int id, String title, String description, Boolean completed, Date updatedAt, String priority, int userid){
     this.id = id;
     this.title = title;
     this.description = description;
     this.completed = completed;
     this.updatedat = updatedAt;
     this.priority = priority;
     this.userId = userid;
  }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
