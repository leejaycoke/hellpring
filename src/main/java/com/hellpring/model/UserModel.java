package com.hellpring.model;

import com.hellpring.model.annotations.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "user")
public class UserModel extends Model {

    private int id;

    private String email;

    private String password;

    private Timestamp regDate;

    private String regDateStr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegDate() {
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
        return "UserModel{" +
                "id=" + id +
                ", email=" + email +
                ", password='" + password + '\'' +
                '}';
    }
}
