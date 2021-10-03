package com.yillint.spring5.entity;

public class Book {

    private String userId;
    private String username;
    private String ustaus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUstaus() {
        return ustaus;
    }

    public void setUstaus(String ustatus) {
        this.ustaus = ustatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", ustatus='" + ustaus + '\'' +
                '}';
    }

}
