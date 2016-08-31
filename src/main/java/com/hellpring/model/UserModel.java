package com.hellpring.model;

import com.hellpring.model.annotations.Table;

@Table(name = "user")
public class UserModel extends Model {

    private int id;

    private int email;

    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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