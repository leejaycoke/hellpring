package com.hellpring.model;

import com.hellpring.model.annotations.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "post")
public class PostModel extends Model {

    private int id;

    private int userId;

    private UserModel user;

    private String title;

    private String content;

    private Timestamp regDate;

    private String regDateStr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    public String getRegDateStr() {
        return getRegDate().toString();
    }

    public void setRegDateStr(String regDateStr) {
        this.regDateStr = regDateStr;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
