package com.example.sqlitestudentinfo;

public class StudentModel {


    String name, email, phone;
    float cgpa;
    int id;

    public StudentModel(int id) {

        this.id = id;
    }


    public StudentModel(String name, String email, String phone, float cgpa) {

        this.name = name;
        this.email = email;
        this.phone = phone;

        this.cgpa = cgpa;
    }

    public StudentModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
}
