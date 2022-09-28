package com.example.contacts;

public class Data {
    private int id;
    private String Name;
    private String Number;
    private String Email;

    public Data(String name, String number, String email) {
        Name = name;
        Number = number;
        Email = email;
    }
    public Data() {}

    public String getName() {
        return Name;
    }

    public String getNumber() {
        return Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
