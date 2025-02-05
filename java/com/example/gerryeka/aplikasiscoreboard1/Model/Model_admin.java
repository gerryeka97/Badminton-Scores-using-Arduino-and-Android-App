package com.example.gerryeka.aplikasiscoreboard1.Model;

/**
 * Created by gerry eka on 11/10/2019.
 */

public class Model_admin {
    String username,password;

    public Model_admin() {
    }

    public Model_admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
