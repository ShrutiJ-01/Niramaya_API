package com.niramaya.niramaya.entities;

public class User {
//new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    private String username;
    private String timestamp;
    private String deviceId;

    //default constructor
    public User() {
        username="";
        timestamp="";
        setDeviceId("");
    }

    //parameterized constructor
    public User(String username,String timestamp,String deviceId) {
        super();
        this.username = username;
        this.timestamp=timestamp;
        this.setDeviceId(deviceId);
    }

    //getter function for username
    public String getUsername() {
        return username;
    }

    //setter function for username
    public void setUsername(String username) {
        this.username = username;
    }

    //getter function for id
    public String getTimestamp() {
        return timestamp;
    }

    //setter function for id
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    //overriding to string method for user class
    @Override
    public String toString() {
        return "User [username=" + username + ", id=" + timestamp + ", getUsername()=" + getUsername() + ", getTimestamp()=" + getTimestamp()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }


}