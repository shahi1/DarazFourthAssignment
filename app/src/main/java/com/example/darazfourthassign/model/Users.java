package com.example.darazfourthassign.model;

public class Users {
    private String FullName;
    private String Email;
    private String PhoneNo;
    private String Password;
    private String SMS;

    public Users(String fullName, String email, String password, String phoneNo, String sms) {
        FullName = fullName;
        Email = email;
        PhoneNo = phoneNo;
        Password = password;
        SMS = sms;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getPassword() {
        return Password;
    }

    public String getSMS() {
        return SMS;
    }

    public void setSMS(String SMS) {
        this.SMS = SMS;
    }

    public void setPassword(String password) {
        Password = password;
    }
}


