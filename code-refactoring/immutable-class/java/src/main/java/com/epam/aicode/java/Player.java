package com.epam.aicode.java;

public class Player {

    private Integer age;
    private String email;
    private String phone;
    private String name;
    private String surname;

    public Player(Integer age, String email, String phone, String name, String surname) {
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
